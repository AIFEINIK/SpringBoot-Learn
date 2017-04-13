package com.os.china.rest.service;

import com.os.china.domain.entity.Person;
import com.os.china.dto.QueryParameters;
import com.os.china.rest.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="zhangpengfei@wxchina.com">ZhangPengFei</a>
 * @Discription
 * @Data 2017-3-24
 * @Version 1.0.0
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    /**
     * 根据用户ID获取用户信息
     * @param id
     * @return
     */
    public Person getPersonById(int id) {
        return personRepo.getById(id);
    }

    /**
     * 查询用户总量，分页使用
     * @param params
     * @return
     */
    public int getPersonCount(QueryParameters params) {
        return personRepo.findResultCount(params);
    }

    /**
     * 分页查询用户信息
     * @param params
     * @return
     */
    public List<Person> getPersons(QueryParameters params) {
        return personRepo.findResults(params);
    }

    public Person getPersonByName(String userName) {
        return personRepo.getPersonByName(userName);
    }
}
