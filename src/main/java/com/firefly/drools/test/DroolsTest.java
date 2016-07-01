package com.firefly.drools.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.WorkingMemory;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;

/**
 * 类DroolsTest.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年6月8日 下午3:54:43
 */
public class DroolsTest {

    public static void main(String[] args) {
        RuleBase ruleBase = readRule();
        WorkingMemory workMemory = ruleBase.newStatefulSession();
        Message message = new Message();
        message.setInfo("Hello World!!!");
        message.setStatus(Message.HELLO);
        workMemory.insert(message);
        workMemory.fireAllRules();

    }

    public static RuleBase readRule() {
        // 读写DRL文件
        Reader source = new InputStreamReader(DroolsTest.class.getResourceAsStream("/MsgRule.drl"));
        PackageBuilder builder = new PackageBuilder();
        try {
            builder.addPackageFromDrl(source);
            RuleBase ruleBase = RuleBaseFactory.newRuleBase();
            ruleBase.addPackage(builder.getPackage());
            return ruleBase;
        } catch (DroolsParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
