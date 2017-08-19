package problem24;

import java.util.Arrays;

/*
 * 面试题24：二叉搜索树的后序遍历序列(递归)
 * 输入一个数组，判断数组是不是二叉搜索树的后序遍历结果。
 * 思路：注意是搜索树，即左孩子<根<右孩子，后序序列的最后一个数是根，前边比根小的是左子树，比根大的是右子树，然后对左右子树递归。
 * 相关题目：后序变成前序也是这个思路，树的遍历关键都是先找根结点。
 */
public class VerifySequenceOfBST {
	private boolean verifySequenceOfBST(int[] arr){
		if(arr == null || arr.length<=0){
			return false;
		}
		int root = arr[arr.length-1];//后序的最后一个数是根
		int i = 0;//分割数组为左右子树,是右子树开始位置的下标
		for(;i<arr.length-1;i++){
			if(arr[i] > root){//左子树结点小于根节点
				break;
			}
		}
		int j = i;
		for(;j<arr.length-1;j++){//右子树结点大于根节点
			if(arr[j] < root){
				return false;
			}
		}
		//递归判断左子树是不是二叉搜索树
		boolean left = true;
		if(i > 0){
			left = verifySequenceOfBST(Arrays.copyOfRange(arr, 0, i));
		}
		//递归判断右子树是不是二叉搜索树
		boolean right = true;
		if(i < arr.length-1){
			right = verifySequenceOfBST(Arrays.copyOfRange(arr, i, arr.length-1));//记得去掉最后一个根结点
		}
		return left && right;
	}
	public static void main(String[] args) {
		VerifySequenceOfBST test = new VerifySequenceOfBST();
		int[] a = {5,7,6,9,11,10,8};
		System.out.println(test.verifySequenceOfBST(a));
	}
}
