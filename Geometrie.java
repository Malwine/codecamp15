package codeCampPZ1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import javax.swing.*;

public class Geometrie extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
	
	Canvas canvas;
	JPanel southPanel;
	Point startPoint, endPoint;
	LinkedList<Line> linien;
	
	private Geometrie() {
		super("Objekte zeichnen");
		
		canvas = new Canvas();
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
		this.add(canvas);
		
		linien = new LinkedList<>();
		
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
			
			if (startPoint != null && endPoint != null){
				System.out.println("Linie zeichnen");
				g2.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
				
				if (linien.size() != 0){
					for( Line line : linien){
						g2.drawLine(line.x1, line.y1, line.x2, line.y2);
					}
				}
			}
		}
	}
	
	JPanel initSouthPanel() {
		JPanel panel = new JPanel();		
		JButton exit = new JButton("Exit");
		exit.addActionListener(this);
		
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

	@Override
	public void mouseClicked(MouseEvent e) {
		startPoint = e.getPoint();
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		endPoint = e.getPoint();
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		endPoint = e.getPoint();
		
		linien.add(new Line(startPoint, endPoint));
		canvas.repaint();
	}

}
