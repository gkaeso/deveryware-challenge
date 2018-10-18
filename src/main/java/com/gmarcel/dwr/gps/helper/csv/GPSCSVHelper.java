package com.gmarcel.dwr.gps.helper.csv;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.gmarcel.dwr.gps.internal.Coordinate;
import com.gmarcel.dwr.gps.internal.Position;
import com.gmarcel.dwr.gps.internal.State;
import com.gmarcel.dwr.gps.internal.StateInfo;

/*
 * Provides with useful methods to process a CSV file
 * for the creation of a GPS.
 */
public class GPSCSVHelper {
	
	/*
	 * Retrieves the line of a CSV file.
	 */
	static public Object[] retrieveData(String line) {
		
		String[] array = line.replace("\"", "").split(";");
		
		return new Object[] { (Object)retrieveName(array), (Object)retrieveState(array) };
		
	}
	
	/*
	 * Build a GPS state from the values of a split CSV line
	 */
	static public State retrieveState(String[] array) {
		
		State state = new State();
		
		if(!GPSCSVHelper.isNullOrEmpty(array[2])) {
			LocalDateTime d = LocalDateTime.parse(array[2], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
			state.setDate(d);
		}		
		
		state.setPosition(retrievePosition(array));
		
		state.setStateInfo(retrieveStateInfo(array));
		
		return state;
		
	}
	
	/*
	 * Get the name of the GPS from the values of a split CSV line
	 */
	static public String retrieveName(String[] array) {
		
		String name =  null;
		
		if(!GPSCSVHelper.isNullOrEmpty(array[1])) {
			name = array[1].trim();
		}
		
		return name;
	}

	/*
	 * Build a GPS coordinates from the values of a split CSV line
	 */
	static public Coordinate retrieveCoordinates(String[] array) {
		
		Coordinate coordinates = new Coordinate();
		
		if(!GPSCSVHelper.isNullOrEmpty(array[3])) {
			coordinates.setLongitude(Double.parseDouble(array[3].trim()));
		}
		if(!GPSCSVHelper.isNullOrEmpty(array[4])) {
			coordinates.setLatitude(Double.parseDouble(array[4].trim()));
		}
		if(!GPSCSVHelper.isNullOrEmpty(array[8])) {
			coordinates.setAltitude(Float.parseFloat(array[8].trim()));
		}
		
		return coordinates;
	}
	
	/*
	 * Build a GPS position from the values of a split CSV line
	 */
	static public Position retrievePosition(String[] array) {
		
		Position position = new Position();
		
		position.setCoordinates(retrieveCoordinates(array));
		
		if(!GPSCSVHelper.isNullOrEmpty(array[9])) {
			position.setAddress(array[9].trim());
		}
		if(!GPSCSVHelper.isNullOrEmpty(array[5])) {
			position.setAccuracy(Float.parseFloat(array[5].trim()));
		}
		if(!GPSCSVHelper.isNullOrEmpty(array[6])) {
			position.setSpeed(Float.parseFloat(array[6].trim()));
		}
		if(!GPSCSVHelper.isNullOrEmpty(array[7])) {
			position.setHeading(Float.parseFloat(array[7].trim()));
		}
		
		return position;
	}
	
	/*
	 * Build GPS state extra information from the values of a split CSV line
	 */
	static public StateInfo retrieveStateInfo(String[] array) {
		
		StateInfo stateInfo = new StateInfo();
		
		if(!GPSCSVHelper.isNullOrEmpty(array[16]) && array[16].trim().equals("1")) {
			stateInfo.setGprsOn(true);
		} else {
			stateInfo.setGprsOn(false);
		}
		if(!GPSCSVHelper.isNullOrEmpty(array[17]) && array[17].trim().equals("1")) {
			stateInfo.setBatteryOn(true);
		} else {
			stateInfo.setBatteryOn(false);
		}
		if(!GPSCSVHelper.isNullOrEmpty(array[18]) && array[18].trim().equals("1")) {
			stateInfo.setApcOn(true);
		} else {
			stateInfo.setApcOn(false);
		}
		if(!GPSCSVHelper.isNullOrEmpty(array[19])) {
			stateInfo.setBatteryLevel(Integer.parseInt(array[19]));
		}
		
		return stateInfo;
	}
	
	/*
	 * Check if a string is empty of null
	 */
	static public boolean isNullOrEmpty(String s) {
		
		if(s== null || s.trim().isEmpty()) {
			return true;
		}
		
		return false;
		
	}
	
}
