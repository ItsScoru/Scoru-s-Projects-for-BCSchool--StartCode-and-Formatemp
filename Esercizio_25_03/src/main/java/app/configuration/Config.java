package app.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import app.beans.Automobile;
import app.beans.Motore;

@Configuration
public class Config {

    @Bean(name = "auto_benzina")
    Automobile getAutoBenzina(@Qualifier("benzina") Motore motore) {
		return new Automobile(motore);
	}

    @Lazy
    @Bean(name = "auto_elettrica")
    Automobile getAutoElettrica( @Qualifier("elettrico") Motore motore) {
		return new Automobile(motore);
	}
	
    @Lazy
	@Bean(name = "auto_ibrida")
	Automobile getAutoIbrida(@Qualifier("ibrido") Motore motore) {
		return new Automobile(motore);
	}
    
    @Lazy
    @Bean
    @Qualifier("ibrido")
    Motore getMotoreIbrido() {
    	return new Motore("Ibrido");
    }
    
    @Bean
    @Qualifier("benzina")
    Motore getMotoreBenzina() {
    	return new Motore("Benzina");
    }
    
    @Lazy
    @Bean
    @Qualifier("elettrico")
    Motore getMotoreElettrico() {
    	return new Motore("Elettrico");
    }

}
