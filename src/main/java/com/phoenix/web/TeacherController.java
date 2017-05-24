package com.phoenix.web;

import com.phoenix.dao.StuCourseDao;
import com.phoenix.dto.Teacher.AllCourseStudentListItem;
import com.phoenix.dto.Teacher.AllGradeStudentListItem;
import com.phoenix.dto.Teacher.UpdateCourseJson;
import com.phoenix.entity.Teacher;
import com.phoenix.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Phoenix on 2016/12/24.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/{teacherId}", method = RequestMethod.GET)
    public String getTeacherMainPage(@PathVariable("teacherId") String teacherId, Model model) {
        Teacher teacher = teacherService.queryTeacherById(teacherId);
        model.addAttribute("teacherId", teacherId);
        model.addAttribute("teacherName",teacher.getTeacherName());
        return "TeacherPage";
    }

    @RequestMapping(value = "/{teacherId}/studentlist", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> getAllStudentList(@PathVariable("teacherId") String teacherId) {
        List<AllCourseStudentListItem> allCourseStudentListItemList = teacherService.getTeachCourseStudentList(teacherId);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("teacherId", teacherId);
        modelMap.put("courseList",allCourseStudentListItemList);
        return modelMap;
    }

    @RequestMapping(value = "/{teacherId}/gradelist", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> getAllStudentGradeList(@PathVariable("teacherId") String teacherId) {
        List<AllGradeStudentListItem> allGradeStudentListItemList = teacherService.getAllStudentGradeList(teacherId);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("teacherId", teacherId);
        modelMap.put("courseList",allGradeStudentListItemList);
        return modelMap;
    }

    @RequestMapping(value = "/updategrade", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> updateCourseGrade(@RequestBody UpdateCourseJson updateCourseJson) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        System.out.println(updateCourseJson);
        double grade = Double.parseDouble(updateCourseJson.getGrade());
        int result = teacherService.updateCourseGrade(updateCourseJson.getStudentId(), updateCourseJson.getCourseId(), updateCourseJson.getTeacherId(), grade);
        modelMap.put("result", result);
        return modelMap;
    }
}
