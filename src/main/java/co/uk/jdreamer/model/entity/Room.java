package co.uk.jdreamer.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="t_room")
public class Room implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "room_number")
	private String roomNumber;
	@Column(name = "bed_info")
	private String bedInfo;

	public Room() {}

	public Room(String name, String roomNumber, String bedInfo) {
		super();
		this.name = name;
		this.roomNumber = roomNumber;
		this.bedInfo = bedInfo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return roomNumber;
	}

	public void setNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getBedInfo() {
		return bedInfo;
	}

	public void setBedInfo(String bedInfo) {
		this.bedInfo = bedInfo;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", room number=" + roomNumber + ", bedInfo=" + bedInfo + "]";
	}

}
