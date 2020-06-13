package com.example.mallmall;

import org.springframework.context.support.GenericXmlApplicationContext;

import simple.Greeter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
        Greeter greeter = ctx.getBean("greeter", Greeter.class);
        greeter.setFormat("%s, 안녕하세요!");
        String msg = greeter.greet("스프링");
        System.out.println( msg );
        ctx.close();
    }
}
