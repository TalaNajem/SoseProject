package it.univaq.disim.sose.smt.parking.business.model;

public class Parking implements java.io.Serializable {

	private Long id;
	private String name;
	private double latitude;
	private double longitude;
	private int capacity;
	private int capacityDisabled;
	private double fee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacityDisabled() {
		return capacityDisabled;
	}

	public void setCapacityDisabled(int capacityDisabled) {
		this.capacityDisabled = capacityDisabled;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

}