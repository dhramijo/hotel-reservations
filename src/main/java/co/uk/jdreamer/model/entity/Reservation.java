package co.uk.jdreamer.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="t_reservation")
public class Reservation implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "room_id")
    private long roomId;
    @Column(name = "guest_id")
    private long guestId;
    @Column(name = "res_date")
    private Date resDate;
    
    @ManyToOne
    @JoinColumn(name = "room_id", insertable=false, updatable=false)
    private Room room;
    
    @ManyToOne
    @JoinColumn(name = "guest_id", insertable=false, updatable=false)
    private Guest guest;

    public Reservation() {}
    
    public Reservation(long roomId, long guestId, Date resDate, Room room, Guest guest) {
		super();
		this.roomId = roomId;
		this.guestId = guestId;
		this.resDate = resDate;
		this.room = room;
		this.guest = guest;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public Date getDate() {
        return resDate;
    }

    public void setDate(Date resDate) {
        this.resDate = resDate;
    }

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", roomId=" + roomId + ", guestId=" + guestId + ", date=" + resDate + "]";
	}
    
}