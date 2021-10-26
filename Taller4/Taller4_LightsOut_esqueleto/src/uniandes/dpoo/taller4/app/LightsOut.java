package uniandes.dpoo.taller4.app;
import uniandes.dpoo.taller4.modelo.*;
import uniandes.dpoo.taller4.interfaz.*;
import com.formdev.flatlaf.FlatLightLaf;

public class LightsOut {

	
	RegistroTop10 registro;
	Tablero tablero;
	Top10 top10;

	InterfazJuego interfaz;
	
	
	
	public LightsOut()
	{
		this.top10 = new Top10();
		this.interfaz = new InterfazJuego();
	}
	
	
	
	public static void main(String[] args) {
		//Instalar librerias
		FlatLightLaf.install();
		LightsOut juego = new LightsOut();

	}

}
