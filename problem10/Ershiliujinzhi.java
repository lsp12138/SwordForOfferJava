package problem10;

import java.util.Scanner;

/* 
 * 相关题目3：进制转换问题，在Excel2003中，用A表示第一列，B表示第二列...Z表示第26列，AA表示第27列，AB表示第28列...依次列推。请写出一个函数，输入用字母表示的列号编码，输出它是第几列。
 * 相关题目4：如果反过来输入列数，求26进制表示呢？
 */
public class Ershiliujinzhi {
	static int test(String str){
		char[] strArr = str.toCharArray();
		int number = 0;//最终列数
		int exp = 0;//26的指数
		for(int i=strArr.length-1;i>=0;i--){
			number += (strArr[i]-'A'+1)*Math.pow(26,exp);//Matn.pow求幂
			exp++;
		}
		return number;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.next();
			System.out.println(test(str));
			System.out.println(test2(27));
		}
		sc.close();
	}
	//相关题4
	static String test2(int number){
		StringBuilder sb = new StringBuilder();
		while(number != 0){
			int temp = number % 26;//26进制表示的最后一位
			number = number / 26;//26进制表示的倒数第二位
			if(temp == 0){//最后一位是0的话往前借一位
				temp = 26;
				number = number - 1;
			}
			sb.append( (char) ('A'+temp-1) );//这里是反序，后边再反转
		}
		return sb.reverse().toString();
	}
}