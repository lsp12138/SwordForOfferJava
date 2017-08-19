package problem25;

import java.util.Stack;
/*
 * 面试题25：二叉树中和为某一值的路径
 * 输入一个二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径，路径为从根结点一直到叶结点。
 * 思路：四步，1，既然是先输出根结点，那么肯定是先序遍历，把结点添加到输出路径中并累加其值，2，如果访问到的结点是叶结点并且值之和满足条件，则打印路径，3，如果当前结点不是叶结点，就继续递归访问其子结点。
 * 4，当前结点访问结束后，递归函数自动回到其父结点，所以在函数退出前要删掉路径上的该结点并减去其值，保证返回父结点时的路径是从根结点到父结点。可以看出保存路径的数据结构是后进先出的栈。
 */
public class FindPath {
	private void findPath(BiTree root,int expectedSum){
		if(root == null){
			return ;
		}
		Stack<Integer> path = new Stack<>();
		int currentSum = 0;
		findPath(root,expectedSum,path,currentSum);
	}
	private void findPath(BiTree root,int expectedSum,Stack<Integer> path,int currentSum){
		//第一步，把结点加入路径，累加和
		path.push(root.value);
		currentSum += root.value;
		//第二步，如果结点是叶结点并满足值相等的条件，打印路径
		boolean isLeaf = root.left == null && root.right ==null;
		if(currentSum == expectedSum && isLeaf){
			System.out.println("A path is found:" + path);
		}
		//第三步，如果结点不是叶结点，递归访问子结点
		if(root.left != null){
			findPath(root.left,expectedSum,path,currentSum);
		}
		if(root.right != null){
			findPath(root.right,expectedSum,path,currentSum);
		}
		//第四步，结点是叶结点，但是值不相等，函数退出到其父结点，在路径中删去这个结点
		path.pop();
		currentSum -= root.value;
	}
	public static void main(String[] args) {
		FindPath test = new FindPath();
		BiTree A1 = new BiTree(1);
		BiTree A2 = new BiTree(2);
		BiTree A3 = new BiTree(3);
		BiTree A4 = new BiTree(4);
		BiTree A5 = new BiTree(1);
		A1.left = A2;
		A1.right = A3;
		A2.left = A4;
		A2.right = A5;
		test.findPath(A1, 4);
	}
}
class BiTree{
	int value;
	BiTree left,right;
	BiTree(int x){
		value = x;
	}
}