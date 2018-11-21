package examples.collections.arrays;

/*
 * Have the function PairSearching(num) take the num parameter being passed and perform the following steps. 
 * First take all the single digits of the input number (which will always be a positive integer greater than 1) and add each of them into a list. 
 * Then take the input number and multiply it by any one of its own integers, then take this new number and append each of the digits onto the original list. 
 * Continue this process until an adjacent pair of the same number appears in the list. Your program should return the least number of multiplications it 
 * took to find an adjacent pair of duplicate numbers. 

For example: if num is 134 then first append each of the integers into a list: [1, 3, 4]. Now if we take 134 and multiply it by 3 (which is one of its own integers), 
we get 402. Now if we append each of these new integers to the list, we get: [1, 3, 4, 4, 0, 2]. We found an adjacent pair of duplicate numbers, namely 4 and 4. 
So for this input your program should return 1 because it only took 1 multiplication to find this pair. 

Another example: if num is 46 then we append these integers onto a list: [4, 6]. If we multiply 46 by 6, we get 276, and appending these integers onto the list 
we now have: [4, 6, 2, 7, 6]. Then if we take this new number, 276, and multiply it by 2 we get 552. Appending these integers onto the list we get: [4, 6, 2, 7, 6, 5, 5, 2]. 
Your program should therefore return 2 because it took 2 multiplications to find a pair of adjacent duplicate numbers (5 and 5 in this case). 

 */
public class PairSearchSample1 {

	//static int[] ALL_NUM = new int[10];

	static int finalIter = Integer.MAX_VALUE;
	static int totIterations(String num, int totIter, int prevNbr, int[] all_num) {

		int[] tmp_num = all_num.clone();
		for (int i = 0; i < num.length(); i++) {
			int curNum = num.charAt(i) - '0';
			tmp_num[curNum]++;

			if (prevNbr != -1 && prevNbr == curNum)
				return totIter;
			prevNbr = curNum;
		}

		System.out.println(num + "   " + prevNbr);

		for (int i = 2; i < 10; i++) {
			if (tmp_num[i] > 0) {
	
				int productFirstDigit = String.valueOf(i * Integer.parseInt(num)).charAt(0) - '0';
				if (productFirstDigit == prevNbr)
					return totIterations(String.valueOf(i * Integer.parseInt(num)), totIter + 1, prevNbr, tmp_num);
				else if (!hasDistinctDigits(i * Integer.parseInt(num)))
					return totIterations(String.valueOf(i * Integer.parseInt(num)), totIter + 1, prevNbr, tmp_num);

			}
		}
		
		for (int i = 2; i < 10; i++) {
			if (tmp_num[i] > 0) {
				finalIter = Math.min(finalIter, totIterations(String.valueOf(i * Integer.parseInt(num)), totIter + 1, prevNbr, tmp_num));
			}
		}
		
		return finalIter;

	}

	static boolean hasDistinctDigits(int number) {
		int numMask = 0;
		int numDigits = (int) Math.ceil(Math.log10(number + 1));
		for (int digitIdx = 0; digitIdx < numDigits; digitIdx++) {
			int curDigit = (int) (number / Math.pow(10, digitIdx)) % 10;
			int digitMask = (int) Math.pow(2, curDigit);
			if ((numMask & digitMask) > 0)
				return false;
			numMask = numMask | digitMask;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String num = "198";
		//num = "134";
		//num = "46";
		//num = "8";
		num = "2";

		System.out.println(totIterations(num, 0, -1, new int[10]));

	}

}
