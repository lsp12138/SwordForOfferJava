package problem49;
/*
 * 面试题49：字符串转整数
 * 这里的整数是指int，要考虑的问题如下：1，输入null或空串；2，正负号；3，非法字符；4，int越界（所以返回类型定义为long）。
 */
public class StrToInt {
	public static long str2int(String str) throws Exception{
		if(str == null || str.length() == 0)
			throw new Exception("null or empty");
		long number = 0; // 要返回的int值
		boolean minus = false; // 是否为负
		int index = 0; // str下标
		// 首位是否有正负号
		if(str.charAt(index) == '+')
			index++;
		else if(str.charAt(index) == '-'){
			index++;
			minus = true;
		}
		// 如果首位有正负号，判断字符长度是否大于1，大于1或者首位不是正负号的话就接着执行
		if(index < str.length()){
			int flag = minus ? -1 : 1;
			while(index < str.length()){
				// 判断非法输入
				if(str.charAt(index) >= '0' && str.charAt(index) <= '9'){
					int digit = str.charAt(index) - '0';
					number = number * 10 + flag * digit;
					index++;
					// 判断int越界
					if((!minus && number > Integer.MAX_VALUE) || (minus && number < Integer.MIN_VALUE))
						throw new Exception("out of the int maximum or minimum");
				}else
					throw new Exception("wrong input format");
			}
		}else
			throw new Exception("only '+' or '-', no more number");
		return number;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(str2int("-123"));
	}
}
