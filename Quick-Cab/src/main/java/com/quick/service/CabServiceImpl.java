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
	 public CabDao  repo;
	
	
	@Override
	public Cab insertCab(Cab cab) throws CabException {
		
		Cab cab2= repo.save(cab);
		
		return cab2;
	}

	@Override
	public Cab updateCab(Cab cab) throws CabException {
	    
		Optional<Cab> optional=repo.findById(cab.getCabid());
		
		if(optional.isPresent()) {
			
			Cab cab2=repo.save(cab);
			
			return cab2;
		}
		else {
			
			throw new  CabException("Cab details not update");
		}
	}

	@Override
	public Cab deleteCab(Integer cabid) throws CabException {
		Optional<Cab> opt=repo.findById(cabid) ;
		
		if(opt.isPresent()) {
			
			Cab cab=opt.get();
			repo.delete(opt.get());
			return cab;		
		}
		else {
			throw new  CabException("Cab  Not Found With This Cab Id "+cabid);
		}
	
	}

	@Override
	public List<Cab> viewCabOftype(String cartype) throws CabException {
		
		List<Cab> cabs=repo.viewCabOftype(cartype);
		
		if(cabs.size()==0) {
			
			throw new CabException("No Cab Details Found...");
		}else {
			
        return cabs;			
		}
		

	}

	@Override
	public Integer countCabsofType(String cartype) throws CabException {
		 
		List<Cab> cabs=	repo.viewCabOftype(cartype);
	       
		 if(cabs.size()==0) {
			 throw new  CabException("No Cab Available This Type...");
			 
		 }
		 else {
			 
			 return (cabs.size()+1);
		 }
		
	}
	
	
	

}
