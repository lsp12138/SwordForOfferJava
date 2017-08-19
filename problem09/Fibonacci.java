package problem09;
/*
 * 面试题9：斐波那契数列
 * 写一个函数，输入n，求斐波那契数列的第n项。斐波那契数列定义如下：n=0时,f(n)=0;n=1时,f(n)=1;n>1时,f(n)=f(n-1)+f(n-2)
 * 思路1：先判断n<=0,return 0;然后判断n=1,return 1;否则return f(n-1)+f(n-2)。这种方法用了递归，简单好理解，但是效率差。
 * 比如求f(10)，要先求f(9)和f(8)，以此类推，如果把f(10)作为二叉树的根节点，那么整个树的节点会有很多重复的，复杂度随n的增加而指数增加。
 * 思路2：更简单的办法不是从n开始往下算，而是从0开始往上算，用循环而不是递归，即根据f(0)和f(1)算出f(2)，以此类推。复杂度为O(n)。
 * 相关题：一只青蛙一次可以跳上1级台阶，也可以跳上2级，求该青蛙跳上一个n级的台阶共有、多少种跳法。
 * 思路：首先考虑最简单的只有1级台阶时，此时只有1种跳法。如果有2级台阶，那就有2种跳法。对于一般情况，把n级台阶看成n的函数f(n)，开始讨论：
 * 当n>2时，第一次跳有两种选择，跳1级的话，此时跳法数目等于后面剩下的n-1级台阶的跳法数目，即f(n-1)，同理跳2级的话为f(n-2)，所以总数目是f(n-1)+f(n-2)，即斐波那契数列。
 * 扩展：如果条件改成可以跳上1级，2级，等等等直到n级，那么会有几种跳法？用数学归纳法可知有2的n-1次方种。
 */
public class Fibonacci {
	private long fibonacci(int n){
		int result[] = {0,1};
		if(n<2){
			return result[n];
		}
		long fibOne = 0;//f(0)
		long fibTwo = 1;//f(1)
		long fibN = 0;//f(n)
		for(int i=2;i<=n;i++){
			fibN = fibOne + fibTwo;
			fibOne = fibTwo;
			fibTwo = fibN;
		}
		return fibN;
	}
	public static void main(String[] args){
		Fibonacci test = new Fibonacci();
		System.out.println(test.fibonacci(8));
	}
}
