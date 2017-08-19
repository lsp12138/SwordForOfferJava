package problem28;
import java.util.Stack;
/*
 * 本题扩展：如果不是求字符的所有排列，而是求字符的所有组合呢？
 * 比如输入abc，则它们的组合有：a,b,c,ab,ac,bc,abc。注意ab和ba是不同的排列，但是算一个组合。如果再加上一个限定长度m=2，则输出ab,ac,bc。
 * 思路：可以把n个字符分成两部分：第一个字符和其余字符。假设我们想在长度为n的字符串中求m个字符的组合，我们先从头扫描字符串的第一个字符，
 * 针对第一个字符，我们有两种选择：一是把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选取m-1个字符；二是不把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选择m个字符。用栈存储选出的字符，递归实现。
 * 注意：此方法在输入没有重复字符的情况下正常，但是如果输入类似aba的就不对了，因为它会输出重复的。解决办法是输入aba前先去重变为ab，然后把ab作为输入。
 */
public class Combination {
	public static int count = 0;//全局变量，统计有多少种组合，方法是打印一次就加一。
	
	public static void main(String[] args) {
		char[] a = "aaaaaaaabb".toCharArray();
		a = removeDuplication(a);//去除重复字符
		combiantion(a);
		System.out.println(count);
	}
	public static void combiantion(char[] str){
		if(str == null) return ;//判空
		Stack<Character> stack = new Stack<Character>();//用栈存储字符
		for(int m = 1; m <= str.length; m++){//这里的m表示从n中选取m个字符的m，弄成循环表示把全部组合都显示出来，如果限定m的值就只显示长度为m的组合。
			combine(str, 0, m, stack);
		}
	}
	//从字符数组中第begin个字符开始挑选m个字符加入栈中
	public static void combine(char[] str, int begin, int m, Stack<Character> stack){
        if(m == 0){//选取完成打印一次，返回
        	System.out.println(stack.toString());
        	count++;
        	return ;
        }
        if(begin == str.length){//字符串遍历结束，返回
        	return;
        }
        //针对第begin个字符，两种选择：选择1，把这个字符放进组合中，接下来我们需要在剩下的n-1个字符中选取m-1个字符
        stack.push(str[begin]);
        combine(str, begin + 1, m - 1, stack);
        //选择2：不把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选择m个字符。
        stack.pop();
        combine(str, begin + 1, m, stack);
	}
	static char[] removeDuplication(char[] str){
		if(str == null || str.length == 0){
			return null;
		}
		StringBuilder temp = new StringBuilder();//比string的+号效率高
		temp.append(str[0]);
		for(int i = 1;i<str.length;i++){
			boolean tag = true;//没重复为ture
			for(int j = 0;j<temp.length();j++){
				if(str[i] == temp.charAt(j)){
					tag = false;//重复返回false
					break;
				}
			}
			if(tag){
				temp = temp.append(str[i]);
			}
		}
		return temp.toString().toCharArray();
	}
}
