package com.somerton.fairylights.controller;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.somerton.fairylights.Algorithms;
import com.somerton.fairylights.model.DefaultChain;
import com.somerton.fairylights.view.FairyLightDisplay;

public class FairyLightsControllerTest {

	@Test
	public void testFairyLightsControllerSequence() throws Exception {

		final DefaultChain chain = spy(DefaultChain.class);
		final FairyLightDisplay display = spy(FairyLightDisplay.class);

		Runnable r = new Runnable() {
			public void run() {
				try {
					FairyLightsController controller = new FairyLightsController(chain, display, Algorithms.SEQUENCE);

					controller.go();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		Thread thread = new Thread(r);
		thread.start();
		Thread.sleep(5000);
		thread.stop();

		verify(display, times(10)).display(chain);

	}

	@Test
	public void testFairyLightsControllerColour() throws Exception {

		final DefaultChain chain = spy(DefaultChain.class);
		final FairyLightDisplay display = spy(FairyLightDisplay.class);

		Runnable r = new Runnable() {
			public void run() {
				try {
					FairyLightsController controller = new FairyLightsController(chain, display, Algorithms.COLOUR);

					controller.go();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		Thread thread = new Thread(r);
		thread.start();
		Thread.sleep(5000);
		thread.stop();

		verify(display, times(5)).display(chain);

	}
	
	@Test
	public void testFairyLightsControllerAlternate() throws Exception {

		final DefaultChain chain = spy(DefaultChain.class);
		final FairyLightDisplay display = spy(FairyLightDisplay.class);

		Runnable r = new Runnable() {
			public void run() {
				try {
					FairyLightsController controller = new FairyLightsController(chain, display, Algorithms.ALTERNATE);

					controller.go();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		Thread thread = new Thread(r);
		thread.start();
		Thread.sleep(90000);
		thread.stop();

		verify(display, atLeast(130)).display(chain);

	}
}
