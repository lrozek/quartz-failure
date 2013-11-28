package pl.lrozek.quartz.failure.jobs.job1;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static pl.lrozek.quartz.failure.jobs.job1.JobImpl.JOB_IMPL_NAME;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Job1Configurarot {

    @Bean(name = JOB_IMPL_NAME_JOB_DETAIL_NAME)
    public JobDetail jobDetail() {
        return newJob( JobImpl.class ).withIdentity( JOB_IMPL_NAME ).storeDurably().requestRecovery().build();
    }

    @Bean(name = JOB_IMPL_NAME_TRIGGER)
    public Trigger trigger() {
        return newTrigger().build();
    }

    public static final String JOB_IMPL_NAME_JOB_DETAIL_NAME = JOB_IMPL_NAME + "jobDetail";

    public static final String JOB_IMPL_NAME_TRIGGER = JOB_IMPL_NAME + "Trigger";

}
