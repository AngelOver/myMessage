package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.MessageDao;
import domain.Message;
import domain.Theme;



@Service("messageService")
public class MessageService {
	@Resource
	private MessageDao messageDao;
	public Message add(Message message) {
		try {
			return messageDao.add(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public void del(Message message) {
		
			try {
				messageDao.delete(message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	public List<Message> findAllByTheme(Theme theme) {
		
		try {
			return messageDao.findAll(theme);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
