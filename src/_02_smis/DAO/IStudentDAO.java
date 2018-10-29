package _02_smis.DAO;

import java.util.List;

import _02_smis.domain.Student;

public interface IStudentDAO {
	
	void save(Student stu);
	
	void delete(Long id);
	
	void update(Long id,Student newStu);
	
	Student get(Long id);
	
	List<Student> listAll();
}
