package com.quick.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.exceptions.AdminException;
import com.quick.model.Admin;
import com.quick.model.UserSession;
import com.quick.repositories.AdminDao;
import com.quick.repositories.UserSessionDao;

@Service
public class SignupAdminServiceImpl implements SignupAdminService{

	@Autowired
	private AdminDao adminDao;
	
	
	@Autowired
	private UserSessionDao userSessionDao;
	
	@Override
	public Admin signupAdmin(Admin admin) {
		
		Admin a = adminDao.save(admin);
		
		return a;
	}

	
	@Override
	public Admin updateAdmin(Admin admin, String key) throws AdminException {
		
		Optional<UserSession> us=	userSessionDao.findByuid(key);
		
		if(us.isPresent()) {
			
			return adminDao.save(admin);
			
		}
		
		else {
			
			throw new AdminException("User is not logged in");
		}
		
	}

}
