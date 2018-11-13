package com.dzoum.sdc.core;

import com.dzoum.sdc.core.config.Config;
import com.dzoum.sdc.utils.Output;
import com.dzoum.sdc.utils.TickCounter;

/**
 * Same processing, without rendering.
 * @see Core
 */
public class LightCore implements Runnable {

	// configuration
	private Config config;

	// game thread
	private Thread thread;
	private boolean running;

	// world
	private World world;

	public LightCore(Config config) {
		this.config = config;
		this.running = false;
		this.world = new World(this.config);
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double unprocessed = 0;
		double nsPerTick = 1000000000.0 / 60;
		@SuppressWarnings("unused")
		int frames = 0;

		@SuppressWarnings("unused")
		int ticks = 0;
		long lastTimer1 = System.currentTimeMillis();
		
		while (running) {
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;

			long start = System.currentTimeMillis();
			
			while (unprocessed >= 1) {
				ticks++;
				update();
				unprocessed -= 1;
				shouldRender = true;
			}
			
			start = System.currentTimeMillis() - start;

			if (shouldRender) {
				frames++;
			}

			if (System.currentTimeMillis() - lastTimer1 > 1000) {
				Output.logn(config.getCollisionsCount() + ";" + start);
				
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

	public void start() {
		if (running) {
			return;
		}

		thread = new Thread(this);
		running = true;
		thread.start();
	}

	public void stop() {
		if (!running) {
			return;
		}

		running = false;
	}

}