package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Role;
import com.oasystem.bean.User;
import com.oasystem.dao.IRoleDao;
import com.oasystem.dao.Adapter.DaoAdapter;

public class RoleDaoImpl extends DaoAdapter<Integer,Role> implements IRoleDao {
	private Connection conn;
		 
	public RoleDaoImpl() {
			super();
		}

	public RoleDaoImpl(Connection conn) {
			super();
			this.conn = conn;
		}

	private String sql;
	private QueryRunner qr = new QueryRunner();
	@Override
	public int delete(Integer k) throws Exception {
		 sql = "delete from role where id = ?";
		return this.qr.update(conn, sql, k);
	}

	@Override
	public int update(Role v) throws Exception {
		sql = "update role  set name =? where id=?";
		Object [] params={v.getName(),v.getId()};
		return this.qr.update(conn, sql, params);
	}

	@Override
	public List<Role> selectAll() throws Exception {
		sql = "select *from role" ;
		return this.qr.query(conn, sql, new BeanListHandler<Role>(Role.class));
	}

	 @Override
	public int insert(Role v) throws Exception {
		 sql = "insert into role(name)values(?)";
		 
		return this.qr.update(conn, sql, v.getName());
	}
	 
	 @Override
	public List<Role> selectLimit(String kw, Integer cp, Integer ls) throws Exception {
		sql = "select*from role where name like ? limit ?,?";
		Object [] params = {"%"+kw+"%",(cp-1)*ls,ls};
		return this.qr.query(conn,sql,new BeanListHandler<Role>(Role.class) ,params);
	}
}
