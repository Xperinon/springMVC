package game.models;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -121410771083794690L;
	public static final int HEIGHT = 720;
	public static final int WIDTH = 720;
	private boolean running =false;
	private BufferedImage image;
	private int[] pixels;
	
	public Main() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = new int[WIDTH * HEIGHT];
	}
	
	public static void main(String[] args) {
		Dimension dimension = new Dimension (WIDTH, HEIGHT);
		
		Main main = new Main();
		main.setMinimumSize(dimension);
		main.setMaximumSize(dimension);
		main.setPreferredSize(dimension);
		
		JFrame frame = new JFrame();
		
		frame.setResizable(false);
		frame.add(main);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		main.start();
	}

	@Override
	public void run() {
		long before = System.nanoTime();
		long now =0;
		double elapsed = 0.0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		double ticks = 100000000.0/60.0;
		while (running) {
			now = System.nanoTime();
			elapsed = now - before;
			while (elapsed > ticks) {
				update();
				ticks++;
				before += ticks;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer >1000) {
				timer += 1000;
				ticks = 0;
				frames =0;
			}
		}
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		image.getRGB(0,0, WIDTH, HEIGHT, pixels, 0, WIDTH);
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
		g.dispose();
		bs.show();
		
	}
	public void update() {
		
	}
	public void start() {
		running = true;
		new Thread(this, "Main Thread").start();
	}

}
