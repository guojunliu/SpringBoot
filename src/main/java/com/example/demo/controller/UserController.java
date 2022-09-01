package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRequestEntity;
import com.example.demo.service.StudentService;
import com.google.gson.Gson;
import org.springframework.boot.configurationprocessor.json.JSONObject;
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

    /**
     * 查询列表
     * @return
     */
    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
    public List<User> studentList(@RequestParam Map<String, Object> params){
        int id = 0;
        if (params.containsKey("id")){
            id = (int)params.get("id");
        }
        String name = "";
        if (params.containsKey("name")){
            name = params.get("name").toString();
        }

        System.out.printf("id %d" ,id);
        System.out.printf("name %s" ,name);

        return studentService.findAll();
    }

    /**
     * 查询详情
     * @return
     */
    @RequestMapping(value = "/student/detail", method = RequestMethod.GET)
    public Optional<User> findById(@RequestParam Map<String, Object> params) {

        Gson gson = new Gson();
        String json = gson.toJson(params);
        User user = gson.fromJson(json,User.class);

        return studentService.findById(user.getId());
    }

    /**
     * 新增一条
     * @return
     */
    @RequestMapping(value = "/student/new", method = RequestMethod.GET)
    public User save(@RequestParam Map<String, Object> params){

        Gson gson = new Gson();
        String json = gson.toJson(params);
        User user = gson.fromJson(json,User.class);
        return studentService.save(user);
    }

    /**
     * 根据id删除一条
     */
    @RequestMapping(value = "/student/delete", method = RequestMethod.GET)
    public void delete(@RequestParam Map<String, Object> params){
        Gson gson = new Gson();
        String json = gson.toJson(params);
        User user = gson.fromJson(json,User.class);
        studentService.delete(user.getId());
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
     * 根据id修改一条
     * @return
     */
    @RequestMapping(value = "/student/update", method = RequestMethod.GET)
    public User update(@RequestParam Map<String, Object> params){
        Gson gson = new Gson();
        String json = gson.toJson(params);
        User user = gson.fromJson(json,User.class);
        return studentService.update(user);
    }
}
