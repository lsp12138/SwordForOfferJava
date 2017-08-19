package problem26;
/*
 * 面试题26：复杂链表的复制
 * 复制一个复杂链表，这个链表除了next指针，还有指向任意一个结点的sibling指针或空指针。
 * 思路1：一个效率很低的方法：分两步，先复制一遍next链表，然后设置sibling指针。但由于不知道它指向的位置，所以要遍历一遍链表（在原链表中，从头走了几步，在新链表中，也走几步，这就能确定位置了），这样每个结点设置sibling都要经过O(n)步，总复杂度O(n^2)。
 * 思路2：用空间换时间：和上边一样还是两步，区别在于第一步的时候要记录sibling的配对信息到一个哈希表中，这样第二步就能在O(1)时间内完成单个节点的sibling的设置。用O(n)的空间复杂度换来了O(n)的时间复杂度。
 * 思路3：不用辅助空间实现O(n)的效率：三步，1，创建结点n的复制n'，n指向n'，n'指向下一个原始结点。2，设置sibling，原始结点指向谁，复制的结点就指向对应的复制。3，把这个长链表拆分成两个链表，完成复制。
 */
public class ComplexList {
	//调用
	ComplexListNode clone(ComplexListNode head){
		cloneNodes(head);
		connectSiblingNodes(head);
		return reconnectNodes(head);
	}
	//第一步，复制结点
	void cloneNodes(ComplexListNode head){
		ComplexListNode p = head;
		while(p != null){
			ComplexListNode cloned = new ComplexListNode(p.value);
			cloned.next = p.next;
			p.next = cloned;
			p = cloned.next;
		}	
	}
	//第二步，设置sibling
	void connectSiblingNodes(ComplexListNode head){
		ComplexListNode p = head;
		while(p != null){
			if(p.sibling != null){
				p.next.sibling = p.sibling.next;
			}
			p = p.next.next;
		}
	}
	//第三步，拆分
	ComplexListNode reconnectNodes(ComplexListNode head){
		ComplexListNode p = head;
		ComplexListNode clonedHead = null;
		ComplexListNode tempHead = null;
		if(p != null){
			clonedHead = p.next;
			tempHead = clonedHead;
			p.next = clonedHead.next;
			p = p.next;
		}
		while(p != null){
			tempHead.next = p.next;
			tempHead = tempHead.next;
			p.next = tempHead.next;
			p = p.next;
		}
		return clonedHead;
	}
	//打印
	void print(ComplexListNode head){
		if(head == null ) return;
		while(head != null){
			System.out.println(head.value);
			if(head.sibling != null){
				System.out.println(head.sibling);
			}
			head = head.next;
		}
	}
	public static void main(String[] args) {
		ComplexList test = new ComplexList();
		ComplexListNode root=new ComplexListNode(0);
		ComplexListNode node1=new ComplexListNode(1);
		ComplexListNode node2=new ComplexListNode(2);
		ComplexListNode node3=new ComplexListNode(3);
		ComplexListNode node4=new ComplexListNode(4);
		root.next = node1;
		root.sibling = node2;
		node1.next = node2;
		node1.sibling = node4;
		node2.next = node3;
		node3.next = node4;
		test.print(root);
		test.print(test.clone(root));
	}
}
class ComplexListNode{
	int value;
	ComplexListNode next,sibling;
	ComplexListNode(int x){
		value = x;
	}
} 