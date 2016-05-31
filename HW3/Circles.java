// Shawn Stern, CSE 142, Section BG, October 13 2010
//
// This program generates images of concentric circles; both
// individually and arranged into "grids".  Parameters up in this!

import java.awt.*;

public class Circles {
	public static void main(String[] args) {
		// Basic setup
		DrawingPanel panel = new DrawingPanel(500, 350);
		panel.setBackground(Color.CYAN);
		Graphics g = panel.getGraphics();

		// (g, x, y, diameter, # of subcircles)
		drawCircle(g, 0, 0, 100, 10);
		drawCircle(g, 130, 25, 100, 10);
		drawCircle(g, 260, 0, 60, 6);
		drawCircle(g, 360, 50, 80, 4);
		// (g, x,  y, #rows/cols, diam of subfigures, # of subcircles)
		drawGrid(g, 10, 170, 3, 48, 4);
		drawGrid(g, 180, 200, 5, 24, 2);
		drawGrid(g, 330, 170, 2, 72, 9);
	}
	
	// Draws a bordered yellow circle and concentric black circles inside it, dependent 
	// on its xy-coordinates, diameter, and the number of specified subcircles
	public static void drawCircle(Graphics g, int x, int y, int diam, int subs) {
		// I had to declare this variable in order to keep the for loop under 100 chars!
		int gap = diam / subs;
		
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, diam, diam);
		g.setColor(Color.BLACK);
		
		for (int i = 0; i < subs; i++) {
			g.drawOval(x + i * (gap / 2), y + i * (gap / 2), diam - i * gap, diam - i * gap);
		}
	}
	
	// Draws a square grid of identical subfigure circles, contained within a green
	// rectangle, a black border, and crossed by black lines which connect the corners.
	public static void drawGrid(Graphics g, int x, int y, int rows, int diam, int subs) {
		int gridSize = diam * rows;
		
		g.setColor(Color.GREEN);		
		g.fillRect(x, y, gridSize, gridSize);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				drawCircle(g, x + j * diam, y + i * diam, diam, subs);
			}
		}
		
		g.drawRect(x, y, gridSize, gridSize);
		g.drawLine(x, y, x + gridSize, y + gridSize);
		g.drawLine(x + gridSize, y, x, y + gridSize);
	}
}