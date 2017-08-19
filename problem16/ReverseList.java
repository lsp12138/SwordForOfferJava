package problem16;
/*
 * 面试题16：反转链表（递归和非递归）
 * 输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 * 思路1：定义三个指针，分别是当前要反转的结点，它的前一个结点和后一个结点。
 * 思路2：用递归。先找到倒数后两个结点反转，依次向前。
 */
class ListNode{
	int value;
	ListNode next;
	public ListNode(int x) {
		value = x;
	}
}
public class ReverseList {
	private ListNode reverseList(ListNode headNode){
		if(headNode == null){
			System.out.println("输入头结点为空");
			return null;
		}
		ListNode nowNode = headNode;//当前要反转的结点
		ListNode preNode = null;//前一个结点
		ListNode nextNode = null;//后一个结点
		ListNode revHead = null;//反转后的头结点
		while(nowNode != null){
			if(nowNode.next == null){//反转后的头结点是之前的尾结点
				revHead = nowNode;
			}
			nextNode = nowNode.next;
			nowNode.next = preNode;
			preNode = nowNode;
			nowNode = nextNode;
		}
		return revHead;
	}
	private void print(ListNode headNode){
		if(headNode == null){
			System.out.println("输入头结点为空");
			return;
		}
		while(headNode != null){
			System.out.println(headNode.value);
			headNode = headNode.next;
		}
	}
	//递归方法(不太好理解)
	private ListNode digui(ListNode headNode){
		//判断链表为空或者链表中只有一个元素
		if(headNode == null || headNode.next == null){
			return headNode;
		}else{
			ListNode revHead = digui(headNode.next);//先反转后面的链表
			headNode.next.next = headNode;//反转
			headNode.next = null;
			return revHead;
		}
	}
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		one.next = two;
		two.next = three;
		ReverseList test = new ReverseList();
		System.out.println("反转前:");
		test.print(one);
		System.out.println("反转后:");
		//test.print(test.reverseList(one));
		test.print(test.digui(one));
	}
}
