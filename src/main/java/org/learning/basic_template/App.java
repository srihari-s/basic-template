package org.learning.basic_template;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.learning.basic_template.config.DBConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.register(DBConfig.class);
        appContext.getEnvironment().setActiveProfiles("prod");
        appContext.refresh();
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db/schema.sql"));
        populator.addScript(new ClassPathResource("db/data.sql"));
        populator.execute(appContext.getBean(DataSource.class));
        JdbcTemplate jdbcTemplate = new JdbcTemplate((javax.sql.DataSource) appContext.getBean(DataSource.class));
        Integer userCount = jdbcTemplate.queryForObject("select count(*) from auth", Integer.class);
        System.out.println(userCount);
        logger.info("There are {} users.", userCount);
        
    }
}
