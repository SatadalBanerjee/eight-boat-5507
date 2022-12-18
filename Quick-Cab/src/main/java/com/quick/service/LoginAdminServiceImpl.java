package com.quick.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.exceptions.AdminException;
import com.quick.model.Admin;
import com.quick.model.LoginAdmin;
import com.quick.model.UserSession;
import com.quick.repositories.AdminDao;
import com.quick.repositories.LoginAdminDao;
import com.quick.repositories.UserSessionDao;

@Service
public class LoginAdminServiceImpl implements LoginAdminService{

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private LoginAdminDao adminLoginDao;
	
	@Autowired
	private UserSessionDao userSessionDao;
	
	
	@Override
	public String Adminlogin(LoginAdmin la) throws AdminException {
		
		
		Admin admin= adminDao.findById(la.getUserId()).orElseThrow(()->new AdminException("User Id not find"));
		
		if(!admin.getUsername().equals(la.getName())) {

			return "Please check the username";
		}
		if(!admin.getPassword().equals(la.getPassword())) {

			return "Please check the password";
		}
		
		
		Optional<UserSession> opt = userSessionDao.findByuserId(la.getUserId());
		
		if(opt.isPresent()) {	
			return "Admin Alredy logged in";
		}
		
	 	RandomNumber ran = new RandomNumber();
			
	 	String uuid=ran.RandomNum();
			
	 	UserSession cus= new UserSession();
	 	
		cus.setUserId(la.getUserId());
		cus.setLocalDateTime(LocalDateTime.now());
		cus.setUUid(uuid);
			
		adminLoginDao.save(la);
		
		UserSession cs=	userSessionDao.save(cus);
		
		return cs.toString();
	}

	@Override
	public String Adminlogout(String key) throws AdminException {
		UserSession cus=	userSessionDao.findByuUid(key).orElseThrow(()-> new AdminException("Enter correct Key"));

		adminLoginDao.deleteById(cus.getUserId());
		userSessionDao.delete(cus);	
		return "Logout Successful";
	}

}
