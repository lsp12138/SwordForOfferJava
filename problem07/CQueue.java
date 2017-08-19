package problem07;
import java.util.Stack;
/*
 * 面试题7：用两个栈实现队列
 * 完成两个函数appendTail和deletedHead，分别是在队列尾部插入节点和在队列头部删除节点的功能。
 * 思路：添加元素即压入一个栈s1，删除元素的话，把s1中的元素按顺序先弹出再压入栈s2中，这是弹出栈s2的元素就能实现先进先出了。
 * 相关题：用两个队列实现栈。
 * 思路：添加元素即向一个队列q1添加元素，删除元素的话，把q1的元素按顺序出队然后入队到q2，最后q1剩下一个元素，就是要出栈的元素。再添加元素的话，向非空的队列添加。
 */
public class CQueue {
	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();
	
	public void appendTail(int elem){
		//添加元素就直接向stack1添加
		stack1.push(elem);
		System.out.println("stack1:" + stack1.toString());
	}
	public void deleteHead(){
		//删除分三种情况：1，stack2不空，直接从它里头弹出。2，stack2空，stack1不空，把1中先弹再压到2，再从2弹出。3，两都空。
		if(!stack2.isEmpty()){
			stack2.pop();
		}else if(!stack1.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			stack2.pop();
		}else{
			System.out.println("两个栈都空了");
		}
		System.out.println("stack1:" + stack1.toString());
		System.out.println("stack2:" + stack2.toString());
	}
	public static void main(String[] args) {
		CQueue test = new CQueue();
		test.appendTail(1);
		test.appendTail(2);
		test.appendTail(3);
		test.deleteHead();
		test.deleteHead();
		test.appendTail(4);
		test.deleteHead();
	}
}
