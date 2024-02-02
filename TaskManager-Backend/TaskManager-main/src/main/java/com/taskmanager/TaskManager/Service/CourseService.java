package com.taskmanager.TaskManager.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.TaskManager.Model.Course;
import com.taskmanager.TaskManager.Repository.CourseRepo;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courserep;

    public List<Course> getAllCourses(){
		return courserep.findAll();
	}
	
	public String InsertCourse(Course course) {
		courserep.save(course);
		return "Insert SuccessFully";
	}
	
	public Course getCourseById(long id) {
		return courserep.findById(id).get();
	}
	
	public String Delete(long id) {
        courserep.deleteById(id);
        return "Course deleted successfully";
    }
	public Course getCourseByName(String name) {
		return courserep.findByname(name);
	}
	
    public String update(Course cor) {
        courserep.save(cor);
        return "Course Updated successfully";
    }
}
