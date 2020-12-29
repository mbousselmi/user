package com.nessma.user.services.impl;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.nessma.user.exceptions.AdressMailNotValidException;
import com.nessma.user.models.MailContact;
import com.nessma.user.services.IMailSenderService;

@Service
public class MailSenderServiceImpl implements IMailSenderService {

	@Autowired
	private Environment env;

//	@Autowired
//	private JavaMailSender emailSender;

	private static final String EMAIL_PATTERN = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

	@Override
	public void sendMail(MailContact mailContact) throws AdressMailNotValidException {

		Properties props = new Properties();
		props.put("mail.smtp.auth", env.getProperty("spring.mail.smtp.auth"));
		props.put("mail.smtp.starttls.enable", env.getProperty("spring.mail.properties.mail.smtp.starttls.enable"));
		props.put("mail.smtp.host", env.getProperty("spring.mail.host"));
		props.put("mail.smtp.port", env.getProperty("spring.mail.port"));
		props.put("mail.smtp.ssl.trust", env.getProperty("spring.mail.smtp.ssl.trust"));

		Session session = getSession(props);

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom("no-replay@hotmail.fr");
			message.setRecipients(Message.RecipientType.TO,
					"malek_bou_selmi@hotmail.fr");
			message.setSubject(mailContact.getSubject());
			message.setText(mailContact.getMessage());
			Transport.send(message);

		} catch (MessagingException e) {
			throw new AdressMailNotValidException(e.getMessage());
		}

	}

	private Session getSession(Properties props) {
		final String username = env.getProperty("spring.mail.username");
		final String password = env.getProperty("spring.mail.password");

		return Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	}

	private static boolean emailValidation(String email) {
		Pattern pat = Pattern.compile(EMAIL_PATTERN);
		Matcher mat = pat.matcher(email);
		return mat.matches();
	}
}
