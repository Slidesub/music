package org.unicome.demo.service;

import java.util.List;

import org.unicome.demo.exception.ValidateException;
import org.unicome.demo.po.User;
import org.unicome.demo.vo.UserVO;

public interface UserService {

	public List<User> listAllUser();

	void deleteUser(int id);
	
	void insertUser(String json);

	public UserVO login(String json) throws ValidateException;

	public UserVO register(String json) throws ValidateException;
}
