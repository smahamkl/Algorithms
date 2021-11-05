package examples.collections.arrays;
/*
Given an integer array, move all elements that are 0 to the left while maintaining the order of other elements in the array.
The array has to be modified in-place.
 */
public class MovingZeros {

    public static void main(String[] args)
    {
        Integer[] numArr = new Integer[]{1,10,20, 0,59,63,0,88,0};
        int writeIdx = numArr.length - 1;

        for(int i=numArr.length-1;i>=0;i--)
        {
            if(numArr[i] != 0)
            {
                numArr[writeIdx] = numArr[i];
                writeIdx--;
            }
        }

        while(writeIdx >= 0) {
            numArr[writeIdx] = 0;
            writeIdx--;
        }

        for(int num:numArr)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
