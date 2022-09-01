package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRequestEntity;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    private StudentService studentService;

    public UserController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Optional<User> findById(@PathVariable int id) {
        System.out.println("ssssss");
        return studentService.findById(id);
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<User> findAll(){
        return studentService.findAll();
    }

    /**
     * 根据年龄查询
     * @param
     */
    @RequestMapping(value = "/student/id/{age}", method = RequestMethod.GET)
    public List<User> FindByXX(@PathVariable int age){
        return studentService.findByAge(age);
    }

    /**
     * 插入一条
     * @param studentRequestEntity
     * @return
     */
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public User save(@RequestBody UserRequestEntity studentRequestEntity){
        return studentService.save(studentRequestEntity);
    }

    @RequestMapping(value = "/student/addx", method = RequestMethod.GET)
    public User add(@RequestParam Map<String, Object> params){
        System.out.println(params.get("name"));
        return null;
//        return studentService.save(studentRequestEntity);
    }

    /**
     * 根据id删除一条
     * @param id
     */
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }

    /**
     * 根据id修改一条
     * @param name
     * @param id
     * @return
     */
    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public User save(@RequestParam String name, @PathVariable int id){
        return studentService.save(name, id);
    }

    /**
     * 根据id修改一条
     * @param name
     * @param id
     * @return
     */
    @RequestMapping(value = "/student/one/{id}", method = RequestMethod.PUT)
    public User saveOne(@RequestBody String name, @PathVariable int id){
        return studentService.save(name, id);
    }

}
