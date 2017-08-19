package problem43;
/*
 * 面试题43：n个骰子的点数(动态规划)
 * 扔n个骰子，所有骰子朝上一面的点数之和为s,输入n,打印出s的所有可能的值出现的概率。
 * 思路：n个骰子和最小为你，最大为6n，根据排列组合，n个骰子的所有点数的排列为6^n，我们需要先统计出每一种点数和的出现次数，然后除以6^n即为概率。动态规划分析如下：
 * 当有n个骰子，点数和为s，则每一种点数和出现的次数记为f(n,s)。现在假设我有n-1个骰子，再增加一个骰子，它的点数只能是1到6，则n个骰子得到点数和为s的情况有6种，所以f(n,s)=f(n-1,s-1)+f(n-1,s-2)+...+f(n-1,s-6)，当有一个骰子时，f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1。
 * 具体到程序，用两个数组，在第一次循环中，第一个数组中的第s个数字表示和为s出现的次数。在下一次循环中，加上一个新骰子，此时和为s出现的次数等于上一次循环中和为s-1,s-2,s-3直到s-6出现次数的总和，所以把另一个数组的第s个数字设为前一个数组对应的第s-1,s-2,s-3直到s-6之和，下一轮循环交换数组重复这一过程。
 */
public class Probability {
    
    static void printProbability(int number){
        if (number<1)
            return;
        int g_maxValue = 6;
        int[][] pProbabilitys = new int[2][g_maxValue * number + 1];
        int flag = 0; // 控制在2个数组间切换
        // 一个骰子时
        for (int i = 1; i <= g_maxValue; i++)
            pProbabilitys[flag][i] = 1;
        // 开始加骰子
        for (int k = 2; k <= number; k++) {
        	// 不可能出现的次数标记为0
            for (int i = 0; i < k; i++)
                pProbabilitys[1-flag][i] = 0;
            // 可能出现的次数
            for (int i = k; i <= g_maxValue*number; i++) {
                pProbabilitys[1-flag][i] = 0;
                for (int j = 1; j <= i && j <= g_maxValue; j++) 
                    pProbabilitys[1-flag][i] += pProbabilitys[flag][i-j];                
            }
            flag = 1-flag;
        }
        double total = Math.pow(g_maxValue, number);
        for (int i = 1; i <= g_maxValue*number; i++) {
            double ratio = pProbabilitys[flag][i] / total;
            System.out.println(i + ": " + ratio);
        }
    }

	public static void main(String[] args) {
		printProbability(1);
	}
}
