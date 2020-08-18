package com.jk.controller;

import com.jk.entity.HobbyEntity;
import com.jk.entity.UserEntity;
import com.jk.service.UserServiceFeign;
import com.jk.utils.Constant;
import com.jk.utils.RedisUtil;
import com.jk.utils.StringUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceFeign userService;

    @Resource
    private RedisUtil redisUtil;


    @RequestMapping("/saveOrder")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object saveOrder(Integer userId, Integer productId, HttpServletRequest request) {
        return userService.saveOrder(userId, productId);
}

    public Object saveOrderFail(Integer userId, Integer productId, HttpServletRequest request){
        System.out.println("保存订单降级方法");


        String  sendValue =  (String)redisUtil.get(Constant.SAVE_ORDER);
        String ipAddr = request.getRemoteAddr();

        new Thread( ()->{
            if (StringUtil.isNotEmpty(sendValue)){
                System.out.println("紧急信息,用户下单失败,IP地址是="+ipAddr);
                redisUtil.set(Constant.SAVE_ORDER,"保存失败",60);

            }else{
                System.out.println("已经发送过短信,1分钟不允许重复发送");
            }


        }).start();



       //反馈给用户看的
    HashMap<String, Object> map = new HashMap<>();
    map.put("code",-1);
        map.put("message","抢购人数太多，您被挤出来了，稍等重试");

    return map;
}



    @RequestMapping("/hello")
    @ResponseBody
    public String hello (String name){
        return userService.hello(name);
    }

    @RequestMapping("/selectUserList")
    @ResponseBody
    public List<UserEntity> selectUserList() {

        List<UserEntity> userList = (List<UserEntity>) redisUtil.get(Constant.SELECT_USER_LIST);

        // 1. 有值   2. 没有值
        if(userList == null || userList.size() <= 0 || userList.isEmpty()) {
            // 从数据库查询，存redis
            userList = userService.findUserList();
            redisUtil.set(Constant.SELECT_USER_LIST, userList, 30);
        }

       return userList;

    }

    @RequestMapping("toMain")
    public String toMain(){
        return "userlist";
    }



    @RequestMapping("/deleteUser")
    @ResponseBody
    public void deleteUser(Integer userId) {

        userService.deleteUser(userId);
        redisUtil.del(Constant.SELECT_USER_LIST);
    }



    @RequestMapping("/toAddUserPage")
    public String toAddUserPage(){
        return "adduser";
    }

    @RequestMapping("/queryHobby")
    @ResponseBody
    public List<HobbyEntity> queryHobby() {
        return userService.queryHobby();
    }

    @RequestMapping("/saveUser")
    @ResponseBody
    public void saveUser( UserEntity userEntity) {
        redisUtil.del(Constant.SELECT_USER_LIST);

            userService.saveUser(userEntity);



    }

    @RequestMapping("/selectById")
    public String selectById( Integer userId, Model model){
        List<UserEntity> userEntity =  userService.selectById(userId);
        model.addAttribute("userEntity",userEntity);
        List<HobbyEntity> hobbyEntity = userService.queryHobby();
        model.addAttribute("hobbyEntity",hobbyEntity);
        return "updateuser";
    }


    @RequestMapping("/updateUser")
    @ResponseBody
    public void updateUser( UserEntity userEntity) {
        redisUtil.del(Constant.SELECT_USER_LIST);

            userService.updateUser(userEntity);



    }



}
