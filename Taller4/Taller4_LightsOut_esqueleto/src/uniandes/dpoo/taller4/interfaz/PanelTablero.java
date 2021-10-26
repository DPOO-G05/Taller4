package uniandes.dpoo.taller4.interfaz;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class PanelTablero extends JPanel {
	
	
	private int anchoFicha;
	
	private int altoFicha;
	
	private int dimension;
	
	private final GradientPaint INACTIVO = new GradientPaint(50, 50, Color.BLACK,
            300, 100, Color.LIGHT_GRAY);
	private final GradientPaint ACTIVO = new GradientPaint(50, 50, Color.YELLOW,
            300, 100, Color.WHITE);
	public PanelTablero(int dimension)
	{
		//this.setLayout(new GridLayout());
		this.dimension = dimension;
	}
    public void paint( Graphics pGrafica )
    {
    	Graphics2D g2d = (Graphics2D) pGrafica;
    	
    	// Dibujar cada una de las fichas
        super.paint( pGrafica );
        int delta = 10;
        anchoFicha = (getWidth() - dimension * delta)/this.dimension;
        altoFicha = (getHeight()- dimension * delta)/this.dimension;
       
        for (int i = 0; i < dimension; i++)
        	for (int j  = 0; j < dimension; j++)
        	{
        		int xCoor = (i + 1)*(delta) + i*anchoFicha;
        		int yCoor = (j + 1)*delta + j*altoFicha;
        		g2d.setPaint(new GradientPaint(xCoor,yCoor ,Color.BLACK,xCoor + anchoFicha,yCoor + altoFicha,Color.GRAY));
        		g2d.drawRoundRect(xCoor ,yCoor,anchoFicha,altoFicha, 10, 10);
        		g2d.fillRoundRect((i + 1)*(delta) + i*anchoFicha,(j + 1)*delta + j*altoFicha ,anchoFicha,altoFicha, 10, 10);
        	}
         
//        // Elementos graficos Java2D
//        g2d.setColor(Color.RED);
//        // Linea del borde izquierdo superior del panel (0, 0) al borde derecho inferior del panel (anchoP, altoP)
//    	g2d.drawLine(0, 0, anchoP, altoP);
//        g2d.setColor(Color.YELLOW);
//        // Linea del borde izquierdo inferior del panel (0, altoP) al borde derecho superior del panel (anchoP, 0)
//    	g2d.drawLine(0, altoP, anchoP, 0);
//    	
//    	g2d.setColor(Color.GREEN);
//    	int centroX = anchoP/2;
//    	int centroY = altoP/2;
//    	
//    	// Circulo grande centrado
//    	g2d.drawOval(centroX - 160, centroY - 160, 320, 320);
//
//    	if ( estadoBoton )
//    	{
//    		botonX = centroX - 160;
//    		botonY = centroY - 80;
//    		colorBoton = Color.BLUE;    
//    	}
//    	else
//    	{
//    		botonX = centroX;
//    		botonY = centroY - 80;    		
//    		colorBoton = Color.CYAN;
//    	}
//    	// Pintar "Boton" a la Izquierda o Derecha del "centro" en Java2D
//    	g2d.setColor(colorBoton);
//    	g2d.fillOval(botonX, botonY, 160, 160);
    }

     
    public void setDimension(int dimension)
    {
    	   this.dimension = dimension;
    	   repaint();
    }
//      

}
