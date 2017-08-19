package problem39;
/*
 * 面试题39：二叉树的深度（以及判断平衡二叉树）
 * 思路：二叉树的深度可以用递归去求，首先如果只有根节点，深度为1，如果根节点只有一个子树，深度为子树的深度+1，如果有两个子树，深度为两个子树的深度较大值加+1。
 * 至于判断平衡二叉树的思路：有了上边求深度的方法后，马上可以想到去遍历树节点，对其子树调用求深度的函数，如果每个结点的左右子树的深度相差都不超过1，就是平衡二叉树。但是这种方法会重复遍历结点，效率太低。
 * 我们可以用后序遍历的方法遍历所有结点，这样在遍历一个结点之前我们就已经遍历了它的左右子树，只要在遍历每个结点时记录它的深度，就可以达到一边遍历一边判断每个结点手否平衡，详见代码。
 */
class BiTree{
	int data;
	BiTree left;
	BiTree right;
}
public class TreePath {
	//递归求树的深度
	static int treePath(BiTree root){
		if(root == null)
			return 0;
		int left = treePath(root.left);
		int right = treePath(root.right);
		return left > right ? (left+1) : (right+1);
	}
	// 因为java基本类型参数是值传递，无法记录每个子树的深度，所以用一个类来做参数。
	static class Depth{
		int n;
	}
	//判断平衡二叉树
	static boolean isBalanced(BiTree root){
		Depth depth = new Depth();
		return isBalanced(root, depth);
	}
	static boolean isBalanced(BiTree root, Depth depth){
		if(root == null){
			depth.n = 0;
			return true;
		}
		Depth left = new Depth();
		Depth right = new Depth();
		if(isBalanced(root.left, left) && isBalanced(root.right, right)){
			int diff = left.n - right.n;
			if(diff <= 1 && diff >= -1){
				depth.n = 1 + (left.n > right.n ? left.n : right.n);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		BiTree node1 = new BiTree();
		BiTree node2 = new BiTree();
		BiTree node3 = new BiTree();
		BiTree node4 = new BiTree();
		BiTree node5 = new BiTree();
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node4.left = node5;
		System.out.println(treePath(node1));
		System.out.println(isBalanced(node1));
	}
}
