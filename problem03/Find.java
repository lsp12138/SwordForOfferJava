package problem03;

import java.util.Scanner;

/*
 * 面试题3：在一个二维数组中，每一行的数从左到右递增，每一列的数从上到下递增。输入这样的一个数组和一个整数，判断数组中是否含有该整数。
 * 思路：别从左到右一个一个比，先比右上角的或左下角的，如果要找的数比这个数小，剔除这一列，比较前一列的第一个数。如果大，剔除这一行，再比较该列下一个数。
 * 注意如果先比左上角或右下角的是不行的。
 */
public class Find{
	public static void main(String[] args){
		int[][] array = input();
		if(array != null){
			System.out.println("请输入要找的数：");
			Scanner sc = new Scanner(System.in);
			int target = sc.nextInt();	
			if(find(array,target) == true){
				System.out.println("找到了！");
			}else{
				System.out.println("没找到！");
			}
		}

	}
	static int[][] input(){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入二维数组行数：");
		int rowNumber = sc.nextInt();
		System.out.println("请输入二维数组列数：");
		int colNumber = sc.nextInt();
		int[][] array = new int[rowNumber][colNumber];
		if(rowNumber != 0 && colNumber != 0){
			for(int i=0;i<rowNumber;i++){
				System.out.println("请输入第"+(i+1)+"行的"+(colNumber)+"个数。");
				for(int j=0;j<colNumber;j++){
					array[i][j] = sc.nextInt();
				}
			}
			return array;
		}else {
			System.out.println("输入有误！数组为空！");
			return null;
		}
	}
	static boolean find(int[][] array,int target){
		int row = 0;
		int col = array[0].length-1;
		while(row<array.length && col>=0){
			if(array[row][col] == target){
				return true;
			}
			else if(array[row][col] > target){
				col--;
			}else{
				row++;
			}
		}
		return false;
	}
}
