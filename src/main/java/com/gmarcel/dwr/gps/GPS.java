package com.gmarcel.dwr.gps;

import java.util.ArrayList;
import java.util.List;

import com.gmarcel.dwr.gps.internal.State;

/*
 * Represents a GPS
 */
public class GPS {

	private String name;
	private List<State> states;
	
	public GPS() {
		super();
		this.states = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<State> getStates() {
		return states;
	}

	public void addState(State state) {
		this.states.add(state);
	}
	
}
