package com.phoenix.web;

import com.phoenix.dto.CourseListItem;
import com.phoenix.dto.QuitOrSelectCourseItem;
import com.phoenix.dto.SelectedCourse;
import com.phoenix.dto.StudentGradeItem;
import com.phoenix.entity.Student;
import com.phoenix.service.StudentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Phoenix on 2016/12/21.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/{stuId}", method = RequestMethod.GET)
    public String getStudentMainPage(@PathVariable("stuId") String stuId, Model model) {
        Student student = studentService.queryStudentById(stuId);
        model.addAttribute("stuId", stuId);
        model.addAttribute("stuName",student.getStuName());
        System.out.println("dasdasdsa");
        return "StudentPage";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String userLogout(HttpSession session) {
        session.setAttribute("user",null);
        return "redirect:/";
    }

//    @RequestMapping(value = "/{stuId}/courses", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
//    @ResponseBody
//    public Map<String, Object> getSelectedCourseList(@PathVariable("stuId") String stuId) {
//        List<SelectedCourse> list = studentService.getSelectedCourse(stuId);
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        int studentAuthority = studentService.queryStudentById(stuId).getStudentAuthority();
//        modelMap.put("stuId",stuId);
//        modelMap.put("courseList",list);
//        modelMap.put("studentAuthority",studentAuthority);
//        return modelMap;
//    }

//    @RequestMapping(value = "/{stuId}/selection", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
//    @ResponseBody
//    public Map<String, Object> getAllCourseList(@PathVariable("stuId") String stuId) {
//        List<CourseListItem> courseListItemList = studentService.getAllCourses(stuId);
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        int studentAuthority = studentService.queryStudentById(stuId).getStudentAuthority();
//        modelMap.put("stuId",stuId);
//        modelMap.put("courseList",courseListItemList);
//        modelMap.put("studentAuthority",studentAuthority);
//        return modelMap;
//    }

    @RequestMapping(value = "/quit", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> quitClass(@RequestBody QuitOrSelectCourseItem quitOrSelectCourseItem) {
        String courseId = quitOrSelectCourseItem.getCourseId();
        String teacherId = quitOrSelectCourseItem.getTeacherId();
        String studentId = quitOrSelectCourseItem.getStudentId();
        int result = studentService.excuteDeleteCourse(studentId, courseId, teacherId);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("result",result);
        return modelMap;
    }


    @RequestMapping(value = "/selectcourse", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> selectClass(@RequestBody QuitOrSelectCourseItem quitOrSelectCourseItem) {
        String courseId = quitOrSelectCourseItem.getCourseId();
        String teacherId = quitOrSelectCourseItem.getTeacherId();
        String studentId = quitOrSelectCourseItem.getStudentId();
        int result = studentService.excuteSelectCourse(studentId, courseId, teacherId);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("result",result);
        return modelMap;
    }

    @RequestMapping(value = "/{stuId}/grades", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> getCourseGradeList(@PathVariable("stuId") String stuId) {
        List<StudentGradeItem> studentGradeItemList = studentService.getGradeList(stuId);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("stuId",stuId);
        modelMap.put("courseList",studentGradeItemList);
        return modelMap;
    }

}
