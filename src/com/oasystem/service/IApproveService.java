package com.oasystem.service;

import java.util.Map;

/**
 * 审批模块 service接口
 * @author TcWong
 *
 */
public interface IApproveService {
	
	/**
	 * 查询所有的未审批文件
	 * @param name
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> findAll(String name) throws Exception;

}
