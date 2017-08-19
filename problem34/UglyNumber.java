package problem34;
/*
 * 面试题34：丑数
 * 只包含因子2,3,5的数为丑数，1是第一个丑数，求按从小到大排序的第1500个丑数。例如6和8都是丑数，但14不是，因为它包含因子7。
 * 思路1：所谓一个数m是另一个数n的因子，是指n能被m整除，所以丑数只能被2，3，5整除。如果一个数能被2整除，就把它连续除以2；能被3整除就连续除以3；能被5整除就连续除以5。如果最后得到的是1，那么这个数就是丑数。此方法按顺序判断每一个数即可，效率太低。
 * 思路2：用空间换时间。思路1的弊端在于一个数不管是不是丑数我们都要去算，思路2是一种只计算丑数的方法。因为每一个丑数都是前面的丑数乘以2或3或5得到的，我们把这些丑数放进一个数组中排序即可，具体方法是：
 * 假设数组中已经有若干个排好序的丑数，最大的为M，下一个要放进来的数肯定是前面某一个丑数乘2或3或5的结果，所以我们首先把已有的每个丑数乘以2，得到的结果会有比M小的数，由于前面的数是按顺序的，所以小于M的数肯定已经在数组中了就不用考虑了，我们只需要比M大的第一个数，记为M2，同理得到M3和M5，那么下一个丑数就是三者中的最小的。
 * 注意：前边说把已有的每个丑数都乘以2，3，5，这是不必要的，比如对乘以2来说，肯定会有一个丑数T2，在它之前的每个丑数乘以2后得到的数都会比最大的丑数M小，所以我们只需要记下这个T2就行了。
 */
public class UglyNumber {
    public int GetUglyNumber(int n){
    	if(n < 0){
    		return 0;
    	}
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int multiply2 = 1;
        int multiply3 = 1;
        int multiply5 = 1;
        for(int i = 1; i < uglyNumbers.length; i++){
        	// 找比M大的第一个数
        	int min = Math.min(Math.min(multiply2 * 2, multiply3 * 3), multiply5 * 5);
        	uglyNumbers[i] = min;
        	// 找T2，T3，T5
        	while(multiply2 * 2 <= min){
        		multiply2++;
        	}
        	while(multiply3 * 3 <= min){
        		multiply3++;
        	}
        	while(multiply5 * 5 <= min){
        		multiply5++;
        	}
        }
        return uglyNumbers[n-1];
    }
    public static void main(String[] args) {
        UglyNumber test = new UglyNumber();
        System.out.println(test.GetUglyNumber(1500));
    }
}
