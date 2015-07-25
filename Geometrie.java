package codeCampPZ1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Geometrie extends JFrame implements ActionListener {
	
	Canvas canvas;
	JPanel southPanel;
	
	private Geometrie() {
		super("Objekte zeichnen");
		
		canvas = new Canvas();
		this.add(canvas);
		
		southPanel = initSouthPanel();
		this.add(southPanel, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setVisible(true);
	}
	
	class Canvas extends JPanel {
		
		Canvas() {
			this.setBackground(Color.WHITE);
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
		}
	}
	
	JPanel initSouthPanel() {
		JPanel panel = new JPanel();		
		JButton exit = new JButton("Exit");
		exit.addActionListener(this);

		/*// funktioniert auch:
		 * exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(Geometrie.this, "Wollen Sie wirklich beenden?", "Exit", JOptionPane.OK_CANCEL_OPTION);
				if(confirm == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});*/
		
		panel.add(exit);
		return panel;
	}

	public static void main(String[] args) {
		new Geometrie();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String name = e.getActionCommand();
		
		switch(name) {
		case "Exit" :
			int n = JOptionPane.showConfirmDialog(this, "Wollen Sie wirklich beenden?", "Exit", JOptionPane.OK_CANCEL_OPTION);
			
			if(n == JOptionPane.OK_OPTION) {
				this.setVisible(false);
				this.dispose();
				System.exit(0);
			}
			break;
		}
		
	}

}
