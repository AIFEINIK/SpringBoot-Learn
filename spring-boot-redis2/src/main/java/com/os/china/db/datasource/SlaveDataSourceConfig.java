package com.os.china.db.datasource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author <a href="zhangpengfei@wxchina.com">ZhangPengFei</a>
 * @Discription 存库数据源配置
 * @Data 2017-3-24
 * @Version 1.0.0
 */
public class SlaveDataSourceConfig {

    @Value("${mybatis.config-location}")
    private String mybatisConfigLocation;

    @Autowired
    private SlaveDsConfig config;

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "datasource.slave")
    public DataSource slaveDataSource() {
        BasicDataSource ds = (BasicDataSource) DataSourceBuilder.create().type(BasicDataSource.class).build();
        ds.setMaxTotal(config.getMaxTotal());
        ds.setMaxIdle(config.getMaxIdle());
        ds.setMinIdle(config.getMinIdle());
        ds.setInitialSize(config.getInitialSize());
        ds.setValidationQuery(config.getValidationQuery());
        ds.setTestWhileIdle(config.isTestWhileIdle());
        ds.setTestOnBorrow(config.isTestOnBorrow());
        ds.setTestOnReturn(config.isTestOnReturn());
        ds.setMaxWaitMillis(config.getMaxWaitMillis());
        // ds.setTimeBetweenEvictionRunsMillis(config.getTimeBetweenEvictionRunsMillis());
        // ds.setNumTestsPerEvictionRun(config.getNumTestsPerEvictionRun());
        // ds.setMinEvictableIdleTimeMillis(config.getMinEvictableIdleTimeMillis());
        ds.setDefaultAutoCommit(false);
        return ds;
    }

    @Bean(name = "slaveTransactionManager")
    public DataSourceTransactionManager slaveTransactionManager(@Qualifier("slaveDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "slaveSqlSessionFactory")
    public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource dataSource)
            throws Exception {
        String path = mybatisConfigLocation.replace("classpath:", "/");
        ClassPathResource resource = new ClassPathResource(path);
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setConfigLocation(resource);
        return factory.getObject();
    }

    @Bean(name = "slaveSqlSessionTemplate")
    public SqlSessionTemplate slaveSqlSessionTemplate(
            @Qualifier("slaveSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
}
