package album.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String pass;
	
	@OneToMany(mappedBy="user")
	private List<Photo> photos  =  new ArrayList<Photo>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public List<Photo> getPhotos() {
		return photos;
	}

	
}
