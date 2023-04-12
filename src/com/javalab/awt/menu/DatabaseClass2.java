package com.javalab.awt.menu;

import java.util.ArrayList;
import java.util.List;

public class DatabaseClass2 {
	private static List<Student> studentList = new ArrayList<Student>(); // 학생 ArrayList
	private static List<Professor> professorList = new ArrayList<Professor>(); // 교수 ArrayList
	private static List<Department> departmentList = new ArrayList<Department>();	// 학과 ArrayList
	private static List<Takes> takesList = new ArrayList<Takes>();	// 성적 ArrayList
	
	public static List<Student> getStudentList() {
		return studentList;
	}
	public static void setStudentList(List<Student> studentList) {
		DatabaseClass2.studentList = studentList;
	}
	public static List<Professor> getProfessorList() {
		return professorList;
	}
	public static void setProfessorList(List<Professor> professorList) {
		DatabaseClass2.professorList = professorList;
	}
	public static List<Department> getDepartmentList() {
		return departmentList;
	}
	public static void setDepartmentList(List<Department> departmentList) {
		DatabaseClass2.departmentList = departmentList;
	}
	public static List<Takes> getTakesList() {
		return takesList;
	}
	public static void setTakesList(List<Takes> takesList) {
		DatabaseClass2.takesList = takesList;
	}

	
}
