package com.creatureox.qlexpress.operator;

import com.ql.util.express.Operator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CreatureOX
 * date: 2020/8/2
 * description:
 */
public class JoinOperator extends Operator {

    @Override
    public Object executeInner(Object[] objects) throws Exception {
        Object opdata1 = objects[0];
        Object opdata2 = objects[1];
        if (opdata1 instanceof List){
            ((List) opdata1).add(opdata2);
            return opdata1;
        }else {
            List result = new ArrayList();
            result.add(opdata1);
            result.add(opdata2);
            return result;
        }
    }

}
