package problem21;

import java.util.Stack;

/*
 * 面试题21：包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的Min函数，在该栈中,min,push,pop的时间复杂度都是O(1)。
 * 思路：用两个栈，一个正常处理，另一个存最小值。入栈时，如果值比最小栈栈顶的值小，则入，否则再入一次最小栈栈顶值。每次取min时就取最小栈栈顶。
 */
public class StackWithMin<T>{
	Stack<T> stack = new Stack<>();
	Stack<T> minStack = new Stack<>();
	public void push(T t){
		stack.push(t);
		if(minStack.isEmpty() || (Integer)t < (Integer)minStack.peek()){
			minStack.push(t);
		}else{
			minStack.push(minStack.peek());
		}
	}
	public void pop(){
		if(!stack.isEmpty() && !minStack.isEmpty()){
			stack.pop();
			minStack.pop();	
		}
	}
	public void min(){
		if(!minStack.isEmpty()){
			System.out.println(minStack.peek());
		}
	}
	public static void main(String[] args){
		StackWithMin<Integer> test = new StackWithMin<Integer>();
		test.push(2);
		test.push(2);
		test.push(3);
		test.min();//2
		test.push(1);
		test.min();//1
		test.pop();
		test.min();//2
	}
}
