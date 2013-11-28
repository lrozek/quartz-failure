package pl.lrozek.quartz.failure.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.lrozek.quartz.failure.config.Bootstrap;

public class SchedulerWithoutJobsMain {

    public static void main( String[] args ) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext( Bootstrap.class );

    }

}
