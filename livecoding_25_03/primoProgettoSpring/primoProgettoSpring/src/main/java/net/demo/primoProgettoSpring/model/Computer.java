package net.demo.primoProgettoSpring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Computer {

	private String modello;

	
	@Autowired
	@Lazy
	private SchedaVideo schedaVideo;

	public Computer() {
		super();
	}

	public Computer(String modello, SchedaVideo schedaVideo) {
		super();
		this.modello = modello;
		this.schedaVideo = schedaVideo;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public SchedaVideo getSchedaVideo() {
		return schedaVideo;
	}

	public void setSchedaVideo(SchedaVideo schedaVideo) {
		this.schedaVideo = schedaVideo;
	}

	@Override
	public String toString() {
		return "Computer [modello=" + modello + ", schedaVideo=" + schedaVideo + "]";
	}

}
