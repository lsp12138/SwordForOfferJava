package problem50;

import java.util.Iterator;
import java.util.LinkedList;

/*
 * 面试题50：二叉树两个结点的最低公共祖先
 * 思路：先从根结点开始遍历二叉树，得到两个结点的路径，看作链表，两个链表的第一个公共结点就是最低公共祖先。
 */
class Node{
	 String value;
	 Node left;
	 Node right;
	 public Node(String value){
		 this.value = value;
	 }
}
public class GetLastCommonParent {
	
	static Node getLastCommonParent(Node root, Node pNode1, Node pNode2){
        if (root == null || pNode1 == null || pNode2 == null)
            return null;
        Node lastCommonNode = null;
        LinkedList<Node> path1 = new LinkedList<Node>();  
        LinkedList<Node> path2 = new LinkedList<Node>(); 
        getNodePath(root, pNode1, path1);
        getNodePath(root, pNode2, path2);
        Iterator<Node> iterator1 = path1.iterator();
        Iterator<Node> iterator2 = path2.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            Node iterator1Node = iterator1.next();
            Node iterator2Node = iterator2.next();
            if (iterator1Node == iterator2Node)
                lastCommonNode = iterator1Node;
        }
        return lastCommonNode;
    }
	
	// 递归找路径，前序法，找到了返回true
	static boolean getNodePath(Node root, Node p, LinkedList<Node> list) {
        if (root == p) {
            list.add(root);
            return true;
        }
        list.add(root);
        boolean found = false;
        if (root.left != null)
            found = getNodePath(root.left, p, list);
        if (!found && root.right != null)
            found = getNodePath(root.right, p, list);
        if (!found)
            list.remove(list.size() - 1);
        return found;
    }
	public static void main(String[] args) {
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		/*
		 * 		 a
		 * 	  b	    c
		 * 	d   e		
		 * f g 
		 */
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		d.left = f;
		d.right = g;
		Node lastCommon = getLastCommonParent(a, f, e);
		System.out.println(lastCommon.value);
	}
}
