package org.unicome.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unicome.demo.dao.UserRepository;
import org.unicome.demo.exception.ValidateException;
import org.unicome.demo.po.User;
import org.unicome.demo.service.UserService;
import org.unicome.demo.vo.UserVO;

import net.sf.json.JSONObject;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> listAllUser() {
        List<User> userList= (List<User>) userRepo.findAll();
        return userList;
    }

    @Override 
    public void deleteUser(int id) {
        userRepo.delete(id);
    }

	@Override
	public void insertUser(String json) {
		User user = new User();
		user.setName("name");
		userRepo.save(user);
	}

	@Override
	public UserVO login(String jsonString) throws ValidateException {
		JSONObject json = JSONObject.fromObject(jsonString);
		Map map = (Map) json;
		User user = userRepo.findByPhone(map.get("phone").toString().trim());
		if (null == user || !user.getPassword().equals(map.get("password"))) {
			throw new ValidateException();
		} else {
			return UserVO.toUserVO(user);
		}
	}

	@Override
	public UserVO register(String jsonString) throws ValidateException {
		JSONObject json = JSONObject.fromObject(jsonString);
		Map map = (Map) json;
		User user = userRepo.findByPhone(map.get("phone").toString().trim());
		if (null != user) {
			throw new ValidateException();
		} else {
			User newUser = new User();
			newUser.setPhone(map.get("phone").toString().trim());
			newUser.setPassword(map.get("password").toString());
			newUser.setName(map.get("phone").toString().trim());
			newUser.setNickname(map.get("phone").toString().trim());
			newUser.setCreateDate(new Date());
			newUser.setUpdateDate(new Date());
			User userInDB = userRepo.save(newUser);
			return UserVO.toUserVO(userInDB);
		}
	}

}
