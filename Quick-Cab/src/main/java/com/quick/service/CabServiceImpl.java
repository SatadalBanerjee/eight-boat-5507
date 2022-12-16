package com.quick.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.exceptions.*;
import com.quick.model.Cab;
import com.quick.repositories.CabDao;


@Service
public class CabServiceImpl implements CabService{

	 @Autowired
	 public CabDao  cabdao;
	
	
	@Override
	public Cab insertCab(Cab cab) throws CabException {
		
		Cab cab2= cabdao.save(cab);
		
		return cab2;
	}

	@Override
	public Cab updateCab(Cab cab) throws CabException {
	    
		Optional<Cab> optional=cabdao.findById(cab.getCabid());
		
		if(optional.isPresent()) {
			
			Cab cab2=cabdao.save(cab);
			
			return cab2;
		}
		else {
			
			throw new  CabException("Cab Details not update");
		}
	}

	@Override
	public Cab deleteCab(Integer cabid) throws CabException {
		Optional<Cab> opt=cabdao.findById(cabid) ;
		
		if(opt.isPresent()) {
			
			Cab cab=opt.get();
			cabdao.delete(opt.get());
			return cab;		
		}
		else {
			throw new  CabException("Cab Not Found With This Cab Id "+cabid);
		}
	
	}

	@Override
	public List<Cab> viewCabOftype(String cartype) throws CabException {
		
		List<Cab> cabs=cabdao.viewCabOftype(cartype);
		
		if(cabs.size()==0) {
			
			throw new CabException("No Cab Details Found...");
		}else {
			
        return cabs;			
		}
		

	}

	@Override
	public Integer countCabsofType(String cartype) throws CabException {
		 
		List<Cab> cabs=	cabdao.viewCabOftype(cartype);
	       
		 if(cabs.size()==0) {
			 throw new  CabException("No Cab Available This Type...");
			 
		 }
		 else {
			 
			 return (cabs.size()+1);
		 }
		
	}
	
	
	

}
