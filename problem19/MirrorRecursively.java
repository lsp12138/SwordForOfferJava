package problem19;

import java.util.Stack;

/*
 * 面试题19：二叉树的镜像(递归和非递归)
 */
public class MirrorRecursively {
	//递归，先交换结点的左右子结点，然后递归调用左右子结点。
	static void mirrorRecursively(BiTree tree){
		if(tree != null){
			BiTree temp = tree.left;
			tree.left = tree.Right;
			tree.Right = temp;
			if(tree.left != null) mirrorRecursively(tree.left);
			if(tree.Right != null) mirrorRecursively(tree.Right);
		}
	}
	//非递归，用栈。还是先交换左右子结点，然后把根结点压入栈，取左子结点为新的根结点，直到出现左子结点为空，之后根结点出栈，取右子结点为新的根结点，循环。
	static BiTree zhan(BiTree tree){
		BiTree p = tree;
		Stack<BiTree> stack = new Stack<>();
		while(p != null || !stack.isEmpty()){//结点为空，且栈为空时结束
			while(p != null){
				BiTree temp = p.left;
				p.left = p.Right;
				p.Right = temp;
				stack.push(p);
				p=p.left;
			}
			p = stack.pop();
			p = p.Right;
		}
		return tree;
	}
}
class BiTree{
	int value;
	BiTree left;
	BiTree Right;
	BiTree(int x){
		value = x;
	}
}