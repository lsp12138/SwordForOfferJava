package problem28;
import java.util.Arrays;
/*
 * 面试题28：字符串的排列(递归)
 * 输入一个字符串，打印出字符串中字符的所有排列，例如输入abc，输出abc，acb，bac，bca，cab，cba。
 * 思路：把一个字符串看成两个部分，第一部分是它的第一个字符，第二部分是它后边的所有字符。求所有排列的过程可看做两步，第一步求所有可能出现在第一个位置的字符，即把第一个字符和后面的所有字符交换。
 * 第二步固定第一个字符，求后面所有字符的排列，此时仍把后面所有字符分成上述的两部分，然后递归处理。注意本题考虑了去重复问题，即相同排列只显示一次，方法是在交换第一个元素和后边的元素时，如果值相等就不交换，或者后边这个值在之前位置出现过（说明曾经交换过），也不交换。
 * 相关题目1：输入一个含有8个数字的数组，判断有没有可能把这8个数字分别放到正方体的8个顶点上，使得正方体上三组相对的面上的4个顶点的和都相等。
 * 思路：相当于先得到8个数字的所有排列，然后选出满足条件的排列。
 * 相关题目2：八皇后问题，在8x8的国际象棋上摆放8个皇后，任意两个不能处在同一行、同一列或同一对角线。有多少种摆法？
 * 思路：首先8个皇后的任意两个不能在同一行同一列，所以肯定每行一个皇后，每列一个皇后。所以我们用一个长度为8的数组的下标表示行号，赋值为0-7表示列号，然后做全排列。如此一来便做到了不同行不同列的要求，最后判断对角线即可，方法是行数差的绝对值等于列数差的绝对值。
 */
public class Permutation {
	void permutation(char[] str){
		if(str == null) return ;
		int begin = 0;//当前正处理字符部分的起始位置
		permutation(str,begin);
	}
	void permutation(char[] str,int begin){
		if(begin+1 == str.length){//遍历完一遍字符串，打印输出一次，返回
			System.out.println(Arrays.toString(str));
		}else{
			for(int i=begin;i<str.length;i++){
				if(notSame(str,begin,i)){//去重判断，如果当前字符和后边的字符一样，或者后边字符在之前出现过，不交换。第一次自己和自己换除外。
					//1,可能出现在第一个位置的字符，即交换第一个字符和后边所有字符，第一次是自己和自己交换
					swap(str,begin,i);
					//2,固定第一个字符，递归求后面所有字符的排列
					permutation(str, begin+1);
					//3,递归处理完后边的字符后，记得把前边交换的字符再换回来，保证第一个位置的字符不重复
					swap(str,begin,i);
				}
			}
		}
	}
	boolean notSame(char[] str,int begin,int end){
		for(int p = begin;p < end;p++){
			if(str[p] == str[end]){
				return false;
			}
		}
		return true;
	}
	void swap(char[] str,int a,int b){
		char temp = str[a];
		str[a] = str[b];
		str[b] = temp;
	}
	public static void main(String[] args) {
		Permutation test = new Permutation();
		String s = "bbabb";
		test.permutation(s.toCharArray());
	}
}
