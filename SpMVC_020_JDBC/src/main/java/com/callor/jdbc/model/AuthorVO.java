package com.callor.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthorVO {
	
	private String au_code;//	CHAR(5)
	private String 	au_name;//	VARCHAR(50)
	private String au_tel;//	VARCHAR(20)
	private String au_addr;//	VARCHAR(125)
	private String au_genre;//	VARCHAR(30)


}
