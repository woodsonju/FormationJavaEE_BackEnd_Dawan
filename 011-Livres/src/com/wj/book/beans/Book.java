package com.wj.book.beans;

public class Book {
	
	private String title;
	private String auteur;
	private int year;
	
	public Book() {
		super();

	}
	
	public Book(String title, String auteur, int year) {
		super();
		this.title = title;
		this.auteur = auteur;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", auteur=" + auteur + ", year=" + year + "]";
	}

	

}
