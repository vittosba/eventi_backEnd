package group.event.eventi.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

    @Column(name = "sex")
	private char sex;

    @Column(name = "email")
	private String email;

    @Column(name = "password")
	private String password;

    @Column(name = "dateofbirth")
	private Date dateofbirth;

    @Column(name = "cityofbirth")
	private String cityofbirth;

	public User() {

	}

	public User(String name, String surname, char sex, String email, String password, Date dateofbirth, String cityofbirth) {
		this.name = name;
		this.surname = surname;
		this.sex = sex;
        this.email = email;
		this.password = password;
		this.dateofbirth = dateofbirth;
		this.cityofbirth = cityofbirth;
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

    public char getSex() {
        return this.sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getdateofbirth() {
        return this.dateofbirth;
    }

    public void setdateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getcityofbirth() {
        return this.cityofbirth;
    }

    public void setcityofbirth(String cityofbirth) {
        this.cityofbirth = cityofbirth;
    }
	

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", sex=" + sex + ", email=" + email + ", password=" + password + ", dateofbirth=" + dateofbirth + ", cityofbirth=" + cityofbirth + "]";
	}

}

