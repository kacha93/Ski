package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Hotel;
import tn.esprit.entities.Parking;

@Local
public interface ParkingServiceLocal {
	
	public void create(Parking parking);
	public void edit (Parking parking);
	public void delete (Parking parking);
	public List<Parking> findAll();
	public Parking findById(int id);
	public Parking findByHotel(Hotel hotel);
	

}
