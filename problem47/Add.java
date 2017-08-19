package problem47;
/*
 * 面试题47：不用加减乘除做加法
 * 思路：用位运算分三步，第一步不考虑进位对每一位相加（结果就是做异或的结果）；第二步记下进位，只有1+1会产生进位（等于先做与运算再左移一位）；第三步更新两个数分别为异或的结果和与的结果，重复前面两步直到不产生进位。
 * 相关问题：不使用新变量交换两个变量的值
 * 基于加减法：
 * a = a + b;
 * b = a - b;
 * a = a - b;
 * 基于异或：
 * a = a ^ b;
 * b = a ^ b;
 * a = a ^ b;
 */
public class Add {
    public static int add(int num1, int num2){
        int sum, carry;
        do{
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while(num2 != 0);
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(add(5, 17));
    }
}
