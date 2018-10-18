package com.gmarcel.dwr.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.gmarcel.dwr.gps.GPS;
import com.gmarcel.dwr.gps.helper.csv.GPSCSVHelper;
import com.gmarcel.dwr.gps.internal.State;

/*
 * This app aims at calculating the mean altitude of a GPS
 * based on its coordinates provided in the resource folder.
 */
public class App 
{
    public static void main( String[] args )
    {

    	final String FILENAME = "histo.csv";
    	Path filePath = Paths.get("src", "main", "resources", FILENAME).toAbsolutePath();

    	if(!Files.exists(filePath)) { 
    		System.out.println("ERROR: File not found at location " + filePath);
    		System.exit(1);
    	}
    	
    	final GPS gps = new GPS();
    	
    	try (Stream<String> lines = Files.lines(filePath)) {

    		lines.forEach(line -> {

    			if(!line.toLowerCase().startsWith("line number")) {
    				Object[] gpsDetails = GPSCSVHelper.retrieveData(line);
    				
    				if(gps.getName() == null || gps.getName().isEmpty()) {
    					gps.setName((String)gpsDetails[0]);
    				}
        				
    				gps.addState((State)gpsDetails[1]);
    			}
    			
    		});
		} 
    	catch (IOException e) {
			e.printStackTrace();
		}
    	
    	// PRINT MEAN ALTITUDE
    	float meanAltitude = 0;
		for(State s : gps.getStates()) {
			meanAltitude += s.getPosition().getCoordinates().getAltitude();
		}
		meanAltitude = meanAltitude / gps.getStates().size();
		System.out.println("GPS mean altitude: " + meanAltitude);

    	
    }
    
}
