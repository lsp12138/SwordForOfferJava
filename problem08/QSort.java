package problem08;

import java.util.Arrays;

public class QSort {
	//快排
	private void qsort(int a[],int left,int right){
		if(a.length == 0) System.out.println("输入为空");
		if(left >= right) return;//代表快排完成一轮了
		int i = left;
		int j = right;
		int key = a[left];//以第一个元素为参照key
		while(i < j){
			while(i < j && key <= a[j]){
				j--;//从后往前找比key小的
			}
			a[i] = a[j];//把找到的比key小的数往前挪
			while(i < j && key >= a[i]){
				i++;//从前往后找比key大的值
			}
			a[j] = a[i];//把找到的比key大的数往后挪
		}
		//排完一轮后把参照key还原,现在a[i]是分界线,对左右两边递归
		a[i] = key;
		qsort(a,left,i-1);
		qsort(a,i+1,right);
	}
	public static void main(String[] args) {
		QSort test = new QSort();
		int array[] = {5,4,2,3,1};
		test.qsort(array,0,array.length-1);
		System.out.println(Arrays.toString(array));
	}
}
