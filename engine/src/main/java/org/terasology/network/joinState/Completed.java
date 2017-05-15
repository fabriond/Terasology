package org.terasology.network.joinState;

public class Completed implements Status {
	
	@Override
	public String getMessage() {
		return "";
	}

	@Override
	public void changeStatus(StatusManager status, String message) {
		status.changeStatus(new Failed(message));		
	}

}
