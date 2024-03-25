package net.demo.primoProgettoSpring.model;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Lazy
public class SchedaVideo {

	private int memoria;

	public SchedaVideo() {
		super();
	}

	public SchedaVideo(int memoria) {
		super();
		this.memoria = memoria;
	}

	public int getMemoria() {
		return memoria;
	}

	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}

	@Override
	public String toString() {
		return "SchedaVideo [memoria=" + memoria + "]";
	}

	@PostConstruct
	public void inizializzazione() {
		System.out.println("Bean SchedaVideo creato");
	}
}
