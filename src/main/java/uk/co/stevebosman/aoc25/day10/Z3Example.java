package uk.co.stevebosman.aoc25.day10;

import com.microsoft.z3.Context;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.IntNum;
import com.microsoft.z3.Model;
import com.microsoft.z3.Optimize;
import com.microsoft.z3.Status;

/// Implement 1st part 2 example in z3.
///
/// ```text
/// [.##.] (3)  (1,3) (2)  (2,3) (0,2) (0,1) {3,5,4,7}
///        btn1 btn2  btn3 btn4  btn4  btn5
/// ```
/// * btn5Presses + btn6Presses = 3
/// * btn2Presses + btn6Presses = 5
/// * btn3Presses + btn4Presses + btn5Presses = 4
/// * btn1Presses + btn2Presses + btn4Presses = 7
///
/// where:
/// * btn1Presses >= 0
/// * btn2Presses >= 0
/// * btn3Presses >= 0
/// * btn4Presses >= 0
/// * btn5Presses >= 0
public class Z3Example {
  static void main() {
    try (final Context ctx = new Context()) {
      final IntExpr btn1Presses = ctx.mkIntConst("btn1Presses");
      final IntExpr btn2Presses = ctx.mkIntConst("btn2Presses");
      final IntExpr btn3Presses = ctx.mkIntConst("btn3Presses");
      final IntExpr btn4Presses = ctx.mkIntConst("btn4Presses");
      final IntExpr btn5Presses = ctx.mkIntConst("btn5Presses");
      final IntExpr btn6Presses = ctx.mkIntConst("btn6Presses");
      final IntExpr totalPresses = ctx.mkIntConst("totalPresses");

      final Optimize optimize = ctx.mkOptimize();
      final IntNum zero = ctx.mkInt(0);
      optimize.Add(ctx.mkGe(btn1Presses, zero));
      optimize.Add(ctx.mkGe(btn2Presses, zero));
      optimize.Add(ctx.mkGe(btn3Presses, zero));
      optimize.Add(ctx.mkGe(btn4Presses, zero));
      optimize.Add(ctx.mkGe(btn5Presses, zero));
      optimize.Add(ctx.mkGe(btn6Presses, zero));
      optimize.Add(ctx.mkGe(totalPresses, zero));
      optimize.Add(ctx.mkEq(ctx.mkAdd(btn5Presses, btn6Presses), ctx.mkInt(3)));
      optimize.Add(ctx.mkEq(ctx.mkAdd(btn2Presses, btn6Presses), ctx.mkInt(5)));
      optimize.Add(ctx.mkEq(ctx.mkAdd(btn3Presses, btn4Presses, btn5Presses), ctx.mkInt(4)));
      optimize.Add(ctx.mkEq(ctx.mkAdd(btn1Presses, btn2Presses, btn4Presses), ctx.mkInt(7)));
      optimize.Add(ctx.mkEq(totalPresses,
                            ctx.mkAdd(btn1Presses, btn2Presses, btn3Presses, btn4Presses, btn5Presses, btn6Presses)));

      optimize.MkMinimize(totalPresses);

      if (optimize.Check() == Status.SATISFIABLE) {
        final Model model = optimize.getModel();
        final IntNum result = (IntNum) model.evaluate(totalPresses, false);
        System.out.printf("result = %d%n", result.getInt());
      }
    }
  }
}

