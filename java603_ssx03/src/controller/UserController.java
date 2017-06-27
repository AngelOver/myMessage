package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import service.UserService;



import domain.User;

@Controller//<bean class="UserController"/>
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/hello")
	public String  hello(){
		return "success";
	}
	@RequestMapping("/login")
	public String  login(User user,HttpServletRequest request){
		User resultUser=userService.login(user.getUsername(),user.getPassword());
		
		if(resultUser==null){
			request.setAttribute("reuser", user);
		
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "redirect:/jsps/user_login.jsp";
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("user", resultUser);
		
		
			return "redirect:/jsps/addTheme.jsp";
		}
		
	}
	@RequestMapping("/register")
	public String  register(User user,HttpServletRequest request){
		User resultUser=userService.register(user);
		
		if(resultUser==null){
			request.setAttribute("reuser", user);
			request.setAttribute("errorMsg", "账号已存在");
			return "register";
		}else{
		
			return "redirect:/jsps/user_login.jsp";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:/jsps/user_login.jsp";
	}
	
	
	
}

	