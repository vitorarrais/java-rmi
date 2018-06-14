package client;

import java.io.Serializable;

public class Discipline {
	
	public String title;
	public String syllabus;
	public String classroom;
	public String next_class;
	public String code;
	public int time;

   public Discipline() {}

	public Discipline(String title, String syllabus, String classroom, String next_class, String code, int time) {
		this.title = title;
		this.syllabus = syllabus;
		this.classroom = classroom;
		this.next_class = next_class;
		this.code = code;
		this.time = time;
	}

}