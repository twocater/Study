package com.cpaladin.util;

public class Main {
	public static void main(String[] args) {
		StuffIntoPublic stuffIntoPublic = new StuffIntoPublic();
		stuffIntoPublic.initialize();

		new Thread(new Task(stuffIntoPublic.holder)).start();

		try {
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Task implements Runnable {
	private Holder holder;

	public Task(Holder holder) {
		this.holder = holder;
	}

	@Override
	public void run() {
		holder.assertSanity();
		System.out.println("run task");

	}

}
