package uniandes.dpoo.taller4.interfaz;

import javax.swing.*;
import java.awt.*;



public class InterfazJuego extends JFrame
{

	
	PanelConfiguracion configuracion;
	PanelTablero tablero;
	PanelOpciones opciones;
	PanelPartida partida;
	
	public InterfazJuego()
	{
		//Determinar titulo y tama�o de la ventana
		this.setTitle("Lights Out");
		this.setSize( 1000, 700 );

		
		//Configuraci�n de Ventana
		this.setResizable(false);
	
		//Determinaci�n del Layout
		this.setLayout(new BorderLayout());
		
		
		//Inicializaci�n de Componentes
		this.configuracion = new PanelConfiguracion();
		this.tablero = new PanelTablero(3);
		tablero.setDimension(5);
		this.opciones = new PanelOpciones();
		this.partida = new PanelPartida();
	
		
		//Ordenar el Layout
		
		this.add(this.configuracion, BorderLayout.NORTH);
		this.add(this.tablero,BorderLayout.CENTER);
		this.add(this.opciones,BorderLayout.EAST);
		this.add(this.partida, BorderLayout.SOUTH); 
		
		//Hacer Visible
		this.setVisible(true);
		
		
	}
	
}
