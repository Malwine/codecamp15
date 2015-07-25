package codeCampPZ1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Geometrie extends JFrame implements ActionListener {
	
	Canvas canvas;
	JPanel southPanel;
	JButton exit;
	JToggleButton quadrate;
	JToggleButton linien;
	ButtonGroup buttonGroup;
	
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
			
			if(quadrate.isSelected()){
				int width = this.getWidth();
				int height = this.getHeight();
				
				g2.drawLine(0, 0, width/2, height);
				g2.drawLine(0, height, width/2, 0);
				g2.drawLine(width/2, 0, width, height);
				g2.drawLine(width/2, height, width, 0);
			}
		}
	}
	
	JPanel initSouthPanel() {
		JPanel panel = new JPanel();		
		exit = new JButton("Exit");
		exit.addActionListener(this);
		
		quadrate = new JToggleButton("Quadrate");
		linien = new JToggleButton("Linien");
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(quadrate);
		buttonGroup.add(linien);
		
		quadrate.setSelected(true);
		
		panel.add(quadrate);
		panel.add(linien);
		
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
		case "Quadrate" :
			canvas.repaint();
		}
		
	}

}
