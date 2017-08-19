package problem45;

import java.util.ArrayList;

/*
 * 面试题45：圆圈中最后剩下的数字(约瑟夫环问题)
 * 0,1...n-1这n个数字排成一个圆圈，从第一个人开始报数，数到m的人出局，然后从下一个人开始报数，求这个圈圈里剩下的最后一个数字。
 * 思路：可用ArrayList模拟链表弄出一个圈，删到最后就剩一个数时输出，详见程序。
 */
public class LastRemaining {
	static int lastRemaining(int n, int m) throws Exception{
		if(n < 1 || m < 1)
			throw new Exception("wrong");
		ArrayList<Integer> cirList = new ArrayList<>();
		for(int i=0;i<n;i++)
			cirList.add(i);
		int cur = 0; // 开始位置下标
		while(cirList.size() > 1)
			cur = deleteCirList(cirList, m, cur);
		return cirList.get(0);
	}
	//m是步长，cur是从谁开始数，它本身算第一次，所以每次开始时把下标减1。最后返回被删除者的下标，也是新一轮开始的下标。
	static int deleteCirList(ArrayList<Integer> list, int m, int cur){
		int tmp = cur-1;
		for(int i=0;i<m;i++){
			tmp++;
			if(tmp == list.size())
				tmp = 0;
		}
		list.remove(tmp);
		return tmp;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(lastRemaining(5, 3));
	}
}
