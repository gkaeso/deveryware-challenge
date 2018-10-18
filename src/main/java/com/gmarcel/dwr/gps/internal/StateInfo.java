package com.gmarcel.dwr.gps.internal;

/*
 * Gives further details about a GPS state
 */
public class StateInfo {

	private boolean isGprsOn;
	private boolean isBatteryOn;
	private boolean isApcOn;
	private int batteryLevel;
	
	public StateInfo() {
		super();
	}

	public boolean isGprsOn() {
		return isGprsOn;
	}

	public void setGprsOn(boolean isGprsOn) {
		this.isGprsOn = isGprsOn;
	}

	public boolean isBatteryOn() {
		return isBatteryOn;
	}

	public void setBatteryOn(boolean isBatteryOn) {
		this.isBatteryOn = isBatteryOn;
	}

	public boolean isApcOn() {
		return isApcOn;
	}

	public void setApcOn(boolean isApcOn) {
		this.isApcOn = isApcOn;
	}

	public int getBatteryLevel() {
		return batteryLevel;
	}

	public void setBatteryLevel(int batteryLevel) {
		this.batteryLevel = batteryLevel;
	}
	
}
