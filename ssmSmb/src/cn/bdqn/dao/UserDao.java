package cn.bdqn.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.pojo.User;

public interface UserDao {
	
	//��¼ 
	User  findByUserCode(String userCode);
	//��ѯ����
	List<User> findAll(); //��ѯ�����û�
	
	//int updateUser(User user);
	
	//����ѯ���ܼ�¼��
		int getTotalCount(
				@Param("queryName")
				String  queryName,
				@Param("roleId")
				Integer roleId
				);
		
 	
	//����ѯ�ķ�ҳ
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
	
	User  findById(int uid); //����id��ѯ�û�
	
	int count(); //ͳ��User�������
	
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
	
	//������1 ��װ��һ����
	List<UserDao> findByCondition1(UserDao user);
	
	//������2 ��װ��һ��Map
	List<UserDao> findByCondition2(Map<String, Object> map);
	
	//������3  ʹ��ע��ע��
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
