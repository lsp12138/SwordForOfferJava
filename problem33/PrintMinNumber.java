package problem33;
/*
 * 面试题33：把数组排成最小的数
 * 输入一个正整数数组，把数组中所有的数拼接起来组成一个数，输出最小的。比如输入{3,32,321}，输出321323。
 * 思路1：全排列，类似面试题28，n个数共有n！个排列，复杂度比较高。
 * 思路2：重写一种比较大小的方法，详见代码。
 */
import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber {
	public static String printMinNumber(int[] numbers) {
		if(numbers == null || numbers.length == 0) return "";
		
		int len = numbers.length;
		String[] str = new String[len];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < len; i++){
			str[i] = String.valueOf(numbers[i]);
		}
		// 重写数组的排序方法。最后返回时用的字符串比较方法，比如111和1101比较，是111大。
		Arrays.sort(str,new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				String c1 = s1 + s2;
				String c2 = s2 + s1;
				return c1.compareTo(c2);
			}
		});
		for(int i = 0; i < len; i++){
			sb.append(str[i]);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		int[] a = {3,32,321};
		String b = printMinNumber(a);
		System.out.println(b);
	}
}
