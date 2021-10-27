package uniandes.dpoo.taller4.interfaz;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


public class PanelOpciones extends JPanel implements ActionListener {

	private InterfazJuego principal;
	
	private static final String NUEVO = "NUEVO";

	private static final String REINICIAR = "REINICIAR";

	private static final String TOP10 = "TOP10"; 

	private static final String  JUGADOR = "CAMBIAR JUGADOR";

	public PanelOpciones(InterfazJuego principal)
	{
		//Asignar el principal
		this.principal = principal;

		this.principal = principal;

		//Configurar Layout
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//Crear los componentes
		JPanel contenedor = new JPanel();
		GridLayout layout = new GridLayout(4,1);
		layout.setVgap(5);
		contenedor.setLayout(layout);
		JButton btn1 = new JButton("NUEVO");
		btn1.setActionCommand(NUEVO);
		JButton btn2 = new JButton("REINICIAR");
		btn2.setActionCommand(REINICIAR);
		JButton btn3 = new JButton("TOP-10");
		btn3.setActionCommand(TOP10);
		JButton btn4 = new JButton("CAMBIAR JUGADOR");
		btn4.setActionCommand(JUGADOR);
		
		JButton[] botones = {btn1, btn2, btn3, btn4};
		//Cambiar el color, letra de los botones, agregar listener y agregarlos
		Font f = new Font("Sans Serif", Font.BOLD,17);
		Color color = new Color(43,136,224);
		for(JButton boton: botones)
		{
			boton.addActionListener(this);
			boton.setFont(f);
			boton.setBackground(color);
			boton.setForeground(Color.WHITE);
			contenedor.add(boton);
		}
		
		//Agregar los componentes:
		this.add(Box.createGlue());
		
		this.add(contenedor);
		
		this.add(Box.createGlue());
		
		//Agregar los Listeners
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		String comando = e.getActionCommand();
		
		if (comando.equals(NUEVO))
		{
			principal.nuevaPartida();
		}
		else if(comando.equals(REINICIAR))
		{
			//principal.reiniciarPartida();
		}
		else if(comando.equals(TOP10))
		{
			//principal.mostrarTop10();
		}
		else if(comando.equals(JUGADOR))
		{
			//principal.cambiarJugador();
		}
		
	}

}
