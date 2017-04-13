package com.os.china.rest.repo;

import com.os.china.db.MasterMybatisEntityRepository;
import com.os.china.db.MybatisEntityRepository;
import com.os.china.domain.entity.Person;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author <a href="zhangpengfei@wxchina.com">ZhangPengFei</a>
 * @Discription
 * @Data 2017-3-24
 * @Version 1.0.0
 */
@Repository
public class PersonRepo extends MasterMybatisEntityRepository<Person> {

    @Override
    protected String nameSpaceForSqlId() {
        //这里配置的namespace与PersonMapper.xml中的namespace要保持一致
        return "com.os.china.mapper.PersonMapper";
    }

    /**
     * Mybatis基本仓储中没有的可以自己写
     * @param userName
     * @return
     */
    public Person getPersonByName(String userName) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne(fullSqlId("getPersonByName"), userName);
        }
    }
}
