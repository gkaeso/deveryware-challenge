package com.gmarcel.dwr.gps.internal;

/*
 * Represents a GPS coordinates in 3 dimensions
 */
public class Coordinate {

	private double longitude;
	private double latitude;
	private float altitude;
	
	public Coordinate() {
		super();
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public float getAltitude() {
		return altitude;
	}

	public void setAltitude(float altitude) {
		this.altitude = altitude;
	}
	
}
