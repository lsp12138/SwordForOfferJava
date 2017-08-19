package problem23;
import java.util.Queue;
import java.util.LinkedList;
/*
 * 面试题23：从上到下打印二叉树(层序遍历)
 * 思路：树或图的层序遍历即广度优先遍历，用队列。
 */
public class PrintFromTopToBottom {
	static void printFromTopToBottom(BiTree root){
		if(root == null){
			return ;
		}
		Queue<BiTree> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()){
			BiTree tree = q.poll();
			System.out.println(tree.value);
			if(tree.left != null){
				q.offer(tree.left);
			}
			if(tree.right != null){
				q.offer(tree.right);
			}
		}
	}
	public static void main(String[] args) {
		BiTree A1 = new BiTree(0);
		BiTree A2 = new BiTree(1);
		BiTree A3 = new BiTree(2);
		BiTree A4 = new BiTree(3);
		BiTree A5 = new BiTree(4);
		A1.left = A2;
		A1.right = A3;
		A2.left = A4;
		A2.right = A5;
		printFromTopToBottom(A1);
	}
}
class BiTree{
	int value;
	BiTree left;
	BiTree right;
	BiTree(int x){
		value = x;
	}
}