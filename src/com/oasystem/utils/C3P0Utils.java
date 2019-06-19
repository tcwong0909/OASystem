package com.oasystem.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接池工具包
 *
 * @author TcWong
 *
 */
public class C3P0Utils {

	// 创建连接Connection
	private static Connection conn;
	// 创建连接池dataSource
	private static ComboPooledDataSource dataSource;

	static {
		// 实例化
		dataSource = new ComboPooledDataSource();
		// 连接地址
		dataSource.setJdbcUrl("jdbc:mysql://192.168.0.180:3306/oasystem?useSSL=true&useUnicode=true&characterEncoding=UTF-8");
		// 连接密码
		dataSource.setPassword("123456");
		// 用户
		dataSource.setUser("root");
		try {
			// 加载驱动信息
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			// 连接池最大数量
			dataSource.setMaxPoolSize(2000);
			// 连接池最小数量
			dataSource.setMinPoolSize(30);
			// 连接池耗尽一次创建个数
			dataSource.setAcquireIncrement(10);
			// 设置取得连接的最大时间
			//dataSource.setCheckoutTimeout(1000);
			// 连接池的超时废除时间
			dataSource.setMaxIdleTime(500);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 取得连接
	 *
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
