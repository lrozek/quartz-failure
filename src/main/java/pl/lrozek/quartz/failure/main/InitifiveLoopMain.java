package pl.lrozek.quartz.failure.main;

import static com.google.common.collect.Sets.newHashSet;
import static pl.lrozek.quartz.failure.jobs.job1.Job1Configurarot.JOB_IMPL_NAME_JOB_DETAIL_NAME;
import static pl.lrozek.quartz.failure.jobs.job1.Job1Configurarot.JOB_IMPL_NAME_TRIGGER;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.lrozek.quartz.failure.config.Bootstrap;

public class InitifiveLoopMain {

    public static void main( String[] args ) throws SchedulerException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext( Bootstrap.class );
        Scheduler scheduler = applicationContext.getBean( Scheduler.class );
        JobDetail jobDetail = applicationContext.getBean( JOB_IMPL_NAME_JOB_DETAIL_NAME, JobDetail.class );
        Trigger trigger = applicationContext.getBean( JOB_IMPL_NAME_TRIGGER, Trigger.class );
        scheduler.scheduleJob( jobDetail, newHashSet( trigger ), true );
    }
}
