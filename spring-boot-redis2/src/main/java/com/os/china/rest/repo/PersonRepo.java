package com.os.china.rest.repo;

import com.os.china.db.MasterMybatisEntityRepository;
import com.os.china.domain.entity.Person;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

    public Person getPersonByName(String name) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne(fullSqlId("getPersonByName"), name);
        }
    }

    public Person savePerson(Person person) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert(fullSqlId("savePerson"), person);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            logger.error("Save person failed, cause:{}", e);
        } finally {
            session.close();
        }
        return person;
    }

    public int existPersonName(Person person) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne(fullSqlId("existPersonName"), person);
        }
    }

    public int removePersonByName(String username) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = 0;
        try {
            count = session.delete(fullSqlId("removePersonByName"), username);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            logger.error("Remove person failed, cause:{}", e);
        } finally {
            session.close();
        }
        return count;
    }
}
