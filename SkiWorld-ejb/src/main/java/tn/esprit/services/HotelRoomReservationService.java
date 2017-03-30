package tn.esprit.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.HotelRoomReservation;

/**
 * Session Bean implementation class HotelRoomReservationService
 */
@Stateless
public class HotelRoomReservationService implements  HotelRoomReservationServiceLocal {



	@PersistenceContext
	EntityManager em;
	
    public HotelRoomReservationService() {
        
    	
    }

	@Override
	public void create(HotelRoomReservation hotelRoomReservation) {
//		while(hotelRoomReservation.getCheckIn().before(hotelRoomReservation.getCheckOut())){
//			
//			em.persist(hotelRoomReservation);
//			Date date = new Date();
//			date = hotelRoomReservation.getCheckIn();
//			date = Calendar.
//			hotelRoomReservation.setCheckIn(hotelRoomReservation.getCheckIn());}
		
	}

	@Override
	public void edit(HotelRoomReservation hotelRoomReservation) {
		em.merge(hotelRoomReservation);
		
	}

	@Override
	public void delete(HotelRoomReservation hotelRoomReservation) {
		em.remove(em.merge(hotelRoomReservation));
		
	}

	@Override
	public HotelRoomReservation findById(int id) {
		
		return em.find(HotelRoomReservation.class, id);
	}

	

	@Override
	public List<HotelRoomReservation> findAll() {
		return em.createNamedQuery("HotelRoomReservation.findAll", HotelRoomReservation.class)
				.getResultList();
	}

	@Override
	public List<HotelRoomReservation> findByUserId(int userId) {
		
		return em.createNamedQuery("Hotelroomreservation.findByUserId", HotelRoomReservation.class)
				.getResultList();
	}

	@Override
	public List<HotelRoomReservation> findByDate(Date date) {
		return em.createNamedQuery("HotelRoomReservation.findByReservationDate", HotelRoomReservation.class)
				.getResultList();
	}

	@Override
	public boolean checkAvailability(Date date) {
		
		return (findByDate(date).size()>0);
		 
	}
	
//	public Date nextDay(Calendar date){
//		date.
//		
//		
//		
//	}

}
