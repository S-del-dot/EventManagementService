package com.ecomplify.eventmanagement.services;

import com.ecomplify.eventmanagement.models.entities.*;
import com.ecomplify.eventmanagement.repositories.*;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;


import com.ecomplify.eventmanagement.exceptions.BusinessException;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ApplicationBusinessService {
	
    @Autowired
    UserRepository userRepo;

    @Autowired
    UserIdentifierRepository userIdentifierRepo;

	@Autowired
	AppEventRepository AppEventRepo;

	@Autowired
	AppPictureRepository AppPictureRepo;

    @Autowired
    UseraccessRepository UseraccessRepo;



    public User checkAuthentication(String username,String password) throws BusinessException{
          
    	  User usr = null;
    	  UserIdentifier usrIdentifier = null;
		  UserAccessibility usraccess = null;
	      usr = userRepo.findByEmail(username);

	      if(usr!=null)
	      {
	    	  usrIdentifier = userIdentifierRepo.findByUserId(usr.getAppuserid());
			  usraccess = UseraccessRepo.findByAppuserid(usr.getAppuserid());
	    	  usr.setAccesstype(usraccess.getTypeofaccess());
	    	  if(!usrIdentifier.getUserIdentifierText().equals(password))
	    	  {
	    		  throw new BusinessException("Passowrd is Wrong");
	    	  }
	      }
	      else {
	    	  throw new BusinessException("" +
					  "User Id is not available");
	      }

	      return usr;
    }
    
    
	public String deleteUser(long appuserid) throws BusinessException  {

		UserIdentifier ui = null;
		ui = userIdentifierRepo.findByUserId(appuserid);
		
		if(ui!=null) {
			
			userIdentifierRepo.deleteById(ui.getUserIdentifierId());
			
			userRepo.deleteById(appuserid);
			
		}else
			{
			throw new BusinessException("User Identifier is not avaialible"); 
		}
		return "Success";
	}
    
    public String createUser(User usr) throws BusinessException {
    	
    	
    	String str = "Success";
    	
    	User tmpUsr = null;    	
    	tmpUsr = userRepo.save(usr);
    	
    	if(tmpUsr!=null) {
    		
    		UserIdentifier usrId = new UserIdentifier();
            UserAccessibility UserPerm = new UserAccessibility();
    		usrId.setUserId(tmpUsr.getAppuserid());
    		usrId.setUserIdentifierText(usr.getAccesstext());
    		usrId.setDeleted("N");
    		usrId.setIdentifierValidatedtoDate(LocalDateTime.now());

            UserPerm.setAppuserid(tmpUsr.getAppuserid());
            UserPerm.setTypeofaccess(usr.getAccesstype());
            UserPerm.setDeleted("N");
            UserPerm.setCreatedby(usr.getCreatedby());
            UserPerm.setCreatedon(LocalDateTime.now());
            userIdentifierRepo.save(usrId);
            UseraccessRepo.save(UserPerm);

    	}
    	else {
    		throw new BusinessException("Unable to dave the user data");
    	}

    		
    	return str;
    	
    }
    
    
    public String updateUser(User usr,long appuserid) throws BusinessException{
    
    	
    	String str = "Success";
    	
    	usr.setAppuserid(appuserid);
    	
    	userRepo.save(usr);
    	
    	return str;
    }


	public User getuserinfo(Long appuserid) throws BusinessException{

		User usr = null;
		usr = userRepo.findByAppuserid(appuserid);
		UserAccessibility usraccess = null;
		UserIdentifier usrIdentifier = null;
		usraccess = UseraccessRepo.findByAppuserid(usr.getAppuserid());
		usr.setAccesstype(usraccess.getTypeofaccess());
		usrIdentifier = userIdentifierRepo.findByUserId(usr.getAppuserid());
		usr.setAccesstext(usrIdentifier.getUserIdentifierText());
		 return usr;

	}

	public List<User> getallusers() throws BusinessException{

		return userRepo.findAll();

	}


    public AppEvent getappevent(String eventname) throws BusinessException{


		return AppEventRepo.findByEventname(eventname);

    }


	public String updateEvent(AppEvent apevnt,long appeventid) throws BusinessException{


		String st = "Success";

		apevnt.setAppeventid(appeventid);

		AppEventRepo.save(apevnt);

		return st;
	}

	public String CreateEvent(AppEvent appev) throws BusinessException {


		 String str = "Success";

		 AppEventRepo.save(appev);

         return str;

    }

	public List<AppPicture> getapppictures(Long appeventid) throws BusinessException{

		return AppPictureRepo.findByAppeventid(appeventid);

	}

	public String DeletePic(Long apppictureid) throws BusinessException{


		String str = "Success";

		AppPictureRepo.deleteById(apppictureid);

		return str;
	}

}
