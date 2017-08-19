package problem41;
/*
 * 面试题41：和为s的两个数字，和为s的连续正数序列
 * 问题1：输入一个递增排序的数组和一个数字s.在数组中查找两个数使他们的和为s，如果有多对数字的和等于s，输出任意一对即可。
 * 思路：固定一个数字然后遍历其它数字的复杂度O(n^2)的方法肯定不好，注意这是递增的数组，可以2个指针分别指向开头末尾，即最小最大的数，然后判断和是否等于s，若小于s，则前边的指针后移，若大于s，后边的指针前移。一个循环即可复杂度O(n)。
 * 问题2：输入一个整数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * 思路：有了前边的思路，我们可以先初始化最小值为1和最大值为2，求和判断，若小于s，则增大最大值使序列包含更多值，现在序列变为{1，2，3}，若大于s，则要去掉序列中的小值，即增大最小值。
 */
public class FindNumbersWithSum {
	// 问题1
	static void q1(int[] arr,int s){
		if(arr == null)
			return;
		int small = 0;
		int big = arr.length-1;
		while(big > small){
			if(arr[small] + arr[big] == s){
				System.out.println(arr[small]);
				System.out.println(arr[big]);
				break;
			}else if(arr[small] + arr[big] > s){
				big--;
			}else{
				small++;
			}
		}
	}
	// 问题2
	static void q2(int s){
		if(s < 3)
			return;
		int small = 1;
		int big = 2;
		int mid = (s + 1) / 2;
		int curSum = small + big;
		while(small < mid){
			if(curSum == s){
				for(int i=small;i<=big;i++)
					System.out.println(i);
				curSum -= small;
				small++;
			}else if(curSum > s){
				curSum -= small;
				small++;
			}else{
				big++;
				curSum += big;
			}
		}
	}
	public static void main(String[] args) {
		int[] test = {1,2,4,7,11,15};
		q1(test,15);
		q2(15);
	}
}
