package pl.lrozek.quartz.failure.main;

import static pl.lrozek.quartz.failure.jobs.job1.JobImpl.JOB_IMPL_NAME;

import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.lrozek.quartz.failure.config.Bootstrap;
import pl.lrozek.quartz.failure.scheduler.ManualScheduler;

public class InitifiveLoopMain {

    public static void main( String[] args ) throws SchedulerException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext( Bootstrap.class );
        ManualScheduler manualScheduler = applicationContext.getBean( ManualScheduler.class );
        manualScheduler.schedule( JOB_IMPL_NAME );
    }
}
