package edu.kh.project.board.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardImage {
	
	private int imageNo;
	private String imagePath;
	private String imageReName;
	private String imageOriginal;
	private int imageOrder;
	private int boardNo;


}
