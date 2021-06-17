package com.callor.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVO {

	private String username;
	private String password;
	private String name;
	private String nname;
	private String email;
	private String tel;
	private String addr;
	
	private Boolean expire;
	
}
