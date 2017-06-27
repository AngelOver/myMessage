package dao;



import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



import org.dom4j.Document;

import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import org.springframework.stereotype.Repository;


import domain.User;

@Repository("userDao")
public class UserDao{

	/*
	 * xml相对路径
	 */
	private String  xmlPath = "source/User.xml";


	/*
	 * 生成绝对路径
	 */
	 UserDao(){
		 xmlPath=UserDao.class.getClassLoader().getResource("").getPath()+xmlPath; //得到classpath的路径，直接写classpath会出现问题
		
	
	 }
	
	/*
	 * 保存xml文件 xml文件以utf-8保存
	 */
		public  void save(Document document)  throws Exception {/*Document document*/
		
		/*  xml文件ASNI保存
		 * OutputFormat outputFormat = OutputFormat.createPrettyPrint();  
		 	outputFormat.setEncoding("utf-8");
        	outputFormat//这是为了换行操作 
        	Writer writer = new FileWriter(path2);  //这里的相对路径定位在tomcat/bin目录下面
       
        	XMLWriter outPut = new XMLWriter(writer,outputFormat);  
        	
       		outPut.write(document);  
        	outPut.close(); */
			OutputFormat xmlFormat = OutputFormat.createPrettyPrint();
			 
			xmlFormat.setEncoding("utf-8");
			xmlFormat.setLineSeparator("\r\n");
			XMLWriter writer = new XMLWriter(new FileOutputStream(xmlPath), xmlFormat);
			writer.write(document);
			writer.close();
		}
	/*
	 * 根据节点封装对象
	 */
	private  User toUser(Node node,User user){
		Element el=(Element)node;
		user.setId(el.attributeValue("id"));
		user.setUsername(el.element("username").getText());
		user.setPassword(el.element("password").getText());
		return user;
	
	}
	/*
	 * 根据元素封装对象
	 */
	private  User toUser(Element node,User user){
		user.setId(node.attributeValue("id"));
		user.setUsername(node.element("username").getText());
		user.setPassword(node.element("password").getText());
		
		return user;
		
		
	}
	/*
	 * 添加
	 */
	public  User add(User user) throws Exception{
		
		SAXReader read = new SAXReader();
		Document document = read.read(xmlPath);
		
		Element root = document.getRootElement();
		
		Element son=	root.addElement("user");
		user.setId(UUID.randomUUID().toString());
		son.addAttribute("id", user.getId());
		son.addElement("username");
		son.element("username").setText(user.getUsername());
		son.addElement("password");
		son.element("password").setText(user.getPassword());
		
		
		
		save(document);
		return toUser(son, user);
		
	}
	/*
	 * 修改
	 */
/*	public  void update(User user) throws Exception{
		
		SAXReader read = new SAXReader();
		Document document = read.read(
		
		
		
		xmlPath);
		
		
		
		Element node = (Element) document.selectNodes("/users//user[@id='"+user.getId()+"']").get(0);
		
		node.element("username").setText(user.getUsername());
		node.element("password").setText(user.getPassword());
		save(document);
		
	}*/
	/*
	 * id查找
	 */
	public  User findById(String id) throws Exception{
	
		SAXReader read = new SAXReader();
		Document document = read.read(xmlPath);
		User user=new User();

		Element node = (Element) document.selectNodes("/users//user[@id='"+id+"']").get(0);
		toUser(node, user);
		return user;
	
	}
	/*
	 * name添加
	 */
	public  User findByName(String name) throws Exception{
	
		SAXReader read = new SAXReader();
		Document document = read.read(xmlPath);
		User user=new User();
		
		List nodes = document.selectNodes("/users//user/username");
		for (int i = 0; i < nodes.size(); i++) {
			Node node = (Node) nodes.get(i);
			if(node.getText().toString().equals(name))
			{
				toUser(node.getParent(), user);
			
				
				return user;
			}
		}
		
		return null;
		
	}
	/*
	 * 遍历
	 */
	public  List<User> findAll() throws Exception{
		SAXReader read = new SAXReader();
		Document document = read.read(xmlPath);
		List<User> userList = new ArrayList<User>();
		List nodes = document.selectNodes("/users//user");
		for (int i = 0; i < nodes.size(); i++) {
			User user=new User();
			Node node = (Node) nodes.get(i);
			userList.add(toUser(node,user));
			
		}
		return userList;
		
	}
	/*
	 * 删除
	 */
	public  void delete(User user) throws Exception{
		
		SAXReader read = new SAXReader();
		Document document = read.read(xmlPath);
		Element root =document.getRootElement();
		
		
		Element node = (Element) document.selectNodes("/users//user[@id='"+user.getId()+"']").get(0);
		root.remove(node);

		save(document);
		
	}
	
/*	@Test
		public void test() throws Exception{
			System.out.println(UserDao.class.getClassLoader().getResource("").getPath());
			User user=new User();
			user.setId("2e95d826-f3d3-494a-aacd-f8dd43c8a764");
			user.setUsername("tom");
			user.setPassword("修改");
			System.out.println(findByName("tom"));
			for ( User user1:findAll() ) {
				System.out.println(user1);
			}
		
		
	
	//	System.out.println(findById(user.getId()));
		
		
		
		}*/
}