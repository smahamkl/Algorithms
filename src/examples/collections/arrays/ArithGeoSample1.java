package examples.collections.arrays;

public class ArithGeoSample1 {

	static String checkGeometric(int[] arr) {
		if (arr.length <= 2) {
			return "-1";
		} else {
			int ratio = (arr[1] / arr[0]);
			int diff = Math.abs(arr[0] - arr[1]);
			int a = 0, g=0, n = 0;

			for (int i = 2; i < arr.length; ++i) {
				if (arr[i - 1] * ratio == arr[i])
					g++;
				else if (arr[i - 1] + diff == arr[i])
					a++;
				else
					n++;

			}
			if(n > 0 || (g > 0 && a > 0))
				return "-1";
			else if(a > 0)
				return "Arithmetic";
			else
				return "Geometric";
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkGeometric(new int[] { 2, 4, 8 }));
		System.out.println(checkGeometric(new int[] { 1, 3, 5, 7, 9 }));
	}

}
