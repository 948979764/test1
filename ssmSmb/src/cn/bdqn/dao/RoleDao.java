package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.pojo.Role;

public interface RoleDao {
	//����roleId��ѯ������Ϣ,ͬʱ��ʾ��Ӧ��Ա��
		RoleDao findById(int roleId);

		List<Role> findAll();
}
