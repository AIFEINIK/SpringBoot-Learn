package com.os.china.db;

import com.os.china.domain.Entity;
import com.os.china.dto.QueryParameters;
import com.os.china.exception.RepositoryException;

import java.util.List;

/**
 * @author <a href="zhangpengfei@wxchina.com">ZhangPengFei</a>
 * @Discription 仓储访问接口, 提供通用仓储方法
 * @Data 2017-3-24
 * @Version 1.0.0
 */
public interface EntityRepository<T extends Entity> {

	// 添加一个实体
	public T insert(T t) throws RepositoryException;

	// gen一个实体
	public int update(T t) throws RepositoryException;

	// 添加一个实体(update and insert)
	public T save(T t) throws RepositoryException;

	// 更新一个实体
	public int updateSpecify(T t) throws RepositoryException;

	// 移除一个实体
	public int delete(T t) throws RepositoryException;

	// 根据实体ID，删除实体
	public int deleteById(Integer id) throws RepositoryException;

	// 根据实体ID，查找实体
	public T getById(Integer id);

	// 查询符合查询参数的实体结果集数量
	public int findResultCount(QueryParameters param);

	// 查询符合查询参数的实体结果集
	public List<T> findResults(QueryParameters param);

}
