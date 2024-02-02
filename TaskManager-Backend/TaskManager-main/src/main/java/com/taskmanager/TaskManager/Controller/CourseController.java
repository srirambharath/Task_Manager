package com.taskmanager.TaskManager.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import com.taskmanager.TaskManager.Model.Course;
import com.taskmanager.TaskManager.Repository.CourseRepo;
import com.taskmanager.TaskManager.Service.CourseService;

@CrossOrigin("*")
@RestController
public class CourseController {
	@Autowired
	private CourseService courser;
	
	@Autowired
	private CourseRepo courep;
	
	public CourseController(CourseService courser) {
		this.courser = courser;
	}
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return courep.findAll();
	}

	@PostMapping("/courses")
	public ResponseEntity<Boolean> createcourse(@RequestBody Course course) {
		courep.save(course);

		return ResponseEntity.ok(true);
	}
	
	@PutMapping("/courses/{id}")
	public ResponseEntity<Course> updatecoursedata(@PathVariable long id,@RequestBody Course coursedet) {
		Course cors = courser.getCourseById(id);
		cors.setName(coursedet.getName());
		cors.setDescription(coursedet.getDescription());
		cors.setPrerequisites(coursedet.getPrerequisites());
		cors.setCredits(coursedet.getCredits());
		
		courep.save(cors);

		return ResponseEntity.ok(cors);
	}
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable long id){
		Optional<Course> courseOptional = courep.findById(id);
		if (courseOptional.isPresent()) {
			Course course = courseOptional.get();
			return ResponseEntity.ok(course);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<?> deleteCourse(@PathVariable long id) {
	    Optional<Course> courseOptional = courep.findById(id);
	    if (courseOptional.isPresent()) {
	        Course course = courseOptional.get();
	        // First, find the enrollments associated with the course
	        // Second, delete the course
	        courep.delete(course);
	        return ResponseEntity.ok().build(); // Return a success response without a body
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}



}

