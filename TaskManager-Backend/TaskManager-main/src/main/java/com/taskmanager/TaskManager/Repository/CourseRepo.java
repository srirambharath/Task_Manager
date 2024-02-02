package com.taskmanager.TaskManager.Repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.taskmanager.TaskManager.Model.Course;

public interface CourseRepo extends JpaRepository <Course, Long> {
	public Course findByname(String s); 

}
