package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.HotelRoom;

@Local
public interface HotelRoomServiceLocal {

	public void create(HotelRoom hotelRoom);
	public void edit(HotelRoom hotelRoom);
	public void delete(HotelRoom hotelRoom);
	public HotelRoom findById(int id);
	public List<HotelRoom>findAll ();
}
