package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.ThemeDao;
import domain.Theme;


@Service("themeService")
public class ThemeService {
	@Resource
	private ThemeDao themeDao;
	public Theme add(Theme theme) {
		try {
			return themeDao.add(theme);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public void del(Theme theme) {
		
			try {
				themeDao.delete(theme);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	public List<Theme> findAll() {
		try {
			return 	themeDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		 
	}
	public Theme findById(String id) {
		// TODO Auto-generated method stub
		try {
			return themeDao.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
