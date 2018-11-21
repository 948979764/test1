package cn.bdqn.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Role implements Serializable{
	private Integer id; 
	private String roleCode; 
	private String roleName; 
	private Integer createdBy; 
	private Date creationDate; 
	private Integer modifyBy;
	private Date modifyDate;
	//һ�Զ�
		private List<User> userList;  //��ɫ��Ӧ���û��б� 
		
	public List<User> getUserList() {
			return userList;
		}
		public void setUserList(List<User> userList) {
			this.userList = userList;
		}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
