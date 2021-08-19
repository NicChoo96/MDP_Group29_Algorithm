package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener{
	
	public static int WIN_WIDTH = 200;
	public static int WIN_HEIGHT = 200;
	public static int current = 0;
	Timer timer;

	Robot robot = new Robot(0, 0, Direction.North);
	
	public static int SCALE = 4;
	
	@Override
	public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH * SCALE, WIN_HEIGHT * SCALE);
    }
		
	public Panel() {
		this.setVisible(true);
		timer = new Timer(100, this);
		timer.start();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		for(int i = 0; i < 5; i++) {
			Tester.blocks[i].draw(g2d);
		}
		robot.draw(g2d);
		g2d.dispose();
	}

	public void update() {
		
		switch(current) {
		case 0:
			if(robot.moveStraight(0, 80)) {
				current++;
			}
			break;
		case 1:
			if(robot.moveStraight(100, 80)) {
				current++;
			}
			break;
		case 2:
			if(robot.moveStraight(70, 60)) {
				current++;
			}
			break;
		case 3:
			if(robot.moveStraight(160, 20)) {
				current++;
			}
			break;
		}									
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		update();
	}
	
}
