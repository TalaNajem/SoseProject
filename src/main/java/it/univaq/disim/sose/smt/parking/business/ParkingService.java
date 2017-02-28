package it.univaq.disim.sose.smt.parking.business;

import java.util.List;

import it.univaq.disim.sose.smt.parking.business.model.Parking;

public interface ParkingService {
	List<Parking> getParkings(double latitude, double longitude, int range) throws BusinessException;

}