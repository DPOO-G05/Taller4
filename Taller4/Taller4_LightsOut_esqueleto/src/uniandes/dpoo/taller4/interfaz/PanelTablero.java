package uniandes.dpoo.taller4.interfaz;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

public class PanelTablero extends JPanel implements MouseListener {
	
	
	private int anchoFicha;
	
	private int altoFicha;
	
	private int dimension;
	
	private InterfazJuego principal;
	
	private final GradientPaint INACTIVO = new GradientPaint(50, 50, Color.BLACK,
            300, 100, Color.LIGHT_GRAY);
	private final GradientPaint ACTIVO = new GradientPaint(50, 50, Color.YELLOW,
            300, 100, Color.WHITE);
	
	
	public PanelTablero(InterfazJuego principal, int dimension)
	{
		//Asignar principal
		this.principal = principal;

		this.addMouseListener(this);
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

        boolean[][] tablero = this.principal.getCoordinador().getTablero().darTablero();   
        
        Color[] colores = {Color.YELLOW,Color.WHITE, Color.BLACK,Color.LIGHT_GRAY};

        for (int i = 0; i < dimension; i++)
        	for (int j  = 0; j < dimension; j++)
        	{
        		int xCoor = (i + 1)*(delta) + i*anchoFicha;
        		int yCoor = (j + 1)*delta + j*altoFicha;

        		boolean oscuro = tablero[i][j];
        		if (oscuro)
        		{
        			g2d.setPaint(new GradientPaint(xCoor,yCoor ,colores[0],xCoor + anchoFicha,yCoor + altoFicha,colores[1]));
        		}
        		else
        		{
        			
        			g2d.setPaint(new GradientPaint(xCoor,yCoor ,colores[2],xCoor + anchoFicha,yCoor + altoFicha,colores[3]));
        		}

        		g2d.drawRoundRect(xCoor ,yCoor,anchoFicha,altoFicha, 10, 10);
        		g2d.fillRoundRect((i + 1)*(delta) + i*anchoFicha,(j + 1)*delta + j*altoFicha ,anchoFicha,altoFicha, 10, 10);
        	}
   }

     
    public void setDimension(int dimension)
    {
    	   this.dimension = dimension;
    	   repaint();
    }

    public int getDimension()
    {
    	return this.dimension;
    }
    
    public void mousePressed(MouseEvent e)
    {
    	int click_x = e.getX();
    	int click_y = e.getY();
    	int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
    	//cantidades[casilla[0]][casilla[1]]++;
    	principal.jugar(casilla[0], casilla[1]);
    	//this.ultima_fila = casilla[0];
    	//this.ultima_columna = casilla[1];
    	repaint();
    	System.out.printf("Fila: %d, Columna: %d\n", casilla[0],casilla[1]);
    }
    private int[] convertirCoordenadasACasilla(int x, int y)
    {
    	int ladoTablero = this.dimension;
    	int altoPanelTablero = getHeight();
    	int anchoPanelTablero = getWidth();
    	int altoCasilla = altoPanelTablero / ladoTablero;
    	int anchoCasilla = anchoPanelTablero / ladoTablero;
    	int fila = (int) (y / altoCasilla);
    	int columna = (int) (x / anchoCasilla);
    	return new int[] { fila, columna };
    }
    
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
