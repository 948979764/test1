package cn.bdqn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.bdqn.dao.RoleDao;
 
import cn.bdqn.pojo.Role;
import cn.bdqn.service.RoleService;
@Service("roleService")
public class RoleServiceImpl implements RoleService{
	@Resource(name="roleDao")
	private RoleDao roleDao;

	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}
	
}
