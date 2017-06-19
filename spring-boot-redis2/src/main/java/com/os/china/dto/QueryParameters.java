package com.os.china.dto;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="zhangpengfei@wxchina.com">ZhangPengFei</a>
 * @Discription 查询参数
 * @Data 2017-3-24
 * @Version 1.0.0
 */
public class QueryParameters {

	private Map<String, Object> params = new HashMap<String, Object>();

	private Map<String, String> sorts = new HashMap<String, String>();

	public QueryParameters() {
	}

	public QueryParameters(PageReq req) {
		this.addParams(req.getParams());
		this.addSorts(req.getSorts());
	}

	private PageInfo page;

	/**
	 * 添加一个命名参数
	 *
	 * @param key 参数名称
	 * @param value 参数值
	 * @return 当前对象本身
	 */
	public QueryParameters addParam(String key, Object value) {
		if (StringUtils.isBlank(key)) {
			return this;
		}
		if (value == null || "".equals(value)) {
			return this;
		}
		params.put(key, value);
		return this;
	}

	/**
	 * 添加一组命名参数
	 *
	 * @param params 其它参数MAP
	 * @return 当前对象本身
	 */
	private QueryParameters addParams(Map<String, Object> params) {
		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				addParam(entry.getKey(), entry.getValue());
			}
		}
		return this;
	}

	/**
	 * 添加一个排序参数
	 *
	 * @param key 参数名称
	 * @param ascDesc 升序或降序
	 * @return 当前对象本身
	 */
	public QueryParameters addSort(String key, String ascDesc) {
		if (StringUtils.isBlank(key)) {
			return this;
		}
		if (StringUtils.isBlank(ascDesc)) {
			return this;
		}
		if ("asc".equalsIgnoreCase(ascDesc)) {
			sorts.put(key, "asc");
		} else if ("desc".equalsIgnoreCase(ascDesc)) {
			sorts.put(key, "desc");
		}
		return this;
	}

	/**
	 * 添加一组排序参数
	 *
	 * @param key 参数名称
	 * @param ascDesc 升序或降序
	 * @return 当前对象本身
	 */
	private QueryParameters addSorts(Map<String, String> sorts) {
		if (sorts != null && !sorts.isEmpty()) {
			for (Map.Entry<String, String> entry : sorts.entrySet()) {
				addSort(entry.getKey(), entry.getValue());
			}
		}
		return this;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public Map<String, String> getSorts() {
		return sorts;
	}

	public PageInfo getPage() {
		return page;
	}

	public void setPage(PageInfo page) {
		this.page = page;
	}

}
