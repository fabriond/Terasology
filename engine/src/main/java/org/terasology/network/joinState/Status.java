package org.terasology.network.joinState;

public interface Status {
	
	public String getMessage();
	
	public void changeStatus(StatusManager status, String message); //if message is empty change to completed

}
