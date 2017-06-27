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


import domain.Theme;
import domain.User;

@Repository("themeDao")
public class ThemeDao{
	
	 private  String xmlPath = "source/Theme.xml";
	
	 /*
	 * 生成绝对路径
	 */
	 ThemeDao(){
		 xmlPath=ThemeDao.class.getClassLoader().getResource("").getPath()+xmlPath;
		
	 }
	 
	
	 	/*
		 * 保存xml文件
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
	 * 根据节点封装对象
	 */
	private    Theme toTheme(Node node,Theme theme) throws Exception{
		Element el=(Element)node;
		UserDao userDao=new UserDao();
		User user=null;
		user=userDao.findById(el.attributeValue("u_id"));
		theme.setUser(user);
		theme.setId(el.attributeValue("id"));
		theme.setTitle(el.element("title").getText());
		theme.setContent(el.element("content").getText());
		theme.setCreateTime(el.element("createTime").getText());

		return theme;
	
	}
	/*
	 * 根据元素封装对象
	 */
	private    Theme  toTheme(Element el,Theme theme) throws Exception{
		
		UserDao userDao=new UserDao();
		User user=null;
		user=userDao.findById(el.attributeValue("u_id"));
		theme.setUser(user);
		theme.setId(el.attributeValue("id"));
		theme.setTitle(el.element("title").getText());
		theme.setContent(el.element("content").getText());
		theme.setCreateTime(el.element("createTime").getText());
		
		
		return theme;
	
	}
	/*
	 * 添加
	 */	
	public   Theme add(Theme theme) throws Exception{
		
		SAXReader read = new SAXReader();
		System.out.println(xmlPath);
		Document document = read.read(xmlPath);
		
		Element root = document.getRootElement();
		Element son=	root.addElement("theme");
		
		theme.setId(UUID.randomUUID().toString());
		son.addAttribute("id", theme.getId());
		son.addAttribute("u_id", theme.getUser().getId());
		
		son.addElement("title");
		son.element("title").setText(theme.getTitle());
		son.addElement("content");
		son.element("content").setText(theme.getContent());
		son.addElement("createTime");
		son.element("createTime").setText(getTime().toString());
		
		
		
		save(document);
		return toTheme(son, theme);
		
	}
	/*
	 * id查找
	 */
	public  Theme findById(String id) throws Exception{
		
		SAXReader read = new SAXReader();
		
		Document document = read.read(xmlPath);
	
		Theme theme=new Theme();
		
		
		Element node = (Element) document.selectNodes("/themes//theme[@id='"+id+"']").get(0);
		toTheme(node, theme);
		return theme;
		
	}
	

		
	/*
	 * 遍历
	 */
	public  List<Theme> findAll() throws Exception{
		SAXReader read = new SAXReader();
		Document document = read.read(xmlPath);
		List<Theme> themeList = new ArrayList<Theme>();
		List nodes = document.selectNodes("/themes//theme");
		for (int i = 0; i < nodes.size(); i++) {
			Theme theme=new Theme();
			Node node = (Node) nodes.get(i);
			themeList.add(toTheme(node,theme));
			
		}
		return themeList;
	}
	
	/*
	 * 删除
	 */
	public  void delete(Theme theme) throws Exception{
		
		SAXReader read = new SAXReader();
		Document document = read.read(xmlPath);
		Element root =document.getRootElement();
		
		
		Element node = (Element) document.selectNodes("/themes//theme[@id='"+theme.getId()+"']").get(0);
		root.remove(node);

		save(document);
		
	}
	
	/*	@Test
		public void test() throws Exception{
			System.out.println(this.getClass().getResource("/").getPath());
			UserDao userDao =new UserDao();
			userDao.test();
			System.out.println(xmlPath);
			Theme	theme =new Theme();
			User user=new User();
			user.setId("001");
			user.setUsername("tom");
			user.setPassword("28");
			theme.setUser(user);
			theme.setTitle("第一个留言");
			theme.setContent("一个留言的内容");
			Theme t2=add(theme);
		//	System.out.println(t2);
			theme=findById("01");
			System.out.println(theme);			
			for ( Theme user1:findAll() ) {
				System.out.println(user1);
			}
		
			
	//	System.out.println(findById(user.getId()));
		}*/
}