package com.ecomplify.eventmanagement.controller;

import com.ecomplify.eventmanagement.exceptions.BusinessException;
import com.ecomplify.eventmanagement.models.entities.AppEvent;
import com.ecomplify.eventmanagement.models.entities.AppPicture;
import com.ecomplify.eventmanagement.models.entities.User;
import com.ecomplify.eventmanagement.repositories.AppPictureRepository;
import com.ecomplify.eventmanagement.services.ApplicationBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class EventController {


	@Autowired
	ApplicationBusinessService applicationbusinesssrvc;

	@Autowired
	AppPictureRepository AppPictureRepo;

	@GetMapping("/appeventinformation/{eventname}")
	public ResponseEntity<AppEvent> Getappevent(@PathVariable String eventname) {


			try {

				return new ResponseEntity<>(applicationbusinesssrvc.getappevent(eventname), HttpStatus.OK);


			} catch (BusinessException e) {
				System.out.println(e.getExceptionMessage());
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getExceptionMessage());
			}
		}


	@PutMapping("/updateevent/{appeventid}")
	public ResponseEntity<String> UpdateEvent(@RequestBody AppEvent apevnt, @PathVariable long appeventid)
	{
		String rtStr = "";

		try {

			rtStr = applicationbusinesssrvc.updateEvent(apevnt,appeventid);

		}catch(Exception e) {
			rtStr = "failure";

			return new ResponseEntity<>(rtStr,HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(rtStr,HttpStatus.CREATED);
	}


	@PostMapping("/createevent")
	public ResponseEntity<String> CreateEvent(@RequestBody AppEvent apevnt)
	{
		String rtStr = "";

		try {

			rtStr = applicationbusinesssrvc.CreateEvent(apevnt);

		}catch(Exception e) {
			rtStr = "failure";

			return new ResponseEntity<>(rtStr,HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(rtStr,HttpStatus.CREATED);
	}

	@GetMapping("/apppictureinformation/{appeventid}")
	public ResponseEntity<List<AppPicture>> Getapppicture(@PathVariable Long appeventid) {


		try {

			return new ResponseEntity<>(applicationbusinesssrvc.getapppictures(appeventid), HttpStatus.OK);


		} catch (BusinessException e) {
			System.out.println(e.getExceptionMessage());
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getExceptionMessage());
		}
	}

	@DeleteMapping("/deleteimage/{apppictureid}")
	public ResponseEntity<String> DeleteImage(@PathVariable Long apppictureid)
	{
		String rtStr = "";

		try {

			rtStr = applicationbusinesssrvc.DeletePic(apppictureid);

		}catch(Exception e) {
			rtStr = "failure";

			return new ResponseEntity<>(rtStr,HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(rtStr,HttpStatus.CREATED);
	}




	}

	
	



