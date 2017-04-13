package com.os.china.db;

import com.os.china.db.MybatisEntityRepository;
import com.os.china.domain.Entity;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class MasterMybatisEntityRepository<T extends Entity> extends MybatisEntityRepository<T> {

    @Autowired
    @Qualifier("masterSqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
