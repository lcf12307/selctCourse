package com.phoenix.web;

import com.phoenix.dto.User;
import com.phoenix.service.ManagerService;
import com.phoenix.service.StudentService;
import com.phoenix.service.TeacherService;
import com.phoenix.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by Phoenix on 2016/12/21.
 */

@Controller
public class MainController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/")
    public String returnMainPage() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String getMainPage() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public User getPerson(@RequestBody User user, HttpSession session){
        if(user.getUserType().equals("0")) {
            boolean result = studentService.checkIfStudentExist(user.getUserId());
            if(result) {
                session.setAttribute("user", user);
                user.setIsExist(1);
            }
            else {
                user.setIsExist(0);
            }
            return user;
        } else if(user.getUserType().equals("1")) {
            boolean result = teacherService.checkIfTeacherExist(user.getUserId());
            if(result) {
                session.setAttribute("user", user);
                user.setIsExist(2);
            }
            else {
                user.setIsExist(0);
            }
            return user;
        } else if(user.getUserType().equals("2")) {
            boolean result = managerService.checkIfManagerExist(user.getUserId());
            if(result) {
                session.setAttribute("user", user);
                user.setIsExist(3);
            }
            else {
                user.setIsExist(0);
            }
            return user;
        } else {
            user.setIsExist(0);
            return user;
        }
    }

}
