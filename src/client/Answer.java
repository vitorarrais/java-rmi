package client;

import java.io.Serializable;

public class Answer implements Serializable {

	private static final long serialVersionUID = 7526472295622776147L;
	
	public int status;
	public String message;
	public long time;

   	public Answer(int status, String message, long time) {
   		this.status = status;
   		this.message = message;
   		this.time = time;
   	}

}