package _02_smis.test;

import java.util.List;

import org.junit.Test;

import _02_smis.DAO.IStudentDAO;
import _02_smis.DAO.impl.StudentDAOImpl;
import _02_smis.domain.Student;

public class StudentDAOTest {
	private IStudentDAO dao=new StudentDAOImpl();

	@Test
	public void testSave() {
		Student stu=new Student();
		stu.setName("ºéÆß¹«");
		stu.setAge(18);
		dao.save(stu);
	}

	@Test
	public void testDelete() {
		Long id=7L;
		dao.delete(id);
	}

	@Test
	public void testUpdate() {
		Student stu=new Student();
		stu.setName("»ÆÒ©Ê¦");
		stu.setAge(45);
		dao.update(6L, stu);
	}

	@Test
	public void testGet() {
		Student stu=dao.get(6L);
		System.out.println(stu);
	}

	@Test
	public void testListAll() {
		List<Student> list=dao.listAll();
		for (Student stu : list) {
			System.out.println(stu);
		}
	}

}
