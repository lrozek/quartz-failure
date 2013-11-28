package pl.lrozek.quartz.failure.jobs.job2;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static pl.lrozek.quartz.failure.jobs.Constants.JOB_DETAIL;
import static pl.lrozek.quartz.failure.jobs.Constants.Trigger;
import static pl.lrozek.quartz.failure.jobs.job2.LoggingJob.LOGGING_JOB_NAME;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingJobConfigurator {

    @Bean(name = LOGGING_JOB_NAME_JOB_DETAIL_NAME)
    public JobDetail jobDetail() {
        return newJob( LoggingJob.class ).withIdentity( LOGGING_JOB_NAME ).storeDurably().requestRecovery().build();
    }

    @Bean(name = LOGGING_JOB_NAME_TRIGGER)
    public Trigger trigger() {
        return newTrigger().build();
    }

    public static final String LOGGING_JOB_NAME_JOB_DETAIL_NAME = LOGGING_JOB_NAME + JOB_DETAIL;

    public static final String LOGGING_JOB_NAME_TRIGGER = LOGGING_JOB_NAME + Trigger;

}
