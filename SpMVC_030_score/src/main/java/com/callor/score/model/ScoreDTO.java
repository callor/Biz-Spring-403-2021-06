package com.callor.score.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ScoreDTO {
	private Long sc_seq;
	private String sc_stnum;
	private String sc_stname;
	private String sc_sbcode;
	private String sc_sbname;
	private int sc_score;
}
