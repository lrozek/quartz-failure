package pl.lrozek.quartz.failure.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.googlecode.flyway.core.Flyway;

@Configuration
@PropertySource("classpath:db.props")
public class DbConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName( driverClassName );
        dataSource.setUrl( url );
        dataSource.setUsername( username );
        return dataSource;
    }

    @Lazy
    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        Flyway flyway = new Flyway();
        flyway.setDataSource( dataSource() );
        return flyway;
    }

    @Value("${url}")
    private String url;

    @Value("${driverClassName}")
    private String driverClassName;

    @Value("${username}")
    private String username;

}
