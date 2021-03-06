package com.dzoum.sdc.core;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.dzoum.sdc.core.config.Config;
import com.dzoum.sdc.graphics.Screen;
import com.dzoum.sdc.graphics.Window;
import com.dzoum.sdc.utils.Output;
import com.dzoum.sdc.utils.TickCounter;

/**
 * Main game loop.
 * Uses a thread object. 
 */
public class Core extends JPanel implements Runnable {

	private static final long serialVersionUID = -5524815598464412250L;

	// configuration
	private Config config;
	private Color screenColor;

	// game thread
	private Thread thread;
	private boolean running;

	// graphics
	private Window window;
	private Screen screen;
	
	// world
	private World world;

	public Core(Config config) {
		this.config = config;
		this.running = false;
		this.window = new Window(this, this.config);
		this.screen = new Screen(this, this.config);
		this.world = new World(this.config);
		this.screenColor = config.getScreenColor();
		this.initWindow();
	}

	private void initWindow() {
		setPreferredSize(new Dimension(config.getAppWidth() * config.getAppScale(),
				config.getAppHeight() * config.getAppScale()));
		setFocusable(true);
		requestFocus();
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double unprocessed = 0;
		double nsPerTick = 1000000000.0 / 60;
		int frames = 0;

		@SuppressWarnings("unused")
		int ticks = 0;
		long lastTimer1 = System.currentTimeMillis();
		
		while (running) {
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;

			// 60 updates / second
			while (unprocessed >= 1) {
				ticks++;
				update();
				unprocessed -= 1;
				shouldRender = true;
			}

			if (shouldRender) {
				frames++;
				render();
			}

			if (System.currentTimeMillis() - lastTimer1 > 1000) {
				window.setTitle(config.getSegmentsCount() + " segments | " + frames + " fps");
				
				Output.logn(config.getCollisionsCount() + ";" + frames);
				if(TickCounter.minutePassed()) {
					Output.averageToConsole();
				}
				
				lastTimer1 += 1000;
				frames = 0;
				ticks = 0;
			}
		}
	}

	public void update() {
		world.update();
		TickCounter.update();
	}

	public void render() {
		screen.colorize(screenColor);
		world.render(screen);
		screen.render();
	}

	public void start() {
		if (running) {
			return;
		}

		running = true;
		window.start();
	}

	public void stop() {
		if (!running) {
			return;
		}

		window = null;
		running = false;
	}

	@Override
	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			// addKeyListener(this);
			thread.start();
		}
	}

}