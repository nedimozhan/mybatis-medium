package com.oz.mybatiss;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oz.mybatiss.models.Student;
import com.oz.mybatiss.repositories.ILocalStudentRepository;
	
@SpringBootApplication
public class MybatissApplication implements CommandLineRunner{
	
	@Autowired
	private ILocalStudentRepository localStudentRepository;

	public static void main(String[] args) throws ClassNotFoundException {
		
		SpringApplication.run(MybatissApplication.class, args);	

	}
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		//--------- INSERT---------//
		Student student = new Student();
		student.setFirstName("RandomName");
		student.setAge(22);
		this.localStudentRepository.insertStudent(student);
		student=this.localStudentRepository.selectStudentById(1);
		System.out.println("ID : " + student.getId());
		
		// -------- UPDATE --------//
		student.setFirstName("RandomName2");
		student.setAge(23);
		this.localStudentRepository.updateStudent(student);
		
		// ------- SELECT -------//
		List<Student> students = this.localStudentRepository.selectStudentByFirstName("RandomName2");
		for(Student st : students) {
			System.out.println("ID : " + st.getId() + " Name : " + st.getFirstName() + " Age : " + st.getAge());
		}
		
		// ------- DELETE -------//
		this.localStudentRepository.deleteStudentById(student.getId());
		
	}

}
