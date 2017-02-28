package it.univaq.disim.sose.smt.parking.webservices;

import org.springframework.stereotype.Component;

import it.univaq.disim.sose.smt.parking.ParkingPT;
import it.univaq.disim.sose.smt.parking.ParkingRequest;
import it.univaq.disim.sose.smt.parking.ParkingResponse;



@Component(value="ParkingPTImpl")
public class ParkingPTImpl implements ParkingPT
{

	@Override
	public ParkingResponse parking(ParkingRequest parameters) {
		// TODO Auto-generated method stub
		return null;
	}

}
