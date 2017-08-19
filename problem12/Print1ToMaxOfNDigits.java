package problem12;
/*
 * 面试题12：打印1到最大的n位数
 * 输入数字n,按顺序打印出从1最大的n位十进制数。例如输入3，则打印出1,2,3,...,一直到最大的3位数即999。
 * 注意：没有限定n的范围时，注意大数问题，n可能会超出基本数值类型的表示范围，此时可以用字符串来表示，每一位上都是0-9的遍历，可以用递归。
 * 题外话：Java中有两个类BigInteger和BigDecimal分别表示大整数类和大浮点数类，理论上能表示无限大的数。
 */
public class Print1ToMaxOfNDigits {
	private void print(String str,int len){
        if (len == 0) {//递归结束条件
        	for(int j = 0;j < str.length();j++){//不输出字符串前边的0
        		if(str.charAt(j) != '0'){
        			System.out.println(str.substring(j));
        			break;
        		}
        	}
            return;
        }
        for (int i = 0; i < 10; i++) {
            print(str + i,len - 1);
            //递归说明：程序先第一次进入循环体，进入第一层递归输入是(0,1)，不满足递归结束条件，然后第二次进入循环体，再进入第二层递归输入是(00,0),满足结束条件输出00，
            //然后回到第二次进入的循环体中，执行循环体的第二轮，会进入新的第二层递归输入是(01,0),满足结束条件输出01，以此类推，直到09，这个循环体结束，
            //此时第一层递归结束，程序开始执行第一次进入的循环体的第二轮，会进入新的第一层递归，输入是(1,1),以此类推。
        }
    }
    private void print1ToMaxOfDigits(int n) {
    	if(n <= 0){
    		System.out.println("输入有误");
    		return;
    	}
        print("", n);
    }
    public static void main(String[] args) {
        Print1ToMaxOfNDigits test=new Print1ToMaxOfNDigits();
        test.print1ToMaxOfDigits(2);
    }
}
