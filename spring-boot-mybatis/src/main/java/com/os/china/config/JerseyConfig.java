package com.os.china.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="zhangpengfei@wxchina.com">ZhangPengFei</a>
 * @Discription
 * @Data 2017-4-7
 * @Version 1.0.0
 */
@Configuration
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		packages("com.os.china");
	}

}
