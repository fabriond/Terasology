package org.terasology.network.joinState;

public class InProgress implements Status {
	
	@Override
	public String getMessage() {
		return "";
	}

	@Override
	public void changeStatus(StatusManager status, String message) {
		if(message.isEmpty()) status.changeStatus(new Completed());
		else status.changeStatus(new Failed(message));
		
	}

}
