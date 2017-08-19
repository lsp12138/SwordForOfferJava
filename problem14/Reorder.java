package problem14;

import java.util.Arrays;
/*
 * 面试题14：使数组中奇数位于偶数前
 * 输入一个整数数组，实现一个函数来调整数组中的数字的顺序，使得所有奇数位于数组的前半部分，偶数位于后半部分。
 * 思路：前后各一个指针相互靠近，如果前偶后奇，交换位置，直到两个指针相遇。复杂度O(n)。
 * 注意：如果题目换成负数在正数前边，或能被3整除的在不能的前边等，只是判断条件改变，所以我们把判断功能分离出来，每次只修改这个功能就行了。
 */
public class Reorder {
	static boolean yesOrNo(int number){//是不是偶数
		boolean tag = true;//是偶数返回真
		if( (number & 1) == 1 ){//是奇数返回假
			tag = false;
		}
		return tag;
	}
	static void reorder(int[] array){
		if(array.length == 0){
			System.out.println("数组为空");
			return;
		}
		int left = 0;
		int right = array.length - 1;//前后各一个指针
		while(left < right){
			while( (left < right) && !yesOrNo(array[left]) ){//跳过前边的奇数
				left++;
			}
			while( (left < right) && yesOrNo(array[right]) ){//跳过后边的偶数
				right--;
			}
			if(left < right){//交换
				int temp = array[right];
				array[right] = array[left];
				array[left] = temp;
			}
		}
	}
	public static void main(String[] args) {
		int[] test = {2,4,5,6,1,3,9};
		reorder(test);
		System.out.println(Arrays.toString(test));
	}
}
