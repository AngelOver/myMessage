package dao;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;





import org.dom4j.Document;

import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import org.springframework.stereotype.Repository;


import domain.Message;
import domain.Theme;
import domain.User;

@Repository("messageDao")
public class MessageDao{
	
	 private   String xmlPath = "source/Message.xml";//xml的相对路径

	 	/*
		 * 生成绝对路径
		 */
	 {																						//xml的绝对路径
		 xmlPath=ThemeDao.class.getClassLoader().getResource("").getPath()+xmlPath; //得到classpath的路径，直接写classpath会出现问题
		
	 }
	
		
	 /*
	  * 保存xml
	  */
		public  void save(Document document)  throws Exception {
	
			OutputFormat xmlFormat = OutputFormat.createPrettyPrint();
			 
			xmlFormat.setEncoding("utf-8");
			xmlFormat.setLineSeparator("\r\n");
			XMLWriter writer = new XMLWriter(new FileOutputStream(xmlPath), xmlFormat);
			writer.write(document);
			writer.close();
		}
		/*
		 * 得到当前时间
		 */
	private   String getTime(){
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式


		String hehe = dateFormat.format( now ); 
		System.out.println(); 
		return hehe;
	}
	/*
	 * 节点封装对象
	 */
	private   Message toMessage(Node node,Message message) throws Exception{
		Element el=(Element)node;
		UserDao userDao=new UserDao();
		User user=null;
		ThemeDao themeDao=new ThemeDao();
		Theme theme=null;
		theme=themeDao.findById(el.attributeValue("t_id"));
		user=userDao.findById(el.attributeValue("u_id"));
		message.setUser(user);
		message.setTheme(theme);
		message.setId(el.attributeValue("id"));
		
		message.setContent(el.element("content").getText());
		message.setCreateTime(el.element("createTime").getText());

		return message;
		
		
	}
	/*
	 * 元素封装对象
	 */
	private    Message  toMessage(Element el, Message  message){
		UserDao userDao=new UserDao();
		User user=null;
		ThemeDao themeDao=new ThemeDao();
		Theme theme=null;
		
		try {
			theme=themeDao.findById("01");
			user=userDao.findById(el.attributeValue("u_id"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		message.setUser(user);
		message.setTheme(theme);
		message.setId(el.attributeValue("id"));	
		message.setContent(el.element("content").getText());
		message.setCreateTime(el.element("createTime").getText());

		return message;
		
		
		
	}
	
	/*
	 * 添加
	 */
	public  Message add( Message  message) throws Exception{
		
		SAXReader read = new SAXReader();
		Document document = read.read(xmlPath);
		
		Element root = document.getRootElement();
		Element son=	root.addElement("message");
		
		 message.setId(UUID.randomUUID().toString());
		son.addAttribute("id", message.getId());
		son.addAttribute("u_id", message.getUser().getId());
		son.addAttribute("t_id", message.getTheme().getId());
		
		son.addElement("content");
		son.element("content").setText(message.getContent());
		son.addElement("createTime");
		son.element("createTime").setText(getTime().toString());
		
		
		
		save(document);
		return toMessage(son, message);
		
	}
	/*
	 * id查找
	 */
	public  Message findById(String id) throws Exception{
		
		SAXReader read = new SAXReader();
		Document document = read.read(xmlPath);
		Message message=new Message();
		
		
		Element node = (Element) document.selectNodes("/messages//message[@id='"+id+"']").get(0);
		toMessage(node, message);
		return message;
		
	}
	

	/*
	 * theme 遍历
	 */	
	
	public  List<Message> findAll(Theme theme) throws Exception{
		SAXReader read = new SAXReader();
		Document document = read.read(xmlPath);
		List<Message> messageList = new ArrayList<Message>();
		List nodes = document.selectNodes("/messages//message[@t_id='"+theme.getId()+"']");
		for (int i = 0; i < nodes.size(); i++) {
			Message message=new Message();
			Node node = (Node) nodes.get(i);
			messageList.add(toMessage(node,message));
			
		}
		return messageList;
	}
	/*
	 * 删除
	 */

	public  void delete(Message message) throws Exception{
		
		SAXReader read = new SAXReader();
		Document document = read.read(xmlPath);
		Element root =document.getRootElement();
		
		
		Element node = (Element) document.selectNodes("/messages//message[@id='"+message.getId()+"']").get(0);
		root.remove(node);

		save(document);
		
	}
	
/*		@Test
		public void test() throws Exception{
			System.out.println("kais");
			Theme	theme =new Theme();
			User user=new User();
			user.setId("001");
			user.setUsername("tom");
			user.setPassword("28");
			theme.setId("01");
			theme.setUser(user);
			theme.setTitle("第一个留言");
			theme.setContent("一个留言的内容");
			
			Message ms=new Message();
			ms.setContent("这是第一个测试");
			ms.setUser(user);
			ms.setTheme(theme);
			
			add(ms);
			System.out.println("ok"); 
			Theme t2=add(theme);
		//	System.out.println(t2);
			
					
			for ( User user1:findAll() ) {
				System.out.println(user1);
			}
		
			
	//	System.out.println(findById(user.getId()));
		}*/
}