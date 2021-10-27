package uniandes.dpoo.taller4.interfaz;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;


public class PanelConfiguracion extends JPanel {


	private InterfazJuego principal;

	private JComboBox opcionesTamanio;
	
	private ButtonGroup dificultades;	 
	
	public final static String FACIL = "Fácil";
	
	public final static String MEDIO = "Medio";
	
	public final static String DIFICIL = "Dificil";
	
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

		this.opcionesTamanio = new JComboBox(opciones);
	
			//Dificultad
		JLabel lblDificultad = new JLabel("Dificultad");
			
		lblDificultad.setFont(f);	
		lblDificultad.setForeground(Color.white);
		

		this.dificultades = new ButtonGroup();
		
		JRadioButton facil = new JRadioButton(FACIL);
		facil.setForeground(Color.white);
		dificultades.add(facil);

			
		JRadioButton medio = new JRadioButton(MEDIO);
		medio.setForeground(Color.white);
		dificultades.add(medio);

	
		JRadioButton dificil = new JRadioButton(DIFICIL);
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

	public JComboBox getOpcionesTamanio() {
		return opcionesTamanio;
	}

	
	public String getTamanioSelec()
	{
		return opcionesTamanio.getSelectedItem().toString();
	}
	
	public ButtonGroup getDificultades() {
		return dificultades;
	}
	
	public String getDificultadSelec()
	{
        for (Enumeration<AbstractButton> botones = dificultades.getElements(); botones.hasMoreElements();)
        {
            AbstractButton boton = botones.nextElement();

            if (boton.isSelected()) {
                return boton.getText();
            }
        }
       return null;
        
	}
	
}
