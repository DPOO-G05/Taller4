package uniandes.dpoo.taller4.interfaz;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class InterfazJuego extends JFrame
{

	
	private PanelConfiguracion configuracion;
	private PanelTablero tablero;
	private PanelOpciones opciones;
	private PanelPartida partida;
	
	private CoordLightsOut coordinador;
	
	private String jugador; 
	private int jugadas;

	public InterfazJuego()
	{
		//Determinar titulo y tamaño de la ventana
		this.setTitle("Lights Out");
		this.setSize( 1000, 700 );
		//Configuracion de Cerrado
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
		@Override
	    public void windowClosing(WindowEvent e) {
				terminar();
			}
		});	
		
		//Configuración de Ventana
		this.setResizable(false);
	
		//Determinación del Layout
		this.setLayout(new BorderLayout());
		
		
		//Inicialización de Componentes
		this.jugador = "AAA";
		this.configuracion = new PanelConfiguracion(this);
		this.tablero = new PanelTablero(this);
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
		
		//Cargar Top 10
		this.cargarTop10();
		
		//Mostrar Mensaje Bienvenida
		JOptionPane.showMessageDialog(this, "!Bienvenido! Para iniciar, seleccione un tablero y dificultad y de click en \"Nuevo\"");
	}
	
	public void jugar(int fila, int columna)
	{
		this.coordinador.getTablero().jugar(fila, columna);
		this.jugadas  = coordinador.getTablero().darJugadas();
		this.partida.actualizarPuntaje();
		boolean termino = coordinador.getTablero().tableroIluminado();
		
		if (termino)
		{
			int puntaje = coordinador.getTablero().calcularPuntaje();
			boolean esTop = coordinador.getTop10().esTop10(puntaje);
			
			if (esTop)
			{
				coordinador.agregarTop10(this.jugador,puntaje);
			    JOptionPane.showMessageDialog( this, "Felicitaciones! Ha terminado el Juego en el Top 10", "Felicitaciones!", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
			    JOptionPane.showMessageDialog( this, "Felicitaciones! Ha terminado el Juego. Puede iniciar una Nueva Partida", "Felicitaciones!", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}

	}
	
	public void nuevaPartida()
	{
		String dificultad = this.configuracion.getDificultadSelec(); 

		int numD = 0;

		if (dificultad.equals(PanelConfiguracion.FACIL))
		{
			numD = 1;
		}
		else if(dificultad.equals(PanelConfiguracion.MEDIO))
		{
			numD = 5;
		}
		else if(dificultad.equals(PanelConfiguracion.DIFICIL))
		{
			numD = 7;
		}

		int tamanio = Character.getNumericValue(configuracion.getTamanioSelec().charAt(0));
	
		coordinador.nuevoTablero(tamanio);
		
		coordinador.getTablero().desordenar(numD);
		
		tablero.repaint();
		
		this.jugadas= coordinador.getTablero().darJugadas();
		this.partida.actualizarPuntaje();
		this.jugador = "AAA";
		this.partida.actualizarNombre();
	}
	
	public void reiniciarPartida()
	{
		coordinador.getTablero().reiniciar();
		this.jugadas = coordinador.getTablero().darJugadas();
		this.partida.actualizarPuntaje();
		tablero.repaint();
	}

	
	public void cambiarJugador()
	{
		String nombre = JOptionPane.showInputDialog( this , "Introduzca el nombre del Jugador:"
				, "Nuevo Nombre", JOptionPane.QUESTION_MESSAGE );

		this.jugador = nombre;
		this.partida.actualizarNombre();

	}
	

	public void mostrarTop10()
	{
		//Cada elemento retornado viene en el formato
		// "Nombre;Puntaje"
		String[] registros = coordinador.mostrarTop10();
		final DefaultListModel modelo = new DefaultListModel();
			for (int i = 0; i < 10 ; i++)
			{

				String posicion = String.valueOf(i + 1);
				String[] data = registros[i].split(";");
				String nombre = data[0];
				String puntaje = data[1];
				String info = posicion + ".    " + nombre + ": " + puntaje; 
				modelo.addElement(info);
		}

		//Creamos la lista	
		JList lista = new JList(modelo);

		//Creamos el Scroll Pane
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(lista);
		//Creación del Cuadro de Dialogo
		JDialog dialogo = new JDialog();
		dialogo.setLayout(new BorderLayout());
		JPanel titulo = new JPanel();
		titulo.setLayout(new FlowLayout());
		titulo.setBackground(new Color(43,136,224));
		JLabel numero = new JLabel("#");
		JLabel nom = new JLabel("Nombre");
		Font f = new Font("Sans Serif", Font.BOLD,17);
		numero.setFont(f);
		numero.setForeground(Color.WHITE);
		nom.setFont(f);
		nom.setForeground(Color.WHITE);
		titulo.add(numero);
		titulo.add(nom);
		titulo.add(new JLabel("Nombre"));
		dialogo.add(titulo, BorderLayout.NORTH);
		dialogo.add(scroll, BorderLayout.CENTER);
		dialogo.setSize(50,200);
		dialogo.setTitle("Top 10");
		dialogo.setResizable(false);
		dialogo.setVisible(true);

	}
	
	
	public void terminar() {
		coordinador.guardarTop10();
	    this.dispose();
	    System.exit(0);
	}
	
	public void cargarTop10()
	{
		coordinador.cargarTop10();
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

	public String getJugador() {
		return jugador;
	}

	public int getJugadas() {
		return jugadas;
	}
	
}
