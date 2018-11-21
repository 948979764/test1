package cn.bdqn.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

 

import cn.bdqn.pojo.Bill;
import cn.bdqn.pojo.Provider;
import cn.bdqn.pojo.Role;
import cn.bdqn.pojo.User;
import cn.bdqn.service.BillService;
import cn.bdqn.service.ProviderService;
import cn.bdqn.service.RoleService;
import cn.bdqn.service.UserService;
import cn.bdqn.util.PageBean;

@Controller
public class UserController {

	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "roleService")
	private RoleService roleService;

	// ��ʾ����¼
	@RequestMapping(value = "/index.html")
	public String showLogin() {
		return "login";
	}

	// ��ʾ����
	@RequestMapping(value = "/useradd.html")
	public String showAdd(Model model) {

		return "useradd";
	}

	// ���������û�
	@RequestMapping(value = "/addUser.html")
	                    // �Զ���װ��ʵ�������Ҫ���޲ι��췽��
	public String addUser(User user, Model model, HttpSession session) {
		User userLogin = (User) session.getAttribute("userSession");
		user.setCreatedBy(userLogin.getId());
		user.setCreationDate(new Date());
		int ret = userService.addUser(user);
		if (ret > 0) {
			return "redirect:userList.html";
		} else {
			return "error";
		}

	}

	// ��ʾ�����û�
	// @RequestMapping(""")
	/*
	 * public String showAll(Model model) { List<User> userList =
	 * userService.findAll(); List<Role> roleList = roleService.findAll();
	 * model.addAttribute("userList", userList); model.addAttribute("roleList",
	 * roleList); return "userlist"; }
	 */

	// ��ҳ��ʾ�����û�
	@RequestMapping(value = "/userList.html")
	public String showByPage(
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false) String queryname,
			@RequestParam(required = false) Integer queryUserRole, Model model) {
		try {
			if (queryname != null)
				queryname = new String(queryname.getBytes("ISO-8859-1"),
						"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int pageSize = 5;
		PageBean<User> pageBean = userService.findByPage(queryname,
				queryUserRole, pageNo, pageSize);
		// ��ѯ���н�ɫ
		List<Role> roleList = roleService.findAll();
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("roleList", roleList);
		model.addAttribute("queryUserName", queryname);
		model.addAttribute("queryUserRole", queryUserRole);
		return "userlist";
	}

	// ��ʾ���޸�����ҳ��
	@RequestMapping(value = "/pwdmodify.html")
	public String showPwdModify() {
		return "pwdmodify";
	}

	// ʹ��ajax��֤������checkOldPwd.html
	@RequestMapping(value = "/checkOldPwd.html")
	@ResponseBody
	// ���ᱻ����Ϊ��ת·�����첽����ϣ����Ӧ�Ľ����json����
	public Object checkOldPwd(String oldpassword, HttpSession session) {
		Map<String, String> retmap = new HashMap<String, String>();
		// ����ҵ�����ж�oldpassword�Ƿ���ȷ
		if (oldpassword == null || oldpassword.equals("")) {
			retmap.put("result", "error");
		} else {
			User user = (User) session.getAttribute("userSession");
			if (user == null) {
				retmap.put("result", "sessionerror");
			} else {
				if (user.getUserPassword().equals(oldpassword)) {
					retmap.put("result", "true");
				} else {
					retmap.put("result", "false");
				}
			}
		}
		return retmap;
		// return JSON.toJSONString(retmap);
	}

	// ʹ��ajax�����û���ɫ�б�
	@RequestMapping(value = "/getrolelist")
	@ResponseBody  //��ʹ�����ע�ⷽ���ķ��ؽ��
	public List<Role> getrolelist() {
		List<Role> roleList = roleService.findAll();
		return roleList;
	}

	// ʹ��ajax�ж��û��Ƿ����
	@RequestMapping(value = "/checkUserCode")
	@ResponseBody
	public boolean checkUserCode(String userCode) {
		User user = userService.findByUserCode(userCode);
		if (user != null) {
			return true;
		} else {
			return false;
		}

	}

	// �����޸�
	@RequestMapping(value = "/domodify.html")
	public String domodify(String newpassword, Model model, HttpSession session) {
		User user = (User) session.getAttribute("userSession");
		user.setUserPassword(newpassword);
		int ret = userService.updateUserPwd(user);
		if (ret > 0) {
			// ��session��Ԫ�����滻��
			session.setAttribute("newpassword", user);
			return "redirect:main.html";
		} else {
			return "error";
		}
	}

	// �����¼
	@RequestMapping(value = "/login.html")
	public String doLogin(String userCode, String userPassword, Model model,
			HttpSession session) {
		User userLogin = userService.findByLogin(userCode, userPassword);
		session.setAttribute("userSession", userLogin);//
		if (userLogin != null) {

			return "redirect:main.html";// �ض���
		} else {
			String msg = "��¼ʧ�ܣ��û��������������";
			model.addAttribute("msg", msg);
			return "login";// ת�� ���ض�����������ת�����ݻᶪʧ
		}
	}

	// ��ʾ��½����
	@RequestMapping(value = "/main.html")
	public String main(HttpSession session) {
		User user = (User) session.getAttribute("userSession");
		if (user == null) {
			return "redirect:login.html";
		} else {
			return "frame";
		}
	}

	/*// ��ʾ���˾�����Ϣ
	@RequestMapping(value = "/viewUser.html")
	public String userView( 			 
			HttpServletRequest request,
			Model model) {		  
		User user=userService.findById(Integer.parseInt(request.getParameter("userid")));	 
		if(user!=null){
			model.addAttribute("user", user);
			//return "userview";
			return "redirect:userview";
		}else{
			return "error";
		}
	} */
	
	
	// ��ʾ���޸ĸ�����Ϣҳ��
		@RequestMapping(value = "/modifyUser.html")
		public String showUserModify(				 
				HttpServletRequest request,
				Model model
				) {
			User user=userService.findById(Integer.parseInt(request.getParameter("userid")));
		     model.addAttribute("user",user);
			if (user != null) {
				return "usermodify";
			} else {
				return "frame";
			}
		}
		// �����޸��û�
		@RequestMapping(value = "/usermodify.html")
		                    // �Զ���װ��ʵ�������Ҫ���޲ι��췽��
		public String usermodify(User user,
				Model model,
				HttpSession session,
				HttpServletRequest request
				 ) {
			 User usermodify = (User) session.getAttribute("userSession"); 
			/* user.setAddress(usermodify.getAddress());
			 user.setBirthday(usermodify.getBirthday());
			 user.setUserName(usermodify.getUserName());
			 user.setGender(usermodify.getGender());
			user.setPhone(usermodify.getPhone());
			user.setUserRoleName(usermodify.getUserRoleName());*/
			 user.setCreatedBy(usermodify.getId());
			 user.setModifyDate(new Date());
			//user.setId(Integer.parseInt(request.getParameter("uid")));
			int ret = userService.updateUser(user);
			if (ret > 0) {
				return "redirect:userList.html";
			} else {
				return "error";
			}

		}
		
	
	// ע��
	@RequestMapping(value = "/logout.html")
	public String loginout(HttpSession session) {
		session.invalidate();
		return "redirect:login.html";
	}
}
