package uniandes.dpoo.taller4.interfaz;

import javax.swing.*;
import java.awt.*;


public class PanelOpciones extends JPanel {

	public PanelOpciones()
	{
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
		contenedor.add(btn1);
		contenedor.add(btn2);
		contenedor.add(btn3);
		contenedor.add(btn4);
		
		//Agregar los componentes:
		this.add(Box.createGlue());
		
		this.add(contenedor);
		
		this.add(Box.createGlue());
		
	}

}
