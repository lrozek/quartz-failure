package pl.lrozek.quartz.failure.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import com.googlecode.flyway.core.Flyway;

public class DbConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        String url = "jdbc:h2:~/.quartz;AUTO_SERVER=TRUE";
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName( "org.h2.Driver" );
        dataSource.setUrl( url );
        dataSource.setUsername( "sa" );
        return dataSource;
    }

    @Lazy
    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        Flyway flyway = new Flyway();
        flyway.setDataSource( dataSource() );
        return flyway;
    }

}
