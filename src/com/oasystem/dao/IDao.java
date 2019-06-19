package com.oasystem.dao;

import java.util.List;

import com.oasystem.bean.User;
import com.oasystem.bean.WebAddress;

/**
 * 公共父接口
 * @author TcWong
 * @param <K>
 * @param <V>
 */
public interface IDao<K,V> {
	
	/**
	 * 增加数据
	 * @param v
	 * @return
	 * @throws Exception
	 */
	int insert(V v)throws Exception;
	
	/**
	 * 删除数据
	 * @param k
	 * @return
	 * @throws Exception
	 */
	int delete(K k) throws Exception;
	
	/**
	 * 修改数据
	 * @param v
	 * @return
	 * @throws Exception
	 */
	int update(V v)throws Exception;
	
	/**
	 * 查询所有数据
	 * @return
	 * @throws Exception
	 */
	List<V> selectAll() throws Exception;
	
	/**
	 * 根据id查询
	 * @param k
	 * @return
	 * @throws Exception
	 */
	V selectById(K k) throws Exception;
	
	/**
	 * 根据用户查到数据
	 * @param user
	 * @return
	 * @throws Exception
	 */
     List<V> selectAll(String user) throws Exception;
	
	/**
	 * 模糊分页查询
	 * @param kw
	 * @param cp
	 * @param ls
	 * @return
	 * @throws Exception
	 */
	List<V> selectLimit(String kw,Integer cp,Integer ls)throws Exception;
}
