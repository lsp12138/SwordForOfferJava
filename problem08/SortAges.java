package problem08;

import java.util.Arrays;

public class SortAges {
	//按所有员工的年龄进行排序，要求复杂度O(n)。
	//此题特点是所有的数字大小在一个小范围内（年龄在0-99,使用辅助空间）
	private void sortAges(int ages[]){
		if(ages.length == 0) System.out.println("输入为空");
		int oldestAge = 99;//最大年龄99
		int timesOfAge[] = new int[oldestAge+1];//保存每个年龄出现的次数
		for(int i=0;i<=oldestAge;i++){
			timesOfAge[i] = 0;//初始化为0
		}
		for(int i=0;i<ages.length;i++){
			if(ages[i] < 0 || ages[i] > oldestAge){
				System.out.println("错误，年龄越界");
				return;
			}else{
				timesOfAge[ages[i]]++;//该年龄出现次数加1
			}
		}
		//开始按年龄排序
		int index = 0;
		for(int i=0;i<=oldestAge;i++){
			for(int j=0;j<timesOfAge[i];j++){
				ages[index] = i;
				index++;
			}
		}
	}
	public static void main(String[] args) {
		SortAges test = new SortAges();
		int a[] = {14,25,22,44,29,44,88};
		test.sortAges(a);
		System.out.println(Arrays.toString(a));
	}
}
