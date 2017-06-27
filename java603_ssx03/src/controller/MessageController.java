package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.MessageService;

import domain.Message;
import domain.Theme;
import domain.User;

@Controller//<bean class="UserController"/>
@RequestMapping("/message")
public class MessageController {
	@Resource
	private  MessageService  messageService;
	@RequestMapping("/hello")
	public String  hello(){
		return "success";
	}
	@RequestMapping("/messageList")
	public String  messageList(HttpServletRequest request){
		HttpSession session=request.getSession();
		
		Theme  theme =(Theme) session.getAttribute("theme");
		
		List<Message> messageList=messageService.findAllByTheme(theme);
		session.setAttribute("messageList", messageList);
	

		return "redirect:/jsps/messageList.jsp";
		
		
	}
	@RequestMapping("/addMessage")
	public String  addMessage(Message message,HttpServletRequest request){
		HttpSession session=request.getSession();
		if(message.getContent()==null)
		{
			return "messageList";
		}
		Theme  theme =(Theme) session.getAttribute("theme");
		User user=(User) session.getAttribute("user");
		message.setUser(user);
		
		
		message.setTheme(theme);
		
		messageService.add(message);
	
	

		return "redirect:/message/messageList.do";
		
		
	}
	
}

