package com.os.china.db;

import com.os.china.domain.Entity;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class SlaveMybatisEntityRepository<T extends Entity> extends MybatisEntityRepository<T> {

    @Autowired
    @Qualifier("slaveSqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
