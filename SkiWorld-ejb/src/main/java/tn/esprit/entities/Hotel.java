package tn.esprit.entities;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Hotel
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h"),
		@NamedQuery(name = "Hotel.findById", query = "SELECT h FROM Hotel h WHERE h.id = :id"),
		@NamedQuery(name = "Hotel.findByAdress", query = "SELECT h FROM Hotel h WHERE h.adress = :adress"),
		@NamedQuery(name = "Hotel.findByAvailableRooms", query = "SELECT h FROM Hotel h WHERE h.availableRooms = :availableRooms"),
		@NamedQuery(name = "Hotel.findByName", query = "SELECT h FROM Hotel h WHERE h.name = :name"),
		@NamedQuery(name = "Hotel.findByRoomNumber", query = "SELECT h FROM Hotel h WHERE h.roomNumber = :roomNumber"),
		@NamedQuery(name = "Hotel.findByStars", query = "SELECT h FROM Hotel h WHERE h.stars = :stars") })
public class Hotel implements Serializable {

	private int id;
	private String name;
	private int stars;
	private int roomNumber;
	private int availableRooms;
	private Adress adress;
	private String logoPath;
	private byte[] logo;

	private Parking parking;
	private HotelManager hotelManager;

	private List<HotelRoom> hotelRoom;

	private static final long serialVersionUID = 1L;

	public Hotel() {
		super();
		this.hotelRoom = new ArrayList<HotelRoom>();
		this.adress = new Adress();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Size(min = 3, message = "Hotel name must be at least of length 3")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Max(message = "Stars must be at maximum 6", value = 6)
	@Min(message = "stars must be at least 1", value = 1)
	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	@Min(message = "Rooms number must be at least 10", value = 10)

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getAvailableRooms() {
		return availableRooms;
	}

	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}

	@Embedded
	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	
	@Lob
	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	@OneToOne
	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

	@ManyToOne
	public HotelManager getHotelManager() {
		return hotelManager;
	}

	public void setHotelManager(HotelManager hotelManager) {
		this.hotelManager = hotelManager;
	}

	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	public List<HotelRoom> getHotelRoom() {
		return hotelRoom;
	}

	public void setHotelRoom(List<HotelRoom> hotelRoom) {
		this.hotelRoom = hotelRoom;
	}

	@Override
	public String toString() {
		return "Hotel " + name + ", " + adress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

}
