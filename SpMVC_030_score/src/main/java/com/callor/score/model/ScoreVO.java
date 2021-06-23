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
public class ScoreVO {
	private Long sc_seq;//	BIGINT
	private String sc_stnum;//	char(8)
	private String sc_sbcode ;//	varchar(20)
	private int sc_score;//	INT
}
