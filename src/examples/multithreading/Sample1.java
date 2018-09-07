package examples.multithreading;

public class Sample1 {

	private static String[] names = new String[6];
	private static int index = 0;
	
	public static void main(String[] args) throws InterruptedException {

	    Thread thread1 = new Thread() {
	        public void run() {
	            names[index++] = "Daniel";
	            names[index++] = "Chris";
	            names[index++] = "Joseph";
	        }
	    };
	 
	    Thread thread2 = new Thread() {
	        public void run() {
	            names[index++] = "Renee";
	            names[index++] = "Bethany";
	            names[index++] = "Grace";
	        }
	    };
	 
	    thread1.start();
	    thread2.start();
	 
	    thread1.join();
	    thread2.join();
	 
	    for (String name : names) {
	        System.out.println(name);
	    }
	}

}
