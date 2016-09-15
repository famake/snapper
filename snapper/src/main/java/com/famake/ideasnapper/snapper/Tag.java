package com.famake.ideasnapper.snapper;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private long id;
	private String title, def;
	
	@ManyToMany(mappedBy="tags")
	private List<Ide> ideer;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDef() {
		return def;
	}
	public void setDef(String def) {
		this.def = def;
	}
	
	
}
