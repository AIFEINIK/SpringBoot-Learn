package com.os.china.db.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="zhangpengfei@wxchina.com">ZhangPengFei</a>
 * @Discription 公共DS配置
 * @Data 2017-3-24
 * @Version 1.0.0
 */
public class DsConfig {

	private String name;

	// 可以在连接池中同时被分配的有效连接数的最大值，如设置为负数，则不限制
	private int maxTotal = 8;

	// 可以在连接池中保持空闲的最大连接数，超出设置值之外的空闲连接将被回收，如设置为负数，则不限制
	private int maxIdle = 8;

	// 可以在连接池中保持空闲的最小连接数，超出设置值之外的空闲连接将被创建，如设置为0，则不创建
	private int minIdle = 0;

	// 当这个连接池被启动时初始化的创建的连接个数
	private int initialSize = 0;

	// 在连接池返回连接给调用者前用来进行连接校验的查询sql。如果指定，则这个查询必须是一个至少返回一行数据的SQL
	// SELECT语句。如果没有指定，则连接将通过调用isValid() 方法进行校验。
	private String validationQuery;

	// 指明对象是否需要通过对象驱逐者进行校验（如果有的话），假如一个对象校验失败，则对象将被从连接池中释放。
	private boolean testWhileIdle = false;

	// 指明在从连接池中租借对象时是否要进行校验，如果对象校验失败，则对象将从连接池释放，然后我们将尝试租借另一个
	private boolean testOnBorrow = true;// false?

	// 指明在将对象归还给连接池前是否需要校验。
	private boolean testOnReturn = false;

	// （如果没有可用连接）连接池在抛出异常前等待的一个连接被归还的最大毫秒数，设置为-1则等待时间不确定
	private long maxWaitMillis = -1;

	// 空闲对象驱逐线程运行时的休眠毫秒数，如果设置为非正数，则不运行空闲对象驱逐线程
	private long timeBetweenEvictionRunsMillis = -1;

	// 在每个空闲对象驱逐线程运行过程中中进行检查的对象个数。（如果有的话）
	private int numTestsPerEvictionRun = 3;

	// 符合对象驱逐对象驱逐条件的对象在池中最小空闲毫秒总数（如果有的话）
	private long minEvictableIdleTimeMillis = 1000 * 60 * 30;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public boolean isTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public long getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(long maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public long getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public int getNumTestsPerEvictionRun() {
		return numTestsPerEvictionRun;
	}

	public void setNumTestsPerEvictionRun(int numTestsPerEvictionRun) {
		this.numTestsPerEvictionRun = numTestsPerEvictionRun;
	}

	public long getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(long minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	@Override
	public String toString() {
		return "DsConfig [name=" + name + ", maxTotal=" + maxTotal + ", maxIdle=" + maxIdle + ", minIdle=" + minIdle
				+ ", initialSize=" + initialSize + ", validationQuery=" + validationQuery + ", testWhileIdle="
				+ testWhileIdle + ", testOnBorrow=" + testOnBorrow + ", testOnReturn=" + testOnReturn
				+ ", maxWaitMillis=" + maxWaitMillis + ", timeBetweenEvictionRunsMillis="
				+ timeBetweenEvictionRunsMillis + ", numTestsPerEvictionRun=" + numTestsPerEvictionRun
				+ ", minEvictableIdleTimeMillis=" + minEvictableIdleTimeMillis + "]";
	}

}
