package com.oasystem.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.oasystem.bean.Mtroomapply;
import com.oasystem.dao.IMtroomapplyDao;
import com.oasystem.dao.impl.MtroomapplyDaoImpl;
import com.oasystem.service.IMtroomapplyService;
import com.oasystem.utils.C3P0Utils;

public class MtroomapplyServiceImpl implements IMtroomapplyService {
	
	private Connection conn = C3P0Utils.getConnection();
	
	IMtroomapplyDao mtroomapplyDAo = new MtroomapplyDaoImpl(conn);

	/**
	 * 添加申请表单
	 * @param mtroomapply
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean add(Mtroomapply mtroomapply) throws Exception {
		try {
			return mtroomapplyDAo.insert(mtroomapply)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0Utils.close(conn);
		}
		return false;
	}

	/**
	 * 删除表单
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean remove(Integer id) throws Exception {
		try {
			return mtroomapplyDAo.delete(id)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0Utils.close(conn);
		}
		return false;
	}

	/**
	 * 编辑表单
	 * @param mtroomapply
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean edit(Mtroomapply mtroomapply) throws Exception {
		try {
			return mtroomapplyDAo.update(mtroomapply)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return false;
	}

	/**
	 * 查询所有申请表
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Mtroomapply> findAll() throws Exception {
		try {
			return mtroomapplyDAo.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return null;
	}

	@Override
	public int updateStatus(int status, int id) {
		try {
			return mtroomapplyDAo.updateStatus(status, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

}
