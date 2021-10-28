package uniandes.dpoo.taller4.interfaz;

import java.util.Collection;

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

	
	public void agregarTop10(String nombre, int puntaje)
	{
		this.top10.agregarRegistro(nombre, puntaje);
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
	
	public String[] mostrarTop10()
	{
		String informacion = "";
		
		Collection<RegistroTop10> registros = this.top10.darRegistros();
	
		for (RegistroTop10 registro: registros)
		{
			String nombre = registro.darNombre();
			String puntaje = String.valueOf(registro.darPuntos()); 
			
			informacion += nombre + ";" + puntaje + ",";
		}
		
		return informacion.split(",");
		
		
	}
	
	
}
