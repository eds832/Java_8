package com.epam.cdp;

public class Main {

	public static void main(String[] args) {
		// BusinessTaskUpdateCustomerAgeOnThread task1 = new
		// BusinessTaskUpdateCustomerAgeOnThread();
		// BusinessTaskUpdateCustomerAgeOnThread task2 = new
		// BusinessTaskUpdateCustomerAgeOnThread();
		//
		// task1.start();
		// task2.start();
		// task2.updateStateInDB();
		// task2.run();
		Runnable task1 = () -> {
			((BusinessTask) () -> {}).updateStateInDBByDefault();
			new BusinessTaskUpdateCustomerAge().updateStateInDB();
			try {
				Thread.sleep(1000);
				System.out.println("Massive updates are gonna be");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		// Runnable task1 = new Runnable() {
		//
		// @Override
		// public void run() {
		// new BusinessTaskUpdateCustomerAge().updateStateInDB();
		// try {
		// Thread.sleep(1000);
		// System.out.println("Massive updates are gonna be");
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		// };
		executeTask(task1);
		executeTask(task1);
	}

	private static void executeTask(Runnable threadLogic) {
		new Thread(threadLogic).start();
	}
}
