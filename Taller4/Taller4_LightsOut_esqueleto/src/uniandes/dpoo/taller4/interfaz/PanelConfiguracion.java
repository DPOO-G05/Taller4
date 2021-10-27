package uniandes.dpoo.taller4.interfaz;

import javax.swing.*;
import java.awt.*;


public class PanelConfiguracion extends JPanel {


	private InterfazJuego principal;
	
	
	public PanelConfiguracion(InterfazJuego principal)
	{
		//Asignar el principal
		this.principal = principal;
		//Determinar el Layout
		this.setLayout(new FlowLayout());
		
		//Cambiar Color de Fondo
		this.setBackground(new Color(43,136,224));
		
		//Crear Componentes
	
			//Tamaño
		JLabel lblTamanio = new JLabel("Tamaño");
		lblTamanio.setForeground(Color.white);
	
		Font f = new Font("Sans Serif", Font.BOLD,18);
		lblTamanio.setFont(f);	
		
		String[] opciones =  {"5x5", "4x4", "3x3"};

		JComboBox opcionesTamanio = new JComboBox(opciones);
	
			//Dificultad
		JLabel lblDificultad = new JLabel("Dificultad");
			
		lblDificultad.setFont(f);	
		lblDificultad.setForeground(Color.white);
		

		ButtonGroup dificultades = new ButtonGroup();
		
		JRadioButton facil = new JRadioButton("Fácil");
		facil.setForeground(Color.white);
		dificultades.add(facil);

			
		JRadioButton medio = new JRadioButton("Medio");
		medio.setForeground(Color.white);
		dificultades.add(medio);

	
		JRadioButton dificil = new JRadioButton("Dificil");
		dificil.setForeground(Color.white);
		dificultades.add(medio);
		dificultades.add(dificil);


		//Agergar los componentes al Panel
		
		this.add(lblTamanio);
		this.add(opcionesTamanio);
		
		this.add(lblDificultad);
		this.add(facil);
		this.add(medio);
		this.add(dificil);
		
		
	}
	
}
