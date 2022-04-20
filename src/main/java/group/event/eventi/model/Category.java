package group.event.eventi.model;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

    public Category() {

	}

    public Category(String name) {
        this.name = name;
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

    @Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
