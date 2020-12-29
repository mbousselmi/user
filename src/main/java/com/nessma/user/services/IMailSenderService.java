package com.nessma.user.services;

import com.nessma.user.exceptions.AdressMailNotValidException;
import com.nessma.user.models.MailContact;

public interface IMailSenderService {
	
	 void sendMail(MailContact mailContact) throws AdressMailNotValidException;

}
