package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Hotel;

@Local
public interface HotelServiceLocal {
	
	public void create (Hotel hotel);
	public void edit (Hotel hotel);
	public void delete (Hotel hotel);
	public List<Hotel> findAll();
	public Hotel findById(int id);

}
