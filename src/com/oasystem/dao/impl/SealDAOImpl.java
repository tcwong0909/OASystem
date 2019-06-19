package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Seal;
import com.oasystem.dao.ISealDAO;
/**
 * 印章列表dao实现类
 * @author Administrator
 *
 */
public class SealDAOImpl implements ISealDAO {

	private Connection conn;
	private QueryRunner qr=new QueryRunner();
	private String sql;
	
	public SealDAOImpl() {
		super();
	}

	public SealDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	/**
	 * 增加印章的方法
	 */
	@Override
	public int insert(Seal vo) throws Exception {
		sql="INSERT INTO seal(name,remark) VALUES(?,?)";
		Object [] params={vo.getName(),vo.getRemark()};
		return this.qr.update(conn,sql,params);
	}
	/**
	 * 删除印章信息的方法
	 */
	@Override
	public int delete(Integer id) throws Exception {
		sql="DELETE FROM seal WHERE id=?";
		return this.qr.update(conn, sql,id);
	}
	/**
	 * 修改印章的方法
	 */
	@Override
	public int update(Seal vo) throws Exception {
		sql="UPDATE seal SET name=?,remark=? WHERE id=?";
		Object [] param={vo.getName(),vo.getRemark(),vo.getId()};
		return this.qr.update(conn,sql,param);
	}
	/**
	 * 查询所有印章信息的方法
	 */
	@Override
	public List<Seal> selectAll() throws Exception {
		sql="SELECT * FROM seal";
		return this.qr.query(conn,sql, new BeanListHandler<Seal>(Seal.class));
	}

	@Override
	public Seal selectById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seal> selectLimit(String kw, Integer cp, Integer ls) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seal> selectAll(String user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
