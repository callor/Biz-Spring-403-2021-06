package com.callor.book.exec;

import com.callor.book.model.BookDTO;

public class Main_01 {
	
	public static void main(String[] args) {
		
		// VO, DTO를 생성하고 데이터를 담기
		//1. 빈(blank) 객체를 생성하고, 
		//		필요한 값을 setter를 사용하여 저장하기
		//		필요한 데이터만큼 Setter method를 계속 나열해야 한다
		BookDTO bookDTO = new BookDTO();
		bookDTO.setTitle("자바야놀자");
		
		//2. 필드생성자를 사용하여
		//		객체를 생성하면서, 값을 주입하는 방법
		//		일부 데이터만 주입하여 객체를 생성할수 없다
		//		일부 데이터를 위하여 별도로 생성자를 또 만들어야 한다
		BookDTO bookDTO1 = new BookDTO(
				"자바야놀자",
				"linke",
				"image",
				"author",
\
				"discount",
				"publisher",
				"isbn",
				"desc",
				"pubdate");
		
				
		
		
		
	}

}
