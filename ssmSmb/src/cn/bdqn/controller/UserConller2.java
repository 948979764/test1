package cn.bdqn.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bdqn.pojo.User;
import cn.bdqn.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserConller2 {

	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping(value="/view/{uid}")
	public String view(
			@PathVariable
			Integer uid,Model model
			){
		User user=userService.findById(uid);
		model.addAttribute("user", user);
		return "usermodify";
	}
	
	//������Ϣ��ʾ���·�
		@RequestMapping(value = "/showUser/{uid}")
		@ResponseBody
		public User showUser(
				@PathVariable//��PathVariableע���ȡid
				Integer uid){
			User user=userService.findById(uid);
			return user;
		}
		
	
	// ɾ���û�
	@RequestMapping(value = "/del/{uid}")
	@ResponseBody
	public Object deluser(
			@PathVariable//��PathVariableע���ȡid
			Integer uid,
			HttpServletRequest request){
		Map<String, String> retmap = new HashMap<String, String>();
		System.out.println(uid);
		if(uid==null){
			retmap.put("ret", "notexist");
		}else{
		int ret=userService.delById(uid);
		if(ret>0){
			retmap.put("ret", "true");
		}else {
			retmap.put("ret", "false");
		}
		}
		return retmap;
	}
}
