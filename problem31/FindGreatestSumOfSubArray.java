package problem31;
/*
 * 面试题31：连续子数组的最大和
 * 输入一个整数型数组，有正有负，数组中的一个或多个数字组成子数组，求所有子数组的和的最大值，要求时间复杂度为O(n)。
 * 例如输入的数组为{1,-2,3,10,-4,7,2,-5}，和最大的子数组为{3,10,-4,7,2}，因此输出为该子数组的和18。
 * 思路：从头到尾逐个累加数组中的数字作为当前和，初始化为0，如果当前和小于等于0，那么和下一个要累加的数相加后肯定比这个数小，所以当前和记为这个数才是最大的，之前的抛弃。如果当前和大于0，更新当前和为它加上下一个数。如果这个当前和比最大和还大，就更新最大和。
 */
public class FindGreatestSumOfSubArray {
	public static Integer findGreatestSumOfSubArray(int[] arr){
		if(arr == null || arr.length <= 0){
			System.out.println("Invalid Input");
			return 0;
		}
		int curSum = 0; //当前和
		int greatestSum = Integer.MIN_VALUE; //最大和，初始值设为int的最小值，适用于数组全是负数的情况。
		for(int i=0;i<arr.length;i++){
			if(curSum <= 0){
				curSum = arr[i];
			}else{
				curSum += arr[i];
			}
			if(curSum > greatestSum){
				greatestSum = curSum;
			}
		}
		return greatestSum;	
	}
	public static void main(String[] args) {
		int[] arr = {1,-2,3,10,-4,7,2,-5}; 
		int sum = findGreatestSumOfSubArray(arr);
		System.out.println(sum);
	}
}
