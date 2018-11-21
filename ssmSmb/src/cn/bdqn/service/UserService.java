package cn.bdqn.service;

import java.util.Date;
import java.util.List;

import cn.bdqn.pojo.User;
import cn.bdqn.util.PageBean;

public interface UserService {
	//µÇÂ¼
		User findByLogin(String userCode,String upwd);

		int updateUserPwd(User user);

		List<User> findAll();

		PageBean<User> findByPage(String queryName,Integer roleId,Integer pageNo, int pageSize);

		User findByUserCode(String userCode);

		int addUser(User user);

		User findById(int userid);

		int updateUser(User user);

		int delById(int parseInt);

		 

		 

	 

	 
}
