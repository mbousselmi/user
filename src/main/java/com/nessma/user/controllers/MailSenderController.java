package com.nessma.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nessma.user.exceptions.AdressMailNotValidException;
import com.nessma.user.models.MailContact;
import com.nessma.user.services.IMailSenderService;

@RestController
public class MailSenderController {
	
	@Autowired
	private IMailSenderService mailSenderService;
	
	@PostMapping("/sendMail")
	public ResponseEntity<String> sendMail(@RequestBody MailContact emailRequest) throws AdressMailNotValidException {
		mailSenderService.sendMail(emailRequest);
		String response = "Mail Send With Success";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
