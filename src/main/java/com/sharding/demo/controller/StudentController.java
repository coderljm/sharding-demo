package com.sharding.demo.controller;


import com.sharding.demo.entity.Student;
import com.sharding.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jianmin.li
 * @since 2021-01-11
 */
@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 批量插入学生信息
     *
     * @author jianmin.li
     * @date 2021/1/11 22:56
     */
    @GetMapping("/addStudents")
    public void addStudents() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Student student = Student.builder().studentName("学生" + i).studentAge(15 + i).build();
            students.add(student);
        }
        studentService.saveBatch(students);
    }

    /**
     * <p>
     * 根据学生主键查询学生信息
     * <p/>
     *
     * @param studentId 学生主键
     * @return 学生信息
     * @author lijianmin
     * @date 2021/1/12 12:34
     */
    @GetMapping("/getStudentById/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.getById(studentId);
    }

}

