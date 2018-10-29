package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ResultHandler.IResultSetHandler;

public class JdbcTemplate {
	public static void update(String sql,Object...params){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=jdbcUtil.getConn();
			ps=conn.prepareStatement(sql);
			//==设置占位符参数
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			//==========
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtil.close(conn, ps, null);
		}
	}
	
	public static <T>T query(String sql,IResultSetHandler<T> rsh,Object...params){
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=jdbcUtil.getConn();
			ps=conn.prepareStatement(sql);
			//==设置占位符参数
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			//==========
			rs=ps.executeQuery();
			return rsh.handle(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtil.close(conn, ps, rs);
		}
		throw new RuntimeException("查询操作有误");
	}
}
