package cn.bdqn.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.bdqn.dao.UserDao;
import cn.bdqn.pojo.User;
import cn.bdqn.service.UserService;
import cn.bdqn.util.PageBean;
@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource(name="userDao")
	private UserDao userDao;

	public User findByLogin(String userCode, String upwd) {
		User user = userDao.findByUserCode(userCode);
		if(user!=null&&user.getUserPassword().equals(upwd)){
			return user;
		}else{
			return null;
		}
	}

	public int updateUserPwd(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	public PageBean<User> findByPage(String queryName,Integer roleId,Integer pageNo, int pageSize) {
		PageBean<User> pageBean=new PageBean<User>();
		  pageBean.setPageSize(pageSize);
		  int totalCount=userDao.getTotalCount(queryName,roleId);
		  pageBean.setTotalCount(totalCount);
		  pageBean.setPageNo(pageNo); 
		  int  from=(pageBean.getPageNo()-1)*pageSize;
		  List<User> pageList=userDao.findByPage(queryName,roleId,from,pageSize);
		   pageBean.setPageList(pageList);
		   
		return pageBean;
		 
	}

	public User findByUserCode(String userCode) {
		// TODO Auto-generated method stub
		return userDao.findByUserCode(userCode);
	}

	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	public User findById(int userid) {
		// TODO Auto-generated method stub
		return userDao.findById(userid);
	}

	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao. updateUser(user);
	}

	public int delById(int id) {
		// TODO Auto-generated method stub
		return userDao.delUser(id);
	}

	 
	

}
