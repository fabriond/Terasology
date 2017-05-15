package org.terasology.network.joinState;

public class Failed implements Status {
	
	String errorMessage = "";
	
	Failed(String errorMessage){
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String getMessage() {
		return errorMessage;
	}

	@Override
	public void changeStatus(StatusManager status, String message) {
		status.changeStatus(new Completed());		
	}

}
