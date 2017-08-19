package problem22;
import java.util.Stack;
/*
 * 面试题22：栈的压入弹出序列
 * 输入两个整数序列，第一个序列表示压入顺序，判断第二个序列是否为弹出顺序.假设入栈所有数字均不相等。
 * 思路：构建辅助栈，以压入序列1、2、3、4、5，弹出序列4、5、3、2、1为例，第一个弹出的是4，所以要先把4压入栈，此时栈里有1234，弹出栈顶即可，下一个弹出5，就依次压入直到5,弹出。
 * 再举个反例，以弹出序列4、3、5、1、2为例，首先栈里有1234了，下一个弹出3，所以栈顶应该为3，但此时栈顶为4，所以不匹配。
 */
public class IsPopOrder {
	static boolean ispoporder(int[] a,int[] b){
		if(a == null || b == null || a.length  != b.length){
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int pushIndex = 0;
		int popIndex = 0;
		boolean tag = false;
		while(popIndex < a.length){
			while(stack.isEmpty() || stack.peek() != b[popIndex]){//压入序列,直到当前弹出序列值和栈顶值相等。
				if(pushIndex == a.length){
					break;
				}
				stack.push(a[pushIndex]);
				pushIndex++;
			}
			if(stack.peek() != b[popIndex]){
				break;
			}
			stack.pop();
			popIndex++;
		}
		if(stack.isEmpty() && popIndex == a.length){
			tag = true;
		}
		return tag;
	}
	public static void main(String[] args){
		int[] a = {1,2,3,4,5};
		int[] b = {4,5,3,2,1};
		System.out.println(ispoporder(a, b));
	}
}
