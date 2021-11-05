package examples.multithreading;

public class ThreadSample {

	static class MyThread extends Thread {
		String threadName = "";

		public MyThread(String _tName) {
			this.threadName = _tName;
		}

		@Override
		public void run() {
			System.out.println("Thread running is: " + this.threadName);

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 5; i++) {
			MyThread m = new MyThread("Thread " + i);
			m.start();
		}
	}

}
