package examples.designpatterns.singleton;

public class SingletonSample1 {
	
	//volatile variables write changes directly to the main memory instead of maintaining caching of the same

	private volatile static SingletonSample1 obj = null;

	public SingletonSample1() {

	}

	public static SingletonSample1 getInstance() {
		if (obj == null) {

			synchronized (SingletonSample1.class) {
				obj = new SingletonSample1();
			}
		}

		return obj;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
