package com.firefly.drools.test;


import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.Resource;
import org.drools.io.ResourceFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.runtime.StatefulKnowledgeSession;

import java.util.Iterator;


/**
 * Created by walter on 16/6/14.
 */
public class DroolsTest1 {

    public static void main(String[] args){
        KnowledgeBuilder knowledgeBuilder=KnowledgeBuilderFactory.newKnowledgeBuilder();
        Resource resource=ResourceFactory.newClassPathResource("test.drl");
        knowledgeBuilder.add(resource, ResourceType.DRL);
        if(knowledgeBuilder.hasErrors()){
            System.out.println("规则错误：");
            Iterator<KnowledgeBuilderError> it = knowledgeBuilder.getErrors().iterator();
            while (it.hasNext()) System.out.println(it.next());
            return;
        }

        KnowledgeBase base =KnowledgeBaseFactory.newKnowledgeBase();
        base.addKnowledgePackages(knowledgeBuilder.getKnowledgePackages());
        StatefulKnowledgeSession session=base.newStatefulKnowledgeSession();

        User user=new User();
        user.setMoney(50);
        session.insert(user);
        session.fireAllRules();
        session.dispose();

    }
}
