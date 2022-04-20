package group.event.eventi.model;

import javax.persistence.*;

@Entity
@Table(name = "artist_events")
public class ArtistsEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "artist_id")
	private int artist;

	@Column(name = "event_id")
	private int event;

	public ArtistsEvent() {

	}

	public ArtistsEvent(int artist, int event) {
		this.artist = artist;
		this.event = event;
	}


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getArtist() {
        return this.artist;
    }

    public void setArtist(int artist) {
        this.artist = artist;
    }

    public int getEvent() {
        return this.event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", artist=" + artist + ", event=" + event + "]";
	}

}