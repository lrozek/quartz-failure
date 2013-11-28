package pl.lrozek.quartz.failure.scheduler;

import static com.google.common.collect.Sets.newHashSet;
import static pl.lrozek.quartz.failure.jobs.Constants.JOB_DETAIL;
import static pl.lrozek.quartz.failure.jobs.Constants.Trigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ManualScheduler {

    @Autowired
    public ManualScheduler( Scheduler scheduler, ApplicationContext applicationContext ) {
        this.scheduler = scheduler;
        this.applicationContext = applicationContext;
    }

    public void schedule( String jobName ) throws SchedulerException {
        JobDetail jobDetail = applicationContext.getBean( jobName + JOB_DETAIL, JobDetail.class );
        Trigger trigger = applicationContext.getBean( jobName + Trigger, Trigger.class );
        scheduler.scheduleJob( jobDetail, newHashSet( trigger ), true );
    }

    private Scheduler scheduler;

    private ApplicationContext applicationContext;

}
