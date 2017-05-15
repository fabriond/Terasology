package org.terasology.network.joinState;

import org.terasology.network.joinState.Status;

public class StatusManager {
	
	Status currentStatus = new InProgress();
	
	public void changeStatus(Status newStatus){
		currentStatus = newStatus;
	}
	
	public void setStatus(String message){
		currentStatus.changeStatus(this, message);
	}
	
	public Status getStatus(){
		return currentStatus;
	}

}
