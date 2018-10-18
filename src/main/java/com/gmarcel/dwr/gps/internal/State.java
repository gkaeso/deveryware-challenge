package com.gmarcel.dwr.gps.internal;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * Represents the state of a GPS at a given time
 */
public class State {

	private LocalDateTime date;
	private Position position;
	private StateInfo stateInfo;
	
	public State() {
		super();
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime localDate) {
		this.date = localDate;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public StateInfo getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(StateInfo stateInfo) {
		this.stateInfo = stateInfo;
	}
	
}
