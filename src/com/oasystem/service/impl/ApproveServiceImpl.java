package com.oasystem.service.impl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oasystem.bean.Mtroomapply;
import com.oasystem.dao.IApproveDao;
import com.oasystem.dao.impl.ApproveDaoImpl;
import com.oasystem.service.IApproveService;
import com.oasystem.utils.C3P0Utils;

/**
 * 审批模块Service 实现层
 * @author TcWong
 *
 */
public class ApproveServiceImpl implements IApproveService {
	
	private Connection conn = C3P0Utils.getConnection();
	
	IApproveDao approveDao = new ApproveDaoImpl(conn);

	/**
	 * 查询所有的未审批文件
	 */
	@Override
	public Map<String, Object> findAll(String name) throws Exception {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("mtroomapply", approveDao.selectMroomApply(name));
			map.put("leaves", approveDao.selectLeaves(name));
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return null;
	}

}
