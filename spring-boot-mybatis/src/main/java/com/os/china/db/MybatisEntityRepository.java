package com.os.china.db;

import com.os.china.domain.Entity;
import com.os.china.dto.QueryParameters;
import com.os.china.exception.RepositoryException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * @author <a href="zhangpengfei@wxchina.com">ZhangPengFei</a>
 * @Discription 基于MyBatis的基本仓储实现
 * @Data 2017-3-24
 * @Version 1.0.0
 */
public abstract class MybatisEntityRepository<T extends Entity> implements EntityRepository<T> {

	protected final static Logger logger = LoggerFactory.getLogger(MybatisEntityRepository.class);

	protected SqlSessionFactory sqlSessionFactory;

	protected abstract void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory);

	//自定义Mybatis的sql配置文件中的访问命名空间
	protected abstract String nameSpaceForSqlId();

	//自定义Mybatis的sql配置文件中的SqlId
	protected String fullSqlId(String sqlId) {
		return nameSpaceForSqlId() + "." + sqlId;
	}

	@Override
	public T insert(T t) throws RepositoryException {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.insert(fullSqlId("insert"), t);
			session.commit(true);
		} catch (Exception e) {
			logger.error("Insert Entity failed: ", e);
			throw new RepositoryException(e);
		}
		return t;
	}

	@Override
	public int update(T t) throws RepositoryException {
		int ret = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			ret = session.update(fullSqlId("update"), t);
			session.commit(true);
		} catch (Exception e) {
			logger.error("Update Entity failed: ", e);
			throw new RepositoryException(e);
		}
		return ret;
	}

	@Override
	public T save(T t) throws RepositoryException {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			int ret = 0;
			if (t.getId() != null) {
				ret = session.update(fullSqlId("update"), t);
			}
			if (ret == 0) {
				ret = session.insert(fullSqlId("insert"), t);
			}
			session.commit(true);
		} catch (Exception e) {
			logger.error("Save/Update Entity failed: ", e);
			throw new RepositoryException(e);
		}
		return t;
	}

	@Override
	public int updateSpecify(T t) throws RepositoryException {
		int count = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			count = session.update(fullSqlId("updateSpecify"), t);
			session.commit(true);
		} catch (Exception e) {
			logger.error("UpdateSpecify Entity failed: ", e);
			throw new RepositoryException(e);
		}
		return count;
	}

	@Override
	public int deleteById(Integer id) throws RepositoryException {
		int count = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			count = session.delete(fullSqlId("deleteById"), id);
			session.commit(true);
		} catch (Exception e) {
			logger.error("Remove Entity failed: ", e);
			throw new RepositoryException(e);
		}
		return count;
	}

	@Override
	public int delete(T t) throws RepositoryException {
		int count = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			count = session.delete(fullSqlId("delete"), t);
			session.commit(true);
		} catch (Exception e) {
			logger.error("Remove Entity failed: ", e);
			throw new RepositoryException(e);
		}
		return count;
	}

	@Override
	public T getById(Integer id) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectOne(fullSqlId("getById"), id);
		}
	}

	@Override
	public int findResultCount(QueryParameters params) {
		if (params == null) { // 纠错
			params = new QueryParameters();
		}
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectOne(fullSqlId("findResultCount"), params);
		}
	}

	@Override
	public List<T> findResults(QueryParameters params) {
		if (params == null) { // 纠错
			params = new QueryParameters();
		}
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectList(fullSqlId("findResults"), params);
		}
	}

}
