package everything.algorithms.byRobertLafore.ch04.notation.operator;

import everything.algorithms.byRobertLafore.ch04.notation.Operator;

/**
 * Created by mcalancea on 23 Jun 2016.
 */
public class Multiply implements Operator {
    @Override
    public String getOperatorSymbol() {
        return "*";
    }

    @Override
    public int getPrecedence() {
        return 2;
    }
}
