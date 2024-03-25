package test;

import dao.VideogiocoDaoImpl;
import entity.Personaggio;
import entity.Videogioco;

public class Main {
	
	public static void main(String[] args) {
		
		Personaggio p1 = new Personaggio("Mario", 60, "Stelle", "Buoni", "Umano");
		Personaggio p2 = new Personaggio("Pikachu", 20, "Strumenti", "Buoni", "Pokemon");
		Personaggio p3 = new Personaggio("Sonic", 40, "Gemme", "Buoni", "Riccio");
		
		Videogioco v1 = new Videogioco("Smash", 60, "Picchiaduro", "Picchiaduro", 8);
		
		p1.setVideogioco(v1);
		p2.setVideogioco(v1);
		p3.setVideogioco(v1);
		
		v1.getPersonaggi().add(p1);
		v1.getPersonaggi().add(p2);
		v1.getPersonaggi().add(p3);
		
		VideogiocoDaoImpl vgDao = new VideogiocoDaoImpl();
		
		vgDao.save(v1);
		
	}

}
