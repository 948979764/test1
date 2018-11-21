package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.pojo.Role;

public interface RoleDao {
	//根据roleId查询部门信息,同时显示对应的员工
		RoleDao findById(int roleId);

		List<Role> findAll();
}
