package group.event.eventi.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "event_details")
public class EventDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "event_id")
	private int event;

    @Column(name = "city")
	private String city;

    @Column(name = "place")
	private String place;

    @Column(name = "date")
	private Date date;

    @Column(name = "time_start")
	private String timeStart;

    @Column(name = "price")
	private int price;

    @Column(name = "capacity")
	private int capacity;

	public EventDetails() {

	}

	public EventDetails(int event, String city, String place, Date date, String timeStart, int price, int capacity) {
		this.event = event;
		this.city = city;
		this.place = place;
        this.date = date;
		this.timeStart = timeStart;
		this.price = price;
		this.capacity = capacity;
	}

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getEvent() {
        return this.event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTimeStart() {
        return this.timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    

	@Override
	public String toString() {
		return "User [id=" + id + ", event=" + event + ", city=" + city + ", place=" + place + ", date=" + date + ", timeStart=" + timeStart + ", price=" + price + ", capacity=" + capacity + "]";
	}

}