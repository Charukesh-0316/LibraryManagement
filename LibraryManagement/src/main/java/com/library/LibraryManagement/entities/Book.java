package com.library.LibraryManagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.*;

//@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
@Table(name = "Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	private String name;
	
	private String author;
	
	private int pages;
	
	private double price;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(long id, String name, String author, int pages, double price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.pages = pages;
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "book [id=" + id + ", name=" + name + ", author=" + author + ", pages=" + pages + ", price=" + price
				+ "]";
	}

}
