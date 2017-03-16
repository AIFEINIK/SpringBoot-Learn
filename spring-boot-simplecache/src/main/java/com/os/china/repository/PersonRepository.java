package com.os.china.repository;

import com.os.china.entiy.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-16
 * @Version 1.0.0
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
