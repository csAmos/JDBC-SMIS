package ResultHandler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler<T> implements IResultSetHandler<List<T>>{
	private Class<T> classType;
	public BeanListHandler(Class<T> classType){
		this.classType=classType;
	}
	public List<T> handle(ResultSet rs) throws Exception {
		List<T> list=new ArrayList<>();
		//创建该类的一个对象
		
		//取出结果集光标所在那一行的数据
		BeanInfo beaninfo = Introspector.getBeanInfo(classType, Object.class);
		PropertyDescriptor[] pds=beaninfo.getPropertyDescriptors();
		while(rs.next()){
			T obj =classType.newInstance();
			list.add(obj);
			for (PropertyDescriptor	 pd: pds) {
				String cloName=pd.getName();
				Object val=rs.getObject(cloName);
				pd.getWriteMethod().invoke(obj, val);
			}
		}
		return list;
	}

}
