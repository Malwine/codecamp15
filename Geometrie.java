package codeCampPZ1;

import java.awt.*;
import javax.swing.*;

public class Geometrie extends JFrame {
	
	Canvas canvas;
	
	private Geometrie() {
		super("Objekte zeichnen");
		
		canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		this.add(canvas);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setVisible(true);
	}
	
	class Canvas extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
		}
	}

	public static void main(String[] args) {
		new Geometrie();
	}

}
