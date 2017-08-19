package problem18;
/*
 * 面试题18：树的子结构(递归)
 * 判断二叉树B是不是二叉树A的子树.
 * 思路：两步：1，递归调用hasSubtree先遍历A中有没有结点的值和B的根结点相同，如果有，调用doesTree1HaveTree2做第二步判断。2，判断AB结构是否相同，即递归判断左右结点。
 */
public class DoesTree1HaveTree2 {
	private boolean doseTree1HaveTree2(BiTree A,BiTree B){
		if(B == null) return true;//注意if顺序
		if(A == null) return false;
		if(A.value != B.value) return false;
		return doseTree1HaveTree2(A.left, B.left) && doseTree1HaveTree2(A.Right, B.Right);
	}
	private boolean hasSubTree(BiTree A,BiTree B){
		boolean result = false;
		if(A != null && B != null){
			if(A.value == B.value){
				result = doseTree1HaveTree2(A,B);
			}
			if(!result){
				result = hasSubTree(A.left, B);
			}
			if(!result){
				result = hasSubTree(A.Right, B);
			}
		}
		return result;
	}
	public static void main(String[] args){
		DoesTree1HaveTree2 test = new DoesTree1HaveTree2();
		BiTree A1 = new BiTree(0);
		BiTree A2 = new BiTree(1);
		BiTree A3 = new BiTree(2);
		BiTree A4 = new BiTree(3);
		BiTree A5 = new BiTree(4);
		A1.left = A2;
		A1.Right = A3;
		A2.left = A4;
		A2.Right = A5;
		BiTree B1 = new BiTree(1);
		BiTree B2 = new BiTree(3);
		BiTree B3 = new BiTree(4);
		B1.left = B2;
		B1.Right = B3;
		System.out.println(test.hasSubTree(A1, B1));
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