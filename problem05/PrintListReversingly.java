package problem05;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/*
 * 面试题5：输入一个链表的头结点，从尾到头打印每个节点的值。（打印操作一般不改变链表的结构）
 * 思路1：典型的后进先出，用栈。
 * 思路2：能用栈就能用递归(层数太深容易溢出)，访问到一个节点后，递归输出它后面的节点，再输出该节点自身。
 */
public class PrintListReversingly {
	//尾插法建立链表，传入参数为头结点(头结点本身没有值)
	static ListNode createList(ListNode headNode){
		ListNode p = headNode;
		//确定头结点是否为空
		if(p == null){
			System.out.println("输入头结点为空，请检查。");
			return null;
		}else{
			Scanner sc = new Scanner(System.in);
			System.out.println("输入链表的值，以0结束：");
			int n = sc.nextInt();
			while(n != 0){
				//q为要插入的新节点
				ListNode q = new ListNode();
				q.data = n;
				q.next = null;
				p.next = q;
				//p始终指向最后一个结点
				p = q;
				n = sc.nextInt();
			}
			sc.close();
		}
		return headNode;
	}
	//从尾到头打印,用栈。
	static void print(ListNode headNode){
		Stack<ListNode> stack = new Stack<>();
		//这里假设不输出头结点。
		while(headNode != null && headNode.next != null){
			stack.push(headNode.next);
			headNode = headNode.next;
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop().data);
		}
	}
	public static void main(String[] args) {
		ListNode test = new ListNode();
		//ListNode test = null;
		print(createList(test));
	}
}
class ListNode{
	int data;
	ListNode next = null;
}
//递归方法，仅供参考，返回的arrayList已经是倒序了。
//public ArrayList<Integer> print2(ListNode headNode){
//	ArrayList<Integer> arrayList = new ArrayList<>();
//	if(headNode != null){
//		print2(headNode.next);
//		arrayList.add(headNode.data);
//	}
//	return arrayList;
//}
