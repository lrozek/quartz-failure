package pl.lrozek.quartz.failure.jobs.job1;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobImpl implements Job {

    public void execute( JobExecutionContext context ) throws JobExecutionException {
        logger.info( "executing job {} with recovoery flag {}", context.getJobDetail().getKey().getName(), context.isRecovering() );
        throw new JobExecutionException( true );

    }

    public static final String JOB_IMPL_NAME = "JobImplName";

    private Logger logger = LoggerFactory.getLogger( getClass() );

}
