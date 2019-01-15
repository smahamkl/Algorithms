package examples.practice;

import java.util.LinkedList;

public class MaxMinimizeExpression {

	static boolean isOperator(char c) {
		if (c == '*' || c == '+')
			return true;
		else
			return false;
	}

	static void printMinAndMaxValueOfExp(String exp) {
		LinkedList<Integer> num = new LinkedList<>();
		LinkedList<Character> opr = new LinkedList<>();
		String tmp = "";

		// store operator and numbers in different vectors
		for (int i = 0; i < exp.length(); i++) {
			if (isOperator(exp.charAt(i))) {
				opr.add(exp.charAt(i));
				num.add(Integer.parseInt(tmp));
				tmp = "";
			} else {
				tmp += exp.charAt(i);
			}
		}
		// storing last number in vector
		num.add(Integer.parseInt(tmp));

		int len = num.size();
		
		System.out.println(num.size());
		System.out.println(opr.size());
		
		int[][] minVal = new int[len][len];
		int[][] maxVal = new int[len][len];

		// initializing minval and maxval 2D array
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				minVal[i][j] = Integer.MAX_VALUE;
				maxVal[i][j] = 0;

				// initializing main diagonal by num values
				if (i == j)
					minVal[i][j] = maxVal[i][j] = num.get(i);
			}
		}

		// looping similar to matrix chain multiplication
		// and updating both 2D arrays
		for (int L = 2; L <= len; L++) {
			for (int i = 0; i < len - L + 1; i++) {
				int j = i + L - 1;
				for (int k = i; k < j; k++) {
					int minTmp = 0, maxTmp = 0;
					
					System.out.println("L: " + L + " i: " + i + " k: " + k);

					// if current operator is '+', updating tmp
					// variable by addition
					if (opr.get(k) == '+') {
						minTmp = minVal[i][k] + minVal[k + 1][j];
						maxTmp = maxVal[i][k] + maxVal[k + 1][j];
					}

					// if current operator is '*', updating tmp
					// variable by multiplication
					else if (opr.get(k) == '*') {
						minTmp = minVal[i][k] * minVal[k + 1][j];
						maxTmp = maxVal[i][k] * maxVal[k + 1][j];
					}

					// updating array values by tmp variables
					if (minTmp < minVal[i][j])
						minVal[i][j] = minTmp;
					if (maxTmp > maxVal[i][j])
						maxVal[i][j] = maxTmp;
				}
			}
		}
		
		//print2dArr(maxVal);
		//print2dArr(minVal);

		// last element of first row will store the result
		System.out.println("Minimum value : " + minVal[0][len - 1]);
		System.out.println("Maximum value : " + maxVal[0][len - 1]);
	}

	static void print2dArr(int[][] arr) {
		System.out.println("-------------------------");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "1+2*3+4*5";
		printMinAndMaxValueOfExp(expression);

	}

}
