package cn.bdqn.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class UploadConller {
	// ��ʾupload
			@RequestMapping(value = "/upload.html")
			public String showupload() {
				return "upload";
			}	
		
	//�����ϴ�	
@RequestMapping(value = "/doupload.html")
public String doUpload(
		String userName,
		@RequestParam(value="pic")
		MultipartFile[] pic,//�ϴ�����ͼƬ
		HttpSession session,
		Model model
		){
	//String path="c:\\Upload";	
	String path=session.getServletContext().getRealPath("/statics/images/");//
	String ret="login";//
	for(MultipartFile mf:pic){//�ϴ�����ͼƬ
	String oldFileNmae=mf.getOriginalFilename();
	String suffix=oldFileNmae.substring(oldFileNmae.lastIndexOf('.')+1);//
	List<String> listTypes=Arrays.asList("gif","png","jpg","jpeg");//
	if(listTypes.contains(suffix)){//
	File fileTo=new File(path,oldFileNmae);
	try {
		mf.transferTo(fileTo);
		//return "login";		
	} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		ret="error";
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}else{
		String msg="��׺����";
		model.addAttribute("msg", msg);
		ret="redirect:upload.html";
	}
	}
	return ret;
	 
}
}
