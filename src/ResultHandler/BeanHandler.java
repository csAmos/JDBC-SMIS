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
		//���������һ������
		T obj =classType.newInstance();
		//ȡ����������������һ�е�����
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
