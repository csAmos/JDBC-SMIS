package ResultHandler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

public class BeanHandler<T> implements IResultSetHandler<T>{
	private Class<T> classType;
	public BeanHandler(Class<T> classType){
		this.classType=classType;
	}
	public T handle(ResultSet rs) throws Exception {
		//创建该类的一个对象
		T obj =classType.newInstance();
		//取出结果集光标所在那一行的数据
		BeanInfo beaninfo = Introspector.getBeanInfo(classType, Object.class);
		PropertyDescriptor[] pds=beaninfo.getPropertyDescriptors();
		if(rs.next()){
			for (PropertyDescriptor	 pd: pds) {
				String cloName=pd.getName();
				Object val=rs.getObject(cloName);
				pd.getWriteMethod().invoke(obj, val);
			}
		}
		return obj;
	}

}
