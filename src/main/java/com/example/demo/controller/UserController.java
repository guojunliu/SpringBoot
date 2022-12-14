package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.respones.HttpResponse;
import com.example.demo.service.UserService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 查询列表
     * @return
     */
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public HttpResponse studentList(@RequestParam Map<String, Object> params){

        Gson gson = new Gson();
        String json = gson.toJson(params);
        User user = gson.fromJson(json,User.class);

        List<User> userList = userService.findAll();
        HttpResponse response = new HttpResponse(200,userList==null?new HashMap():userList,true);

        return response;
    }

    /**
     * 查询详情
     * @return
     */
    @RequestMapping(value = "/user/detail", method = RequestMethod.GET)
    public HttpResponse findById(@RequestParam Map<String, Object> params) {

        Gson gson = new Gson();
        String json = gson.toJson(params);
        User user = gson.fromJson(json,User.class);

        Optional<User> responseUser = userService.findById(user.getId());
        HttpResponse response = new HttpResponse(200,responseUser==null?new HashMap():responseUser,true);

        return response;
    }

    /**
     * 新增一条
     * @return
     */
    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public HttpResponse save(@RequestParam Map<String, Object> params){

        Gson gson = new Gson();
        String json = gson.toJson(params);
        User user = gson.fromJson(json,User.class);

        User responseUser =  userService.save(user);
        HttpResponse response;
        if (responseUser == null) {
            response = new HttpResponse(200,new HashMap(),false);
            response.setMessage("新增失败");
        }
        else  {
            response = new HttpResponse(200,responseUser,true);
        }

        return response;
    }

    /**
     * 根据id删除一条
     */
    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public HttpResponse delete(@RequestParam Map<String, Object> params){
        Gson gson = new Gson();
        String json = gson.toJson(params);
        User user = gson.fromJson(json,User.class);

        boolean bb = userService.delete(user);
        HttpResponse response;
        if (bb) {
            response = new HttpResponse(200, new HashMap(),true);
        }
        else {
            response = new HttpResponse(200, new HashMap(),false);
            response.setMessage("该id不存在");
        }

        return response;
    }

//    /**
//     * 根据年龄查询
//     * @param
//     */
//    @RequestMapping(value = "/student/id/{age}", method = RequestMethod.GET)
//    public List<User> FindByXX(@PathVariable int age){
//        return studentService.findByAge(age);
//    }

    /**
     * 根据id修改一条
     * @return
     */
    @RequestMapping(value = "/user/update", method = RequestMethod.GET)
    public HttpResponse update(@RequestParam Map<String, Object> params){
        Gson gson = new Gson();
        String json = gson.toJson(params);
        User user = gson.fromJson(json,User.class);

        User responseUser =  userService.update(user);
        HttpResponse response;
        if (responseUser == null) {
            response = new HttpResponse(200,new HashMap(),false);
            response.setMessage("该id不存在");
        }
        else  {
            response = new HttpResponse(200,responseUser,true);
        }

        return response;
    }
}
