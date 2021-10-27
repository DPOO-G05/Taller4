package uniandes.dpoo.taller4.interfaz;

import javax.swing.*;
import java.awt.*;



public class InterfazJuego extends JFrame
{

	
	private PanelConfiguracion configuracion;
	private PanelTablero tablero;
	private PanelOpciones opciones;
	private PanelPartida partida;
	
	private CoordLightsOut coordinador;
	
	public InterfazJuego()
	{
			//Determinar titulo y tamaño de la ventana
		this.setTitle("Lights Out");
		this.setSize( 1000, 700 );

		
		//Configuración de Ventana
		this.setResizable(false);
	
		//Determinación del Layout
		this.setLayout(new BorderLayout());
		
		
		//Inicialización de Componentes
		this.configuracion = new PanelConfiguracion(this);
		this.tablero = new PanelTablero(this,3);
		tablero.setDimension(5);
		this.opciones = new PanelOpciones(this);
		this.partida = new PanelPartida(this);
	
		//Crear el Coordinador
		this.coordinador = new CoordLightsOut(this);

		//Ordenar el Layout
		
		this.add(this.configuracion, BorderLayout.NORTH);
		this.add(this.tablero,BorderLayout.CENTER);
		this.add(this.opciones,BorderLayout.EAST);
		this.add(this.partida, BorderLayout.SOUTH); 
		
		//Hacer Visible
		this.setVisible(true);
		
		
	}
	
	public void jugar(int fila, int columna)
	{
		this.coordinador.getTablero().jugar(fila, columna);
	}

	public PanelConfiguracion getConfiguracion() {
		return configuracion;
	}

	public PanelTablero getTablero() {
		return tablero;
	}

	public PanelOpciones getOpciones() {
		return opciones;
	}

	public PanelPartida getPartida() {
		return partida;
	}

	public CoordLightsOut getCoordinador() {
		return coordinador;
	}
	
}
