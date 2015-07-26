package codeCampPZ1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.*;

public class Geometrie extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
	
	Canvas canvas;
	JPanel southPanel;
	Point startPoint, endPoint;
	LinkedList<Line> linien;
	HashMap<LinkedList, Color> linienZuege;
	Random r = new Random();
	
	private Geometrie() {
		super("Objekte zeichnen");
		
		canvas = new Canvas();
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
		this.add(canvas);
		
		linien = new LinkedList<>();
		linienZuege = new HashMap<>();
		
		southPanel = initSouthPanel();
		this.add(southPanel, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setVisible(true);
	}
	
	class Canvas<E> extends JPanel {
		
		Canvas() {
			this.setBackground(Color.WHITE);
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			if (startPoint != null && endPoint != null){
				//g2.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
				
				if (linien.size() != 0){
					for( Line line : linien){
						g2.drawLine(line.x1, line.y1, line.x2, line.y2);
						System.out.println("StartPoint: " + line.startPoint.toString());
						System.out.println("EndPoint: " + line.endPoint.toString());
					}
				}System.out.println("------------------------------");
			}
			
			if (linienZuege.size() != 0){
				for(Entry<LinkedList, Color> entry : linienZuege.entrySet()){
				    LinkedList<Line> list = entry.getKey();
				    Color c = entry.getValue();
				   
				    for (Line item : list){
				    	g2.drawLine(item.x1, item.y1, item.x2, item.y2);
				    	g2.setColor(c);
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
		
		if (e.getClickCount() == 2 && !e.isConsumed()) {
			 e.consume();
		     linien.add(new Line(endPoint, linien.getFirst().startPoint));
		     linienZuege.put(linien, new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		     linien.clear();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {
		endPoint = e.getPoint();
		if (startPoint != null && endPoint != null){
			linien.add(new Line(startPoint, endPoint));
			canvas.repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {
		//endPoint = e.getPoint();
		
		/*if (startPoint != null && endPoint != null){
			linien.add(new Line(startPoint, endPoint));
			canvas.repaint();
		}*/
	}

}
