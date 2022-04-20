package group.event.eventi.model;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

    @Column(name = "img")
	private String img;

    @Column(name = "category_id")
	private int category;

	public Event() {

	}

	public Event(String name, String description, String img, int category) {
		this.name = name;
		this.description = description;
		this.img = img;
        this.category = category;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", description=" + description + ", img=" + img + ", category=" + category + "]";
	}

}