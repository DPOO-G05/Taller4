package uniandes.dpoo.taller4.interfaz;

import uniandes.dpoo.taller4.modelo.*;



public class CoordLightsOut {


	private Tablero tablero;
	
	private Top10 top10;
	
	private InterfazJuego interfaz;

	public CoordLightsOut(InterfazJuego interfaz)
	{
		this.interfaz = interfaz;
		//Determinar la dimensión del tablero inicial
		
		int dimension = interfaz.getTablero().getDimension();
	
		//Crear Tablero y Top10
		this.tablero = new Tablero(dimension);
		this.top10 = new Top10();
		
		
	}

	public Tablero getTablero() {
		return tablero;
	}
	
	public void nuevoTablero(int dimension)
	{
		this.tablero = new Tablero(dimension);
	}

	public Top10 getTop10() {
		return top10;
	}

	public InterfazJuego getInterfaz() {
		return interfaz;
	}
	
	
}
