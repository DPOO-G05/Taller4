package uniandes.dpoo.taller4.app;
import uniandes.dpoo.taller4.modelo.*;
import uniandes.dpoo.taller4.interfaz.*;
import com.formdev.flatlaf.FlatLightLaf;

public class LightsOut {

	
	private InterfazJuego interfaz;
	
	
	
	public LightsOut()
	{
		this.interfaz = new InterfazJuego();
	}
	
	
	
	public static void main(String[] args) {
		//Instalar librerias
		FlatLightLaf.install();
		LightsOut juego = new LightsOut();

	}

}
