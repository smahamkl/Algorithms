package examples.permutations;

public class AbsolutePermutation {

/*
https://www.hackerrank.com/challenges/absolute-permutation/problem
---------------------------------------------------------------------
pos[i]	i	|Difference|
3	1	2
4	2	2
1	3	2
2	4	2
Function Description
Complete the absolutePermutation function in the editor below. It should return an integer that represents the smallest lexicographically smallest permutation,
or -1 if there is none.
absolutePermutation has the following parameter(s):
n: the upper bound of natural numbers to consider, inclusive
k: the integer difference between each element and its index
Input Format
The first line contains an integer t, the number of test cases. Each of the next lines contains space-separated integers, n and k
     */
    static int[] findAbsolutePerm(int n, int k) {
        boolean isPermComplete = false;
        int[] finalList = new int[n + 1];
        int prevFilledCnt = 0;

        while (!isPermComplete) {

            for (int i = 1; i <= n; i++) {

                if ((k + i) >= 1 && ((k + i) <= n) && Math.abs(k - i) >= 1 && Math.abs(k - i) <= n) {
                    //System.out.println("dual possibility");
                    //now check if one of the numbers are already taken
                    if (finalList[k + i] >= 1 && finalList[Math.abs(k - i)] == 0)
                        finalList[Math.abs(k - i)] = i;
                    else if (finalList[Math.abs(k - i)] >= 1 && finalList[k + i] == 0)
                        finalList[k + i] = i;
                } else if ((k + i) >= 1 && ((k + i) <= n) && finalList[k + i] == 0)
                    finalList[k + i] = i;
                else if (Math.abs(k - i) >= 1 && Math.abs(k - i) <= n && finalList[Math.abs(k - i)] == 0)
                    finalList[Math.abs(k - i)] = i;
            }

            int totFilled = 0;
            for (int i = 1; i <= n; i++) {
                if (finalList[i] > 0)
                    totFilled++;
            }
            if (totFilled == prevFilledCnt) {
                isPermComplete = true;
                return new int[]{-1};
            } else
                prevFilledCnt = totFilled;


            if (totFilled == n) {
                isPermComplete = true;
                //now swap the values by position and value
               for(int i=1;i<=n;i++)
                {
                    int tmpPosition = finalList[i];
                    finalList[i] = finalList[finalList[i]];
                    finalList[finalList[i]] = tmpPosition;

                }
            }

        }
        return finalList;
    }

    public static void main(String[] args) {
        int n = 100;
        int k = 5;

        int result[] = findAbsolutePerm(n, k);

        if (result.length == 1)
            System.out.println("Element:" + result[0] + " position:" + 1);
        else {

            for (int i = 1; i <= n; i++)
                System.out.print(result[i] + "  ");
        }
    }
}
