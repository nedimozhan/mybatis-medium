package com.oz.mybatiss.repositories;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.oz.mybatiss.models.Student;

@Mapper
public interface ILocalStudentRepository {
	
	public void insertStudent(Student student);
	public Student selectStudentById(int id);
	public List<Student> selectStudentByFirstName(String firstName);
	public void updateStudent(Student student);
	public void deleteStudentById(int id);
	//public List<Student> test(Student student);
}




