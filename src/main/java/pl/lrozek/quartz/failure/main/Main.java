package pl.lrozek.quartz.failure.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.lrozek.quartz.failure.config.Bootstrap;

public class Main {

    public static void main( String[] args ) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext( Bootstrap.class );
        System.out.println( applicationContext );

    }

}
