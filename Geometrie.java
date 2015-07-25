package codeCampPZ1;

import javax.swing.JFrame;

public class Geometrie extends JFrame {
	
	Geometrie() {
		super("Objekte zeichnen");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Geometrie();
	}

}
