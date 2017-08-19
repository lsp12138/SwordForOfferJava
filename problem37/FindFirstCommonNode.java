package problem37;
/*
 * 面试题37：两个链表的第一个公共结点
 * 输入两个单向链表，输出公共节点。注意了，两个单链表如果有公共节点，形状肯定是Y型的，因为每个结点都只有一个next结点，这个公共节点之后不会有分支了。
 * 思路：假如链表长度分别为m和n，采用固定一个链表的第一个结点，遍历另一个链表的方法的复杂度为O(m*n)，有点大了，所以换个思路，既然公共节点之后的结点都是共有的，两个链表的长度差别只在公共节点之前，所以可以先得出两个链表的长度之差d，较长的链表先走d步，然后再同时遍历两个链表，直到公共节点即可。
 */
class ListNode{
	int data;
	ListNode next;
	public ListNode(int data) {
		this.data = data;
		this.next = null;
	}
}
public class FindFirstCommonNode {

	// 核心
	static ListNode findFirstCommonNode(ListNode list1, ListNode list2){
		int len1 = getLen(list1);
		int len2 = getLen(list2);
		int diff = 0;
		ListNode longList = null;
		ListNode shortList = null;
		if(len1 != 0 && len2 != 0){
			if(len1 > len2){
				diff = len1 - len2;
				longList = list1;
				shortList = list2;
			}else{
				diff = len2 - len1;
				longList = list2;
				shortList = list1;
			}
			for(int i = diff; i > 0;i--){
				longList = longList.next;
			}
			while(longList != null && shortList != null && longList != shortList){
				longList = longList.next;
				shortList = shortList.next;
			}
		}
		return longList;
	}
	
	// 求链表长度
	static int getLen(ListNode list){
		int len = 0;
		while(list != null){
			len++;
			list = list.next;
		}
		return len;
	}
	
	// main
	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode b1 = new ListNode(1);
		ListNode b2 = new ListNode(2);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		b1.next = b2;
		b2.next = a3;
		System.out.println(findFirstCommonNode(a1, b1).data);
	}
}
