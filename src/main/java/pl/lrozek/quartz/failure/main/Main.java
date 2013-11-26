package pl.lrozek.quartz.failure.main;

import javax.sql.DataSource;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.lrozek.quartz.failure.config.DbConfig;

public class Main {

    public static void main( String[] args ) throws SchedulerException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext( DbConfig.class );
        DataSource dataSource = applicationContext.getBean( DataSource.class );
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        scheduler.start();
    }

}
