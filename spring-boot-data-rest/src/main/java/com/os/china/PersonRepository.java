package com.os.china;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-14
 * @Version 1.0.0
 */
//配置rest服务访问路径
@RepositoryRestResource(path = "people")
public interface PersonRepository extends JpaRepository<Person, Long> {
	//使用@RestResource注解将findByNameStartsWith方法暴露为rest服务
	@RestResource(path = "nameStartsWith", rel = "nameLinkStartsWith")
	List<Person> findByNameStartsWith(@Param("name") String name);
}
