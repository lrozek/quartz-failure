package pl.lrozek.quartz.failure.config;

import static pl.lrozek.quartz.failure.config.DbConfig.dbMigration;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class QuartzConfig {

    @DependsOn(dbMigration)
    @Bean
    public Scheduler scheduler() throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        scheduler.start();
        return scheduler;
    }

}
