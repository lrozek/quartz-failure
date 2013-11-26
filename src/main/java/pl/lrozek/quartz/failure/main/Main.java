package pl.lrozek.quartz.failure.main;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.lrozek.quartz.failure.config.DbConfig;

public class Main {

    public static void main( String[] args ) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext( DbConfig.class );
        DataSource dataSource = applicationContext.getBean( DataSource.class );
    }

}
