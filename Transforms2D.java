package lab1a;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Transforms2D extends JPanel {

	private class Display extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.translate(300,300);  // Moves (0,0) to the center of the display.
			int whichTransform = transformSelect.getSelectedIndex();

			
			
			switch (whichTransform) {
			case 1: {
				int[] xPoints = {-130, -130, -20,  40 ,  110,170,  130,  60, -50,  -120, -200, -240};
				int[] yPoints = {90,     120,  135, 150,  90,0,  -90,  -150,-150, -150, -105, 0};
				g2.setPaint(Color.black);
				g2.scale(0.5, 0.5);
				g2.fillPolygon(xPoints, yPoints, 12);
			} break;
			
			case 2: {
				int[] xPoints = {-130, -130, -20,  40 ,  110,170,  130,  60, -50,  -120, -200, -240};
				int[] yPoints = {90,     120,  135, 150,  90,0,  -90,  -150,-150, -150, -105, 0};
				g2.setPaint(Color.black);
				g2.rotate(0.5);
				g2.fillPolygon(xPoints, yPoints, 12);
			}break;
			
			case 3: {
				int[] xPoints = {-130, -130, -20,  40 ,  110,170,  130,  60, -50,  -120, -200, -240};
				int[] yPoints = {90,     120,  135, 150,  90,0,  -90,  -150,-150, -150, -105, 0};
				g2.setPaint(Color.black);
				g2.scale(0.5,  0.8);
				g2.rotate(Math.toRadians(180));
				g2.fillPolygon(xPoints, yPoints, 12);
			}break;
			
			case 4: {
				int[] xPoints = {-130, -130, -20,  40 ,  110,170,  130,  60, -50,  -120, -200, -240};
				int[] yPoints = {90,     120,  135, 150,  90,0,  -90,  -150,-150, -150, -105, 0};
				g2.setPaint(Color.black);
				g2.shear(0.40,0);
				g2.fillPolygon(xPoints, yPoints, 12);
			}break;
			
			case 5: {
				int[] xPoints = {-130, -130, -20,  40 ,  110,170,  130,  60, -50,  -120, -200, -240};
				int[] yPoints = {90,     120,  135, 150,  90,0,  -90,  -150,-150, -150, -105, 0};
				g2.setPaint(Color.black);
				g2.scale(1,0.5);
				g2.translate(0,-450);
				g2.fillPolygon(xPoints, yPoints, 12);
			}break;
			
			case 6: {
				int[] xPoints = {-130, -130, -20,  40 ,  110,170,  130,  60, -50,  -120, -200, -240};
				int[] yPoints = {90,     120,  135, 150,  90,0,  -90,  -150,-150, -150, -105, 0};
				g2.setPaint(Color.black);
				g2.shear(0, -0.5);
				g2.rotate(Math.PI/2);
				g2.fillPolygon(xPoints, yPoints, 12);
			}break;
			
			case 7: {
				int[] xPoints = {-130, -130, -20,  40 ,  110,170,  130,  60, -50,  -120, -200, -240};
				int[] yPoints = {90,     120,  135, 150,  90,0,  -90,  -150,-150, -150, -105, 0};
				g2.setPaint(Color.black);
				g2.scale(0.5,1);
				g2.rotate(Math.PI);
				g2.fillPolygon(xPoints, yPoints, 12);
			}break;
			
			case 8: {
				int[] xPoints = {-130, -130, -20,  40 ,  110,170,  130,  60, -50,  -120, -200, -240};
				int[] yPoints = {90,     120,  135, 150,  90,0,  -90,  -150,-150, -150, -105, 0};
				g2.setPaint(Color.black);
				g2.rotate(Math.toRadians(40));
				g2.scale(1,0.4);
				g2.translate(50,450);
				g2.fillPolygon(xPoints, yPoints, 12);
			}break;
			
			case 9: {
				int[] xPoints = {-130, -130, -20,  40 ,  110,170,  130,  60, -50,  -120, -200, -240};
				int[] yPoints = {90,     120,  135, 150,  90,0,  -90,  -150,-150, -150, -105, 0};
				g2.setPaint(Color.black);
				g2.translate(30,100);
				g2.shear(0,0.40);
				g2.rotate(Math.PI);
				g2.fillPolygon(xPoints, yPoints, 12);
			}break;
			
			default: {
				int[] xPoints = {-130, -130, -20,  40 ,  110,170,  130,  60, -50,  -120, -200, -240};
				int[] yPoints = {90,     120,  135, 150,  90,0,  -90,  -150,-150, -150, -105, 0};
				g2.setPaint(Color.black);
				g2.fillPolygon(xPoints, yPoints, 12);
			
				
			}break;
			}
		
		}
	}

	private Display display;
	//private BufferedImage pic;
	private JComboBox<String> transformSelect;

	public Transforms2D() throws IOException {
		//pic = ImageIO.read(getClass().getClassLoader().getResource("shuttle.jpg"));
		
		display = new Display();
		display.setBackground(Color.YELLOW);
		display.setPreferredSize(new Dimension(600,600));
		transformSelect = new JComboBox<String>();
		transformSelect.addItem("None");
		for (int i = 1; i < 10; i++) {
			transformSelect.addItem("No. " + i);
		}
		transformSelect.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.repaint();
			}
		});
		setLayout(new BorderLayout(3,3));
		setBackground(Color.GRAY);
		setBorder(BorderFactory.createLineBorder(Color.GRAY,10));
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.CENTER));
		top.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		top.add(new JLabel("Transform: "));
		top.add(transformSelect);
		add(display,BorderLayout.CENTER);
		add(top,BorderLayout.NORTH);
	}


	public static void main(String[] args) throws IOException {
		JFrame window = new JFrame("2D Transforms");
		window.setContentPane(new Transforms2D());
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
		window.setVisible(true);
	}

}