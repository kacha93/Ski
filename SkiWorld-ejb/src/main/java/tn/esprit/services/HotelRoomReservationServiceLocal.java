package tn.esprit.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.HotelRoomReservation;

@Local
public interface HotelRoomReservationServiceLocal {
	
	public void create (HotelRoomReservation hotelRoomReservation);
	public void edit (HotelRoomReservation hotelRoomReservation);
	public void delete(HotelRoomReservation hotelRoomReservation);
	public HotelRoomReservation findById(int id);
	public List<HotelRoomReservation> findByUserId(int userId);
	public List<HotelRoomReservation>findAll();
	public List<HotelRoomReservation> findByDate(Date date);
	public boolean checkAvailability (Date date);
	

}
