package pl.lrozek.quartz.failure.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;

public class DbConfig {

    @Bean
    public DataSource dataSource() {
        String url = "jdbc:h2:~/.quartz;AUTO_SERVER=TRUE";
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName( "org.h2.Driver" );
        dataSource.setUrl( url );
        dataSource.setUsername( "sa" );
        return dataSource;
    }

}
