package com.phoenix.web;

import com.phoenix.dao.ManagerDao;
import com.phoenix.dto.Manager.*;
import com.phoenix.entity.*;
import com.phoenix.service.ManagerService;
import com.phoenix.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Phoenix on 2016/12/24.
 */

@Controller
@RequestMapping("/admin")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/{managerId}", method = RequestMethod.GET)
    public String getManagerMainPage(@PathVariable("managerId") String managerId, Model model) {
        Manager manager = managerService.queryManagerById(managerId);
        model.addAttribute("managerId", managerId);
        model.addAttribute("managerName",manager.getManagerName());
        return "ManagerPage";
    }

    @RequestMapping(value = "/{managerId}/students", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> getAllStudents(@PathVariable("managerId") String managerId) {
        List<StudentInfo> studentInfoList = managerService.getAllStudentList();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("managerId", managerId);
        modelMap.put("studentlist",studentInfoList);
        return modelMap;
    }

    @RequestMapping(value = "/{managerId}/courses", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> getAllCourses(@PathVariable("managerId") String managerId) {
        List<CourseInfo> courseInfoList = managerService.getAllCourseList();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("managerId", managerId);
        modelMap.put("courselist",courseInfoList);
        return modelMap;
    }

    @RequestMapping(value = "/{managerId}/teachers", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> getAllTeachers(@PathVariable("managerId") String managerId) {
        List<TeacherInfo> teacherInfoList = managerService.getAllTeacherList();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("managerId", managerId);
        modelMap.put("teacherlist", teacherInfoList);
        return modelMap;
    }

    @RequestMapping(value = "/{managerId}/majorlist", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> getAllMajorList(@PathVariable("managerId") String managerId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<MajorInfoJson> majorInfoJsonList = managerService.getAllMajorList();
        modelMap.put("managerId", managerId);
        modelMap.put("majorInfoList", majorInfoJsonList);
        return modelMap;
    }

    @RequestMapping(value = "/{managerId}/deptlist", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> getAllDeptList(@PathVariable("managerId") String managerId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<DeptInfoJson> deptInfoJsonList = managerService.getAllDeptList();
        modelMap.put("managerId", managerId);
        modelMap.put("deptInfoList", deptInfoJsonList);
        return modelMap;
    }

    @RequestMapping(value = "/addstudent", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> addNewStudent(@RequestBody NewStudentInfo newStudentInfo) {
        Student student = new Student(newStudentInfo.getStudentId(), newStudentInfo.getStudentName(), newStudentInfo.getStudentSex(), newStudentInfo.getMajorId());
        int result = managerService.insertStudent(student);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("result", result);
        return modelMap;
    }

    @RequestMapping(value = "/addcourse", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> addNewCourse(@RequestBody NewCourseInfo newCourseInfo) {
        Course course = new Course(newCourseInfo.getCourseId(), newCourseInfo.getCourseName(), Integer.parseInt(newCourseInfo.getCourseTime()), Double.parseDouble(newCourseInfo.getCourseCredit()));
        int result = managerService.insertCourse(course);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("result", result);
        return modelMap;
    }

    @RequestMapping(value = "/addteacher", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> addNewTeacher(@RequestBody NewTeacherInfo newTeacherInfo) {
        Teacher teacher = new Teacher(newTeacherInfo.getTeacherId(), newTeacherInfo.getTeacherName(), newTeacherInfo.getTeacherSex(), newTeacherInfo.getTeacherRank(), newTeacherInfo.getDeptId());
        int result = managerService.insertTeacher(teacher);
        System.out.println(newTeacherInfo);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("result", result);
        return modelMap;
    }

    @RequestMapping(value = "/delstudent", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> delStudent(@RequestBody StudentJson studentJson) {
        int result = managerService.deleteStudent(studentJson.getStudentId());
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("result",result);
        return modelMap;
    }

    @RequestMapping(value = "/delteacher", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> delTeacher(@RequestBody TeacherJson teacherJson) {
        int result = managerService.deleteTeacher(teacherJson.getTeacherId());
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("result",result);
        return modelMap;
    }

    @RequestMapping(value = "/delcourse", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> delCourse(@RequestBody CourseJson courseJson) {
        int result = managerService.deleteCourse(courseJson.getCourseId());
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("result",result);
        return modelMap;
    }

    @RequestMapping(value = "/changeauthority", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> changeStudentAuthority(@RequestBody TargetStudentAuthority targetStudentAuthority) {
        int result = managerService.updateStudentSelectAuthority(targetStudentAuthority.getStudentAuthority());
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("result",result);
        return modelMap;
    }

}
