import axios from "axios";

const COURSE_REST_API = 'http://localhost:8080'

class CourseService{
  
    getAllCourses(){
        return axios.get(COURSE_REST_API+"/courses");
    }

    createcourse(course){
        return axios.post(COURSE_REST_API+"/courses",course);
    }

    getCourseById(courseId){
        const CourseId = courseId;
        return axios.get(`http://localhost:8080/courses/${CourseId}`,courseId);
    }

    updatecoursedata(courseId,course){
        const CourseId = courseId;
        return axios.put(COURSE_REST_API+`/courses/${CourseId}`,course);
    }

    deletecourse(id){
        const CourseId = id;
        return axios.delete(`http://localhost:8080/courses/${CourseId}`, id);
    }
}
const vari =new CourseService();
export default vari;
