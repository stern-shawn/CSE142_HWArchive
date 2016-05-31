// Shawn Stern, CSE 142, Section BG, October 13 2010
//
// This program generates blandness

import java.awt.*;

public class Doodle {
	public static void main(String[] args) {
		// Basic setup
		DrawingPanel panel = new DrawingPanel(561, 235);
		Graphics g = panel.getGraphics();

		g.setColor(Color.GREEN);
		g.fillOval(0, 0, 560, 200);
		g.setColor(Color.BLACK);
		g.drawOval(0, 0, 560, 200);
		g.drawRect(180, 50, 200, 25);
		g.drawString("OMFG", 260, 70);
		g.drawLine(1, 220, 560, 220);
		
		drawSeriesDown(g, 1, 20, 10, 20);
		drawSeriesUp(g, 200, 200, 4, 20);
		drawSeriesDown(g, 280, 140, 4, 20);
		drawSeriesUp(g, 360, 200, 10, 20);
	}
	
	// Draws a sequence of squares diagonally "down"
	public static void drawSeriesDown(Graphics g, int x, int y, int numb, int dim) {		
		g.setColor(Color.BLUE);

		for (int i = 0; i < numb; i++) {
			g.fillRect(x + i * dim, y + i * dim, dim, dim);
		}
	}

	// Draws a sequence of squares diagonally "up"
	public static void drawSeriesUp(Graphics g, int x, int y, int numb, int dim) {		
		g.setColor(Color.PINK);

		for (int i = 0; i < numb; i++) {
			g.fillRect(x + i * dim, y - i * dim, dim, dim);
		}
	}
}