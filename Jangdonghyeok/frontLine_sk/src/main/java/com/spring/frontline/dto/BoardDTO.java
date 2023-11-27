package com.spring.frontline.dto;

import java.util.List;

public class BoardDTO {
	private int boardSeq = -1;
	private int userSeq = -1;
	private int regionSeq = -1;
	private int typeSeq = -1;
	private String boardTitle;
	private String boardAddress;
	private String boardOpen;
	private String boardDetail;
	private String boardRegDate;
	private String boardBreak;
	private String boardPhone;
	private String boardImage;
	
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public int getRegionSeq() {
		return regionSeq;
	}
	public void setRegionSeq(int regionSeq) {
		this.regionSeq = regionSeq;
	}
	public int getTypeSeq() {
		return typeSeq;
	}
	public void setTypeSeq(int typeSeq) {
		this.typeSeq = typeSeq;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardAddress() {
		return boardAddress;
	}
	public void setBoardAddress(String boardAddress) {
		this.boardAddress = boardAddress;
	}
	public String getBoardOpen() {
		return boardOpen;
	}
	public void setBoardOpen(String boardOpen) {
		this.boardOpen = boardOpen;
	}
	public String getBoardDetail() {
		return boardDetail;
	}
	public void setBoardDetail(String boardDetail) {
		this.boardDetail = boardDetail;
	}
	public String getBoardRegDate() {
		return boardRegDate;
	}
	public void setBoardRegDate(String boardRegDate) {
		this.boardRegDate = boardRegDate;
	}
	public String getBoardBreak() {
		return boardBreak;
	}
	public void setBoardBreak(String boardBreak) {
		this.boardBreak = boardBreak;
	}
	public String getBoardPhone() {
		return boardPhone;
	}
	public void setBoardPhone(String boardPhone) {
		this.boardPhone = boardPhone;
	}
	public String getBoardImage() {
		return boardImage;
	}
	public void setBoardImage(String boardImage) {
		this.boardImage = boardImage;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [boardSeq=" + boardSeq + ", userSeq=" + userSeq + ", regionSeq=" + regionSeq + ", typeSeq="
				+ typeSeq + ", boardTitle=" + boardTitle + ", boardAddress=" + boardAddress + ", boardOpen=" + boardOpen
				+ ", boardDetail=" + boardDetail + ", boardRegDate=" + boardRegDate + ", boardBreak=" + boardBreak
				+ ", boardPhone=" + boardPhone + ", boardImage=" + boardImage + "]";
	}
	
}
