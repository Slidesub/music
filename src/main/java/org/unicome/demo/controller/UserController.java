package org.unicome.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.unicome.demo.exception.ValidateException;
import org.unicome.demo.po.Share;
import org.unicome.demo.po.User;
import org.unicome.demo.service.ShareService;
import org.unicome.demo.service.UserService;
import org.unicome.demo.vo.UserVO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ShareService shareService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ValidateException login(@RequestBody(required = true) String jsonString) {
        try {
            UserVO userVO = userService.login(jsonString);
            return new ValidateException(ValidateException.SUCCESS_CODE, "", userVO);
        } catch(ValidateException ve) {
            return new ValidateException(ValidateException.FAIL_CODE, "用户名或密码错误");
        } catch(Exception e) {
            e.printStackTrace();
            return new ValidateException(ValidateException.ERROR_CODE, "登录失败, 请重新登陆");
        }
    }

    @RequestMapping("/loadFriends")
    public List<User> loadFriends() {
        List<User> users = userService.listAllUser();
        return users;
    }
    @RequestMapping("/deleteFriend/{friendId}")
    public boolean deleteFriend(@PathVariable(name="friendId") String friendId) {
    //public boolean deleteFriend(@RequestParam(name="id", defaultValue = "") String id) {
        boolean isOk = true;
        try {
            userService.deleteUser(Integer.parseInt(friendId));
        } catch (Exception e) {
            e.printStackTrace();
            isOk = false;
        }
        return isOk;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ValidateException register(@RequestBody(required = true) String jsonString) {
        try {
            UserVO userVO = userService.register(jsonString);
            return new ValidateException(ValidateException.SUCCESS_CODE, "", userVO);
        } catch(ValidateException ve) {
            return new ValidateException(ValidateException.FAIL_CODE, "这个手机号已经被注册");
        } catch(Exception e) {
            e.printStackTrace();
            return new ValidateException(ValidateException.ERROR_CODE, "注册失败, 请重新注册");
        }
    }

    @RequestMapping("/loadShares")
    public String loadShares(@RequestParam(name="currentPage", defaultValue = "1") int currentPage,
            @RequestParam(name="pageSize", defaultValue = "10") int pageSize) {
        List<Share> shares = shareService.listSharesByCreateDate(currentPage <= 0 ? 1 : currentPage , pageSize);
        int pageCount = 0;
        if (shareService.getCount() % pageSize == 0) {
            pageCount = shareService.getCount() / pageSize;
        } else {
            pageCount = (int)(shareService.getCount() / pageSize) + 1;
        }
        
//        int pageCount = (int)Math.ceil(shareService.getCount() / pageSize);
        JSONArray array1 = JSONArray.fromObject(shares);
        String page = "{pageCount:" + pageCount + ", currentPage:" + currentPage + ", pageSize:" + pageSize + "}";
        JSONObject json2 = JSONObject.fromObject(page);
        JSONArray array = new JSONArray();
        array.add(array1);
        array.add(json2);
        return array.toString();
    }

    @RequestMapping("/upShare")
    public void upShare(@RequestBody(required = true) String data) {
        JSONObject json = JSONObject.fromObject(data);
        Map map = (Map)json;
        shareService.upShare(map.get("id").toString());
    }
}
