package codeCampPZ1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Geometrie extends JFrame implements ActionListener, MouseListener {
	
	Canvas canvas;
	JPanel southPanel;
	JButton exit;
	JToggleButton quadrate;
	JToggleButton linien;
	ButtonGroup buttonGroup;
	boolean clickedLeft;
	boolean clickedRight;
	
	private Geometrie() {
		super("Objekte zeichnen");
		
		canvas = new Canvas();
		canvas.addMouseListener(this);
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
			
			g2.setColor(Color.RED);
			
			int width = this.getWidth();
			int height = this.getHeight();
			
			if(quadrate.isSelected()){
				g2.drawLine(0, 0, width/2, height);
				g2.drawLine(0, height, width/2, 0);
				g2.drawLine(width/2, 0, width, height);
				g2.drawLine(width/2, height, width, 0);
			}
			
			if(clickedLeft) {
				g2.drawRect(width/8, height/4, width/4, height/2);
				g2.fillRect(width/8, height/4, width/4, height/2);
			}
			else if(clickedRight) {
				g2.drawRect(width/8*5, height/4, width/4, height/2);
				g2.fillRect(width/8*5, height/4, width/4, height/2);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getX() < canvas.getWidth()/2){
			clickedLeft = true;
			clickedRight = false;
			canvas.repaint();
		}
		else {
			clickedLeft = false;
			clickedRight = true;
			canvas.repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
