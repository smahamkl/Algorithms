package examples.collections.arrays;

public class CircularArraySample1 {

	public boolean circularArrayLoop(int[] nums) {

		int curPos;
		boolean reset = false;
		for (int pos = 0; pos < nums.length; pos++) {

			int totElements = 0;
			int prevPos = pos;
			boolean loopDetected = false;
			// first check forward loop
			if (nums[pos] > 0) {
				curPos = pos;
				reset = false;
				while (!reset && !loopDetected) {
					if (nums[curPos] <= 0) {
						reset = true;
						loopDetected = false;
					} else {
						curPos += nums[curPos];
						curPos = curPos >= nums.length ? curPos % nums.length : curPos;
						totElements = curPos > prevPos ? totElements + 1 : totElements;

						if (curPos == pos || curPos == prevPos)
							loopDetected = true;

						prevPos = curPos;

					}
				}

				if (totElements > 0) {
					if (loopDetected) {
						System.out.println("loop detected");
						return true;
					}
				}

			}

		}

		for (int pos = nums.length - 1; pos >= 0; pos--) {

			int totElements = 0;
			int prevPos = pos;
			boolean loopDetected = false;
			// check reverse loop
			if (nums[pos] < 0) {
				curPos = pos;
				reset = false;
				while (!reset && !loopDetected) {
					if (nums[curPos] >= 0) {
						reset = true;
						loopDetected = false;
					} else {
						curPos += (nums[curPos]);						
						curPos = curPos < 0 ? (nums.length + curPos % nums.length) : curPos;
						totElements = curPos < prevPos ? totElements + 1 : totElements;
						if (curPos == pos || curPos == prevPos)
							loopDetected = true;

						prevPos = curPos;
					}
				}

				if (totElements > 0) {
					if (loopDetected) {
						System.out.println("loop detected");
						return true;
					}
				}
			}
		}

		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = new int[] { -1, 0, -2 };

		a = new int[] { 1, 2, 3, 4, 5 };
		 a = new int[] { -1, 2 };
		 a = new int[] { -1, -2, -3, -4, -5 };
		a = new int[] { -2, 1, -1, -2, -2 };

		CircularArraySample1 c = new CircularArraySample1();

		System.out.println(c.circularArrayLoop(a));

	}

}
