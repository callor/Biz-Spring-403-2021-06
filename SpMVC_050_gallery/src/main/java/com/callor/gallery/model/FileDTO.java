package com.callor.gallery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileDTO {
	
	private Long file_seq;//	BIGINT
	private Long file_gseq;//	BIGINT
	private String file_original;//	VARCHAR(125)
	private String file_upname;//	VARCHAR(125)

}
