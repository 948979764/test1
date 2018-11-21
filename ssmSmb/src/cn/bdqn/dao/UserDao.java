package cn.bdqn.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.pojo.User;

public interface UserDao {
	
	//登录 
	User  findByUserCode(String userCode);
	//查询所有
	List<User> findAll(); //查询所有用户
	
	//int updateUser(User user);
	
	//待查询的总记录数
		int getTotalCount(
				@Param("queryName")
				String  queryName,
				@Param("roleId")
				Integer roleId
				);
		
 	
	//待查询的分页
	List<User> findByPage(
			@Param("queryName")
			String  queryName,
			@Param("roleId")
			Integer roleId,
			@Param("from")
			int from,
			@Param("pageSize")
			int pageSize
			);
	
	User  findById(int uid); //根据id查询用户
	
	int count(); //统计User表的人数
	
	int addUser(User user);
	 
	int delUser(int id);
	
	int updateUser(User user);
	
	List<UserDao> findByRoles(Integer[] roleIds);
	
	List<UserDao> findByRoles2(List<Integer> roleIds);
	
	List<UserDao> findByRoles3(Map<String, Object> conMap);
	
	List<UserDao> findUsersByRoleId(int roleId);
	
	
	
	List<UserDao> findByCondition123(UserDao user);
	
	
	
	
	List<UserDao> findByName(String name);
	
	List<UserDao> findTwoAll();
	
	//多条件1 封装成一个类
	List<UserDao> findByCondition1(UserDao user);
	
	//多条件2 封装成一个Map
	List<UserDao> findByCondition2(Map<String, Object> map);
	
	//多条件3  使用注解注入
	List<UserDao> findByCondition3(
			@Param("userName")
			String name,
			@Param("userRole")
			Integer userRole,
			@Param("gender")
			Integer gender);
	//int addUser(String userCode, String userName, String userPassword,
		//	int gender, Date birthday, String phone, String userRole);
	
	
	
	 
	

	 
}
