package _02_smis.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
	
	Long id;
	String name;
	Integer age;
	
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
