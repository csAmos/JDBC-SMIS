package ResultHandler;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import _02_smis.domain.Student;

public class StudentResultHandler implements IResultSetHandler<List<Student>>{

	public List<Student> handle(ResultSet rs) throws Exception {
		List<Student> list=new ArrayList<>();
		while(rs.next()){
			Student stu=new Student();
			stu.setId(rs.getLong("id"));
			stu.setName(rs.getString("name"));
			stu.setAge(rs.getInt("age"));
			list.add(stu);
		}
		return list;
	}

}
