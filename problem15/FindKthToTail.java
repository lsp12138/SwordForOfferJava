package problem15;

import java.util.Scanner;

/*
 * 面试题15：链表中倒数第K个结点
 * 输入一个单链表，输出该链表中倒数第k个结点。链表的尾结点是倒数第1个结点。例如一个链表有4个结点，依次是1,2,3,4,这个链表的倒数第3个结点是2。
 * 思路1：假设链表有n个结点，那么倒数第k个结点就是从头开始的第n-k+1个结点。所以一种方法是遍历两次链表，第一次得到n，第二次找到k。
 * 思路2：更好的方法是只需遍历一次，我们定义两个指针，第一个指针从头开始走k-1步，从第k步开始，第二个指针也开始从头开始走，两个指针的距离为k-1，当第一个指针到达尾结点时，第二个指针刚好在倒数第k个。
 * 相关题1：求链表的中间结点。如果是结点数是偶数，返回中间两个任意一个。也可以用两个指针，一个指针一次走一步，另一个走两步，走得快的到末尾时，走得慢的刚好在中间结点。
 * 相关题2：判断单链表是否形成环形结构。还是一个指针走一步，一个指针走两步，走得快的指针如果追上走得慢的指针，那么就是环形的。如果走得快的走到了末尾都没有追上，说明不是环形。
 */
class ListNode{
	int value;
	ListNode next;
	ListNode(int x){
		value = x;
		next = null;
	}
}
public class FindKthToTail {
	//头插法建立链表,这里假设头结点就是第一个结点。
	private ListNode insertFirst(){
		Scanner sc = new Scanner(System.in);
		ListNode headNode = null;
		System.out.println("输入链表值，以0结束：");
		int input = sc.nextInt();
		while(input != 0){
			ListNode p = new ListNode(input);
			p.next = headNode;
			headNode = p;
			input = sc.nextInt();
		}
		return headNode;
	}
	//正序打印链表
	private void print(ListNode headNode){
		if(headNode == null){
			System.out.println("打印方法的输入为空");
			return;
		}
		while(headNode != null){
			System.out.println(headNode.value);
			headNode = headNode.next;
		}
	}
	//找到倒数第k个
	private ListNode find(ListNode headNode, int k){
		if(headNode == null || k <= 0){
			System.out.println("输入为空或k有误");
			return null;
		}
		ListNode p1 = headNode;
		ListNode p2 = headNode;
		for(int i=0;i<k-1;i++){//p1先走k-1步
			if(p1.next != null){
				p1 = p1.next;
			}else{
				System.out.println("输入k有误");
				return null;
			}
		}
		while(p1.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
	public static void main(String[] args) {
		FindKthToTail test = new FindKthToTail();
		ListNode ln = test.insertFirst();
		test.print(ln);
		System.out.println("请输入k：");
		Scanner sc = new Scanner(System.in);	
		int k = sc.nextInt();
		System.out.println("倒数第"+k+"个是:" + test.find(ln,k).value);
		sc.close();
	}
}
