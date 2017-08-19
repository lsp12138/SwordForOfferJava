package problem11;
/*
 * 面试题11：数值的整数次方
 * 实现函数double Power(double base,int exponent)，求base的exponent次方，不得使用库函数，不用考虑大数问题。
 * 注意：判断两个小数是否相等不能用==，因为计算机表示小数有误差，我们只能判断它们差的绝对值是否在一个很小的范围内。
 * 题外话：程序错误处理的三种方法：返回值、全局变量、异常。返回值好处是根据返回值判断错误原因，缺点是函数只能返回一个值，使用不便。全局变量不会占用函数返回结果。异常更清晰明了，但有些语言不支持。
 */
public class Power {
	private double power(double base,int exponent) throws Exception{
		double result = 0.0;
		if(equal(base,0.0) && exponent<0){
			throw new Exception("0的负数次幂无意义");
		}
		if(exponent == 0){//其中0的0次方没有意义，返回0或1都可以
			return 1.0;
		}
		if(exponent > 0){
			result = powerWithExponent(base, exponent);
		}else{//负数次幂
			result = powerWithExponent(1.0/base, -exponent);
		}
		return result;
	}
	//计算结果
	private double powerWithExponent(double base,int exponent){
		double result = 1.0;
		for(int i=1;i<=exponent;i++){
			result = result * base;
		}
		return result;
	}
	//判断两个小数是否相等
	private boolean equal(double num1,double num2){
		if( ((num1-num2) > -0.0000001) && (num1-num2) < 0.0000001 ){
			return true;
		}else return false;
	}
	public static void main(String[] args) throws Exception {
		Power test = new Power();
		System.out.println(test.power(2, 3));
	}
}
/*
 * 以上程序的计算过程并不是效率最高的，因为假如求32次方，要循环31次，但如果我们已经求出了16次方，再平方一次就好了，而16可以由8再平方，以此类推，
 * 归纳为当n为偶数时，a^n=a^(n/2)*a^(n/2)，n为奇数时，a^n=a^((n-1)/2)*a^((n-1)/2)*a，计算量会减少，可以用递归实现，复杂度从O(n)变成了O(logn)。
 * 细节：用右移运算符代替除以2，用与运算符代替取余来判断奇偶，因为位运算符效率高很多。程序如下：
 */ 
//private double powerWithExponent2(double base,int exponent){
//	if(exponent == 0) return 1;
//	if(exponent == 1) return base;//两个递归终止的条件
//	double result = powerWithExponent2(base, exponent >> 1);//用右移1位代替除2
//	result *= result;
//	if( (exponent & 1) == 1) result *= base;//二进制最低位为1，则为奇数
//	return result;
//	//以输入（2，6）为例进行说明：开始后，进入第一次递归，输入为（2，3）
//	//然后进入第二次递归，输入为（2，1），此时exponent为1，返回base为2，也就是说第二次递归的执行结果为2
//	//然后回到了第一次递归，里头的result值为第二次递归的结果2，然后向下执行，result为2*2，第一次递归时exponent为3，result=4*2，返回8
//	//所以第一次递归的执行结果为8，然后回到原函数，里头的result为8，然后执行8*8，此时exponent为6，最终结果就是64。
//}
