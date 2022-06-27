package com.example.demo.tables;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	private String title;
	@Column
	@Lob
	private String fulltext;
	@Column
	private String author;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Post() {
		
	}
	
	public Post(String title, String fulltext) {
		
		this.title = title;
		this.fulltext = fulltext;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFulltext() {
		return fulltext;
	}

	public void setFulltext(String fulltext) {
		this.fulltext = fulltext;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
