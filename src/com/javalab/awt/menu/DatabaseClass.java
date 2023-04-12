package com.javalab.awt.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * 오직 데이터를 보관하는 데이터베이스 역할
 */
public class DatabaseClass {
	// 필드
	public List<Student> studentList; // 학생 ArrayList
	public List<Professor> professorList;	// 교수 ArrayList
	public List<Department> departmentList;	// 학과 ArrayList
	public List<Takes> takesList;	// 성적 ArrayList
	
	/*
	 * 생성자
	 *  - 이 클래스가 객체로 생성되면서  학생,교수,학과,성적을 담을 ArrayList객체가 생성됨
	 */
	public DatabaseClass() {
		studentList = new ArrayList<Student>(); // 학생 ArrayList
		professorList = new ArrayList<Professor>(); // 교수 ArrayList
		departmentList = new ArrayList<Department>();	// 학과 ArrayList
		takesList = new ArrayList<Takes>();	// 성적 ArrayList
	}
	
	// 학생 목록 출력화면에서 사용할 메소드 - 학생 ArrayList를 보내줌
	public  List<Student> getStudentList() {
		return studentList;
	}
	public   void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	// 교수 목록 출력화면에서 사용할 메소드 - 교수 ArrayList를 보내줌	
	public List<Professor> getProfessorList() {
		return professorList;
	}
	public void setProfessorList(List<Professor> professorList) {
		this.professorList = professorList;
	}

	// 학과 목록 출력화면에서 사용할 메소드 - 학과 ArrayList를 보내줌
	public List<Department> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}
	// 성적 목록 출력화면에서 사용할 메소드 - 성적 ArrayList를 보내줌	
	public List<Takes> getTakesList() {
		return takesList;
	}
	public void setTakesList(List<Takes> takesList) {
		this.takesList = takesList;
	}

	// 학생 추가 메소드 - 학생 등록 화면에서 한명의 학생을 추가했을 때 사용되는 메소드
	public void addStudent(Student student) {
		this.studentList.add(student);
	}
	
	// 교수 추가 메소드 - 교수 등록 화면에서 한명의 교수를 추가했을 떄 사용되는 메소드
	public void addProfessor(Professor professor) {
		this.professorList.add(professor);
	}
	
	// 현재 등록된 학생수 확인
	public int getStudentCount() {
		return studentList.size();
	}
	
	// 현재 등록된 교수 숫자
	public int getProfessorCount() {
		return professorList.size();
	}
	
	// 현재 등록된 학과수
	public int getDepartmentCount() {
		return departmentList.size();
	}
	// 현재 등록된 성적수
	public int getTakesCount() {
		return takesList.size();
	}
}
