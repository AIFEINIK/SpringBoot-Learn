package com.os.china.db.datasource;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="zhangpengfei@wxchina.com">ZhangPengFei</a>
 * @Discription 存库配置
 * @Data 2017-3-24
 * @Version 1.0.0
 */
@Configuration
@ConfigurationProperties("datasource.slave")
public class SlaveDsConfig extends DsConfig {
    
}
