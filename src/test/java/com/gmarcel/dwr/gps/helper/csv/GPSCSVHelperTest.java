package com.gmarcel.dwr.gps.helper.csv;

import static org.junit.jupiter.api.Assertions.*;

import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import com.gmarcel.dwr.gps.internal.State;

class GPSCSVHelperTest {

	private final String line = "1;\"GPS Fictif\";\"18/07/2018 12:24:55\";\"2.33532\";\"48.874723333333336\";\"21\";\"0.0\";\"0\";\"82\";\"Deveryware, 43 Rue Taitbout, 75009 Paris, France\";;;;;;;\"1\";\"0\";\"1\";\"61\";;;;;;;;;\"0\";;;;";
	
	@Test
	void testRetrieveData() {
		
		Object[] gpsDetails = GPSCSVHelper.retrieveData(line);
		State state = (State)gpsDetails[1];
		
		assertEquals(state.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")).toString(), "18/07/2018 12:24:55");
		
		assertEquals(state.getPosition().getAccuracy(), 21);
		assertEquals(state.getPosition().getAddress(), "Deveryware, 43 Rue Taitbout, 75009 Paris, France");
		assertEquals(state.getPosition().getHeading(),0);
		assertEquals(state.getPosition().getSpeed(), 0.0);
		assertEquals(state.getPosition().getCoordinates().getLongitude(), 2.33532);
		assertEquals(state.getPosition().getCoordinates().getLatitude(), 48.874723333333336);
		assertEquals(state.getPosition().getCoordinates().getAltitude(), 82);
		
		assertTrue(state.getStateInfo().isGprsOn());
		assertFalse(state.getStateInfo().isBatteryOn());
		assertTrue(state.getStateInfo().isApcOn());
		assertEquals(state.getStateInfo().getBatteryLevel(), 61);
		
	}

}
