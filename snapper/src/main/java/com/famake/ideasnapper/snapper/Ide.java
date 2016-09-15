package com.famake.ideasnapper.snapper;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Ide {
	
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String ide;
	private Date dato;
	private Integer bbb;
	private String author;
	
	@ManyToMany
	@JoinTable(
		name="mapping_table",
		joinColumns=@JoinColumn(name="ide_id", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="tag_id", referencedColumnName="id"))
	private List<Tag> tags;
	
	public Date getDato() {
		return dato;
	}
	public void setDato(Date dato) {
		this.dato = dato;
	}
	public String getIde() {
		return ide;
	}
	public void setIde(String ide) {
		this.ide = ide;
	}
	public Integer getBbb() {
		return bbb;
	}
	public void setBbb(Integer bbb) {
		this.bbb = bbb;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getId() {
		return id;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	
}
