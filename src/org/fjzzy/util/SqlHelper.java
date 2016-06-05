package org.fjzzy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public final class SqlHelper {
	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/pet?useUnicode=true&amp;characterEncoding=utf-8";
	private static String userName = "sa";
	private static String password = "123456";
	
	//加载驱动
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//数据库查询数据
	public static ArrayList executeQuery(String sql,String[] paras){
		ArrayList array = null;
		Connection conn = null;
		PreparedStatement psm = null;
		ResultSet result = null;
		try{
			conn = getConnection();;
			psm = conn.prepareStatement(sql);
			setParas(psm, paras);
			result = psm.executeQuery();
			array = new ArrayList();
			while(result.next()){
				int columnCount = result.getMetaData().getColumnCount();
				Object[] row = new Object[columnCount];
				for(int i = 0;i < columnCount; i++){
					row[i] = result.getObject(i+1);
				}
				array.add(row);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			try {
				close(result, psm, conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
 		return array;
	}
	
	//
	
	//数据库执行更新
	public static int executeUpdate(String sql,String[] paras){
		Connection conn = null;
		PreparedStatement psm = null;
		int i = 0;
		try{
			conn = getConnection();
			psm = conn.prepareStatement(sql);
			setParas(psm, paras);
			i = psm.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			try {
				close(null, psm, conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return i;
	}
	
	//为sql语句注入参数
	public static void setParas(PreparedStatement psm,String[] paras) throws SQLException{
		if(paras != null && paras.length > 0){
			for(int i = 0;i < paras.length; i++){
				psm.setString(i+1, paras[i]);
			}
		}
	}
	
	//获取数据库连接
	private static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, userName, password);
	}
	//关闭数据库
	public static void close(ResultSet result,PreparedStatement psm,Connection conn) 
		throws SQLException{
		if(result != null && !result.isClosed()){
			result.close();
		}
		result = null;
		if(psm != null){
			psm.close();
		}
		psm = null;
		if(conn != null && !conn.isClosed()){
			conn.close();
		}
		conn = null;
	}
	
}
