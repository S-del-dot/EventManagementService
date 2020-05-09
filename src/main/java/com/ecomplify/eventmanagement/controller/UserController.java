package com.ecomplify.eventmanagement.controller;

//import com.ecomplify.eventmanagement.models.entities.AppEvent;
import com.ecomplify.eventmanagement.models.entities.AppEvent;
import com.ecomplify.eventmanagement.models.entities.AppPicture;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecomplify.eventmanagement.exceptions.BusinessException;
import com.ecomplify.eventmanagement.models.entities.User;
import com.ecomplify.eventmanagement.models.entities.UserIdentifier;
import com.ecomplify.eventmanagement.services.ApplicationBusinessService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class UserController {


	@Autowired
	ApplicationBusinessService applicationbusinesssrvc;

	@GetMapping("/userauthentication/{emailId}/{password}")
	public ResponseEntity<User> UserAuthentication(@PathVariable String emailId,
			@PathVariable String password ){

	try {
		
		return new ResponseEntity<>(applicationbusinesssrvc.checkAuthentication(emailId,password), HttpStatus.OK);

		
	} catch (BusinessException e) {		
		System.out.println(e.getExceptionMessage());
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getExceptionMessage());
	}
	}


	@GetMapping("/userinformation/{appuserid}")
	public ResponseEntity<User> Getuserinformation(@PathVariable Long appuserid) {


		try {

			return new ResponseEntity<>(applicationbusinesssrvc.getuserinfo(appuserid), HttpStatus.OK);


		} catch (BusinessException e) {
			System.out.println(e.getExceptionMessage());
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getExceptionMessage());
		}
	}

	@GetMapping("/getallusers")
	public ResponseEntity<List<User>> Getallusers() {


		try {

			return new ResponseEntity<>(applicationbusinesssrvc.getallusers(), HttpStatus.OK);


		} catch (BusinessException e) {
			System.out.println(e.getExceptionMessage());
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getExceptionMessage());
		}
	}


	@PostMapping("/createuser")
	public ResponseEntity<String> createUser(@RequestBody User usr){
		
		String rtStr = "";
		
		try {
			
			rtStr = applicationbusinesssrvc.createUser(usr);

			
		}catch(Exception e) {
			rtStr = "failure";
			
			return new ResponseEntity<>(rtStr,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(rtStr,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleteuser/{appuserid}")	
	public ResponseEntity<String> DeleteUser(@PathVariable long appuserid)
	{
		String rtStr = "";
		
		try {
			
			rtStr = applicationbusinesssrvc.deleteUser(appuserid);
			
		}catch(Exception e) {
			rtStr = "failure";
			
			return new ResponseEntity<>(rtStr,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(rtStr,HttpStatus.CREATED);
	}


	@PutMapping("/updateuser/{appuserid}")
	public ResponseEntity<String> UpdateDetails(@RequestBody User usr, @PathVariable long appuserid)
	{
		String rtStr = "";
		 
		 try {
				
				rtStr = applicationbusinesssrvc.updateUser(usr,appuserid);
				
			}catch(Exception e) {
				rtStr = "failure";
				
				return new ResponseEntity<>(rtStr,HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<>(rtStr,HttpStatus.CREATED);
	}

	}
	
	



