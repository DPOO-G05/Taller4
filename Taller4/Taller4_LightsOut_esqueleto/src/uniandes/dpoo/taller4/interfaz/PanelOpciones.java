package uniandes.dpoo.taller4.interfaz;

import javax.swing.*;
import java.awt.*;


public class PanelOpciones extends JPanel {

	private JFrame principal;
	public PanelOpciones(JFrame principal)
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
		JButton btn2 = new JButton("REINICIAR");
		JButton btn3 = new JButton("TOP-10");
		JButton btn4 = new JButton("CAMBIAR JUGADOR");
		
		JButton[] botones = {btn1, btn2, btn3, btn4};
		//Cambiar el color, letra de los botones y agregarlos

		Font f = new Font("Sans Serif", Font.BOLD,17);
		Color color = new Color(43,136,224);
		for(JButton boton: botones)
		{
			boton.setFont(f);
			boton.setBackground(color);
			boton.setForeground(Color.WHITE);
			contenedor.add(boton);
		}
		
		//Agregar los componentes:
		this.add(Box.createGlue());
		
		this.add(contenedor);
		
		this.add(Box.createGlue());
		
	}

}
