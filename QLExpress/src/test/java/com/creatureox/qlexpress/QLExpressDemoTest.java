package com.creatureox.qlexpress;

import com.creatureox.qlexpress.operator.JoinOperator;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.DynamicParamsUtil;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class QLExpressDemoTest {

    @Test
    public void simpleTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("a", 1);
        context.put("b", 2);
        context.put("c", 3);
        String express = "a+b*c";
        Object r = runner.execute(express, context, null, true, false);
        log.info("{}", r);
    }

    @Test
    public void functionTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        String functionScript = "function add(int a,int b){\n" +
                "  return a+b;\n" +
                "};\n" +
                "\n" +
                "function sub(int a,int b){\n" +
                "  return a - b;\n" +
                "};\n" +
                "\n" +
                "a=10;\n" +
                "return add(a,4) + sub(a,9);";
        log.info("script: \n{}", functionScript);
        Object r = runner.execute(functionScript, context, null, true, false);
        log.info("{}", r);
    }

    @Test
    public void operatorTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("语文", 90);
        context.put("数学", 90);
        context.put("英语", 90);
        runner.addOperatorWithAlias("如果", "if", null);
        runner.addOperatorWithAlias("则", "then", null);
        runner.addOperatorWithAlias("否则", "else", null);
        String express = "如果  (语文+数学+英语>270) 则 {return 1;} 否则 {return 0;}";
        Object r = runner.execute(express, context, null, true, false);
        log.info("{}", r);
    }

    @Test
    public void customOperatorTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        runner.addOperator("join",new JoinOperator());
        Object r = runner.execute("1 join 2 join 3", context, null, false, false);
        log.info("{}", r);
    }

    @Test
    public void addFunctionOfClassOrServiceMethod() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        runner.addFunctionOfClassMethod("取绝对值", Math.class.getName(), "abs",
                new String[] { "double" }, null);
        runner.addFunctionOfServiceMethod("打印", System.out, "println",new String[] { "String" }, null);
        String express = "取绝对值(-100);打印(\"你好吗？\");";
        Object r = runner.execute(express, context, null, false, false);
        log.info("{}", r);
    }

    @Test
    public void macroTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        IExpressContext<String, Object> context =new DefaultContext<>();
        runner.addMacro("计算平均成绩", "(语文+数学+英语)/3.0");
        runner.addMacro("是否优秀", "计算平均成绩>90");
        context.put("语文", 88);
        context.put("数学", 99);
        context.put("英语", 95);
        Object r = runner.execute("是否优秀", context, null, false, false);
        log.info("{}", r);
    }

    @Test
    public void compileScript() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        IExpressContext<String, Object> context =new DefaultContext<>();
        context.put("语文", 88);
        context.put("数学", 99);
        context.put("英语", 95);
        String express = "int 平均分 = (语文+数学+英语)/3.0;return 平均分";
        String[] names = runner.getOutVarNames(express);
        for(String s:names){
            log.info("var: {}", s);
        }
    }

    @Test
    public void testMethodReplace() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        IExpressContext<String,Object> expressContext = new DefaultContext<>();
        runner.addFunctionOfServiceMethod("getTemplate", this, "getTemplate", new Class[]{Object[].class}, null);

        //(1)默认的不定参数可以使用数组来代替
        Object r = runner.execute("getTemplate([11,'22',33L,true])", expressContext, null,false, false);
        System.out.println(r);
        //(2)像java一样,支持函数动态参数调用,需要打开以下全局开关,否则以下调用会失败
        DynamicParamsUtil.supportDynamicParams = true;
        r = runner.execute("getTemplate(11,'22',33L,true)", expressContext, null,false, false);
        System.out.println(r);
    }

    public Object getTemplate(Object... params) throws Exception{
        String result = "";
        for(Object obj:params){
            result = result+obj+",";
        }
        return result;
    }

    @Test
    public void testSet() throws Exception {
        ExpressRunner runner = new ExpressRunner(false,false);
        DefaultContext<String, Object> context = new DefaultContext<>();
        String express = "abc = NewMap(1:1,2:2); return abc.get(1) + abc.get(2);";
        Object r = runner.execute(express, context, null, false, false);
        System.out.println(r);
        express = "abc = NewList(1,2,3); return abc.get(1)+abc.get(2)";
        r = runner.execute(express, context, null, false, false);
        System.out.println(r);
        express = "abc = [1,2,3]; return abc[1]+abc[2];";
        r = runner.execute(express, context, null, false, false);
        System.out.println(r);
    }

}
