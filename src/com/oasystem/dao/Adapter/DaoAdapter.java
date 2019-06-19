package com.oasystem.dao.Adapter;

import java.util.List;

import com.oasystem.bean.User;
import com.oasystem.bean.WebAddress;
import com.oasystem.dao.IDao;

public class DaoAdapter<K,V> implements IDao<K, V>{

	@Override
	public int insert(V v) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(K k) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(V v) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<V> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V selectById(K k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<V> selectLimit(String kw, Integer cp, Integer ls) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<V> selectAll(String user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
