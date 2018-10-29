package _02_smis.DAO.impl;

import java.util.List;

import ResultHandler.BeanHandler;
import ResultHandler.BeanListHandler;
import _02_smis.DAO.IStudentDAO;
import _02_smis.domain.Student;
import utils.JdbcTemplate;

public class StudentDAOImpl implements IStudentDAO{

	@Override
	public void save(Student stu) {
		String sql="INSERT INTO t_student(name,age) VALUES(?,?);";
		JdbcTemplate.update(sql, stu.getName(),stu.getAge());
	}

	@Override
	public void delete(Long id) {
		String sql="DELETE FROM t_student WHERE id=?";
		JdbcTemplate.update(sql, id);
	}

	@Override
	public void update(Long id, Student newStu) {
		String sql="UPDATE t_student set name=?,age=? WHERE id=?";
		JdbcTemplate.update(sql, newStu.getName(),newStu.getAge(),id);
	}

	@Override
	public Student get(Long id) {
		String sql="SELECT * FROM t_student WHERE id=?";
		return JdbcTemplate.query(sql, new BeanHandler<>(Student.class),id);
	}

	@Override
	public List<Student> listAll() {
		String sql="SELECT * FROM t_student";
		return JdbcTemplate.query(sql, new BeanListHandler<>(Student.class));
	}

}
