package pl.lrozek.quartz.failure.jobs.job2;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingJob implements Job {

    @Override
    public void execute( JobExecutionContext context ) throws JobExecutionException {
        logger.info( "executing job {} with recovoery flag {}", context.getJobDetail().getKey().getName(), context.isRecovering() );
    }

    public static final String LOGGING_JOB_NAME = "loggingJob";

    private Logger logger = LoggerFactory.getLogger( getClass() );

}
