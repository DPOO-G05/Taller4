package uniandes.dpoo.taller4.interfaz;

import javax.swing.*;
import java.awt.*;


public class PanelPartida extends JPanel {

	private InterfazJuego principal;
	
	private JTextField txtJugadas;
	
	private JTextField txtJugador;
	
	
	public PanelPartida(InterfazJuego principal)
	{
		//Asignar el principal
		this.principal = principal;
		//Determinar el Layout
		GridLayout layout = new GridLayout(1,4);
		layout.setHgap(10);
		this.setLayout(layout);
		//Crear los componentes de contenido
		JLabel lblJugadas = new JLabel("Jugadas: ");
		this.txtJugadas = new JTextField();
		txtJugadas.setEditable(false);
		JLabel lblJugador= new JLabel("Jugador: ");
		this.txtJugador= new JTextField();
		txtJugador.setEditable(false);
		
		//Agregar los componentes
		
		this.add(lblJugadas);
		
		this.add(txtJugadas);
		
		this.add(lblJugador);
		
		this.add(txtJugador);
		
	}
	
	public void actualizarPuntaje()
	{
		String puntaje = String.valueOf(principal.getJugadas());
		this.txtJugadas.setText(puntaje); 
	}

	public void actualizarNombre()
	{
		String nombre = principal.getJugador();
		this.txtJugador.setText(nombre);
	}
	
}
