package com.callor.score.model;

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
public class SubjectVO {
	private String sb_code;//	CHAR(4)
	private String 	sb_name;//	varchar(20)
	private String sb_prof;//	varchar(20)

}
