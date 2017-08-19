package problem42;
/*
 * 面试题42：翻转单词顺序，左旋转字符串
 * 题目1：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 思路：写一个翻转字符串的函数，先翻转整个句子，再翻转每个单词。
 * 题目2：实现字符串左旋，比如输入abcdefg和数字2，输出cdefgab。
 * 思路：同理，先翻转整个句子，再翻转两个字串。
 */
public class ReverseSentence {
	// 翻转字符串的函数
	static String reverse(String str){
		if(str == null)
			return null;
		char[] arr = str.toCharArray();
		for(int i=0;i<(arr.length+1)/2;i++){
			char tmp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = tmp;
		}
		return String.valueOf(arr);
	}
	// 题目1
	static void q1(String str){
		if(str == null)
			return;
		String tmp = reverse(str);
		String[] items = tmp.split(" ");
		StringBuilder sb = new StringBuilder();
		for(String item : items){
			sb.append(reverse(item) + " ");
		}
		System.out.println(sb.toString());;
	}
	// 题目2
	static void q2(String str,int n){
		if(str == null || n > str.length() || n < 0)
			return ;
		String tmp = reverse(str);
		String[] items = {tmp.substring(0, tmp.length()-n), tmp.substring(tmp.length()-n, tmp.length())};
		StringBuilder sb = new StringBuilder();
		for(String item : items){
			sb.append(reverse(item));
		}
		System.out.println(sb.toString());
	}
	public static void main(String[] args) {
		q1("I am your father!");
		q2("woyouyijummp",5);
	}
}
