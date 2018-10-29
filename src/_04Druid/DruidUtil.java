package _04Druid;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidUtil {
	private static DataSource ds=null;
	static{
		try {
			Properties p=new Properties();
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("druid.properties"));
			ds=DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConn(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection conn ,Statement st,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
		}catch (Exception e2) {
		}finally{
			try {
				if(st!=null){
					st.close();
				}
			}catch (Exception e3) {
			}finally{
				try {
					if(conn!=null){
						conn.close();
					}
				}catch (Exception e4) {
				}
			}
		}
	}
}
