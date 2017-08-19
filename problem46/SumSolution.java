package problem46;
/*
 * 面试题46：求1+2+...+n
 * 要求不能使用乘除法，循环，判断语句。
 */
public class SumSolution {
	public static int sum = 0;
    public static boolean sumSolution(int n) {
        sum += n;
        return n != 1 && sumSolution(n - 1);
    }
    public static void main(String[] args) {
        sumSolution(100);
        System.out.println(SumSolution.sum);
    }
}
