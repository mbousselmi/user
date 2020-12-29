package com.nessma.user.Enum;

import lombok.Getter;

@Getter
public enum ExceptionEnum {

	VALID_ERROR(50, "Please Check your informations !"), USER_NOT_FOUNT(40, "User is not found!");

	private Integer code;
	
	private String message;

	ExceptionEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

}
