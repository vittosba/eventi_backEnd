package group.event.eventi.model;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

    @Column(name = "surname")
	private String surname;

    @Column(name = "art_name")
	private String artName;

	public Artist() {

	}

	public Artist(String name, String surname, String artName) {
		this.name = name;
		this.surname = surname;
		this.artName = artName;
	}


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getArtName() {
        return this.artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", artName=" + artName + "]";
	}

}