package problem40;
/*
 * 面试题40：数组中只出现一次的数字
 * 一个数组中除了两个数字之外，其它数字都出现了两次，找出这两个数。例如输入数组{2,4,3,6,3,2,5,5}，因为只有4、6两个数字只出现一次，其它都出现了两次，所以输出4、6。
 * 思路：这题比较偏，利用异或运算的性质，任何一个数异或它自己都等于0，如果从头到尾依次异或数组中的每一个数字，那么最终结果刚好是哪个只出现一次的数字，因为成对出现的数字全部在异或中抵消了。
 * 具体的，如果能够把原数组分为两个子数组，在每个子数组中，包含一个只出现一次的数字，而其它数字都出现两次。如果能够这样拆分原数组，按照前面的办法就是分别求出这两个只出现一次的数字了。我们还是从头到尾依次异或数组中的每一个数字，那么最终得到的结果就是两个只出现一次的数字的异或结果。由于这两个数字肯定不一样，那么这个异或结果肯定不为0，也就是说在这个结果的二进制表示中至少有一位为1。我们在结果数字中找到第一个为1的位的位置，记为第N位。现在我们以第N位是不是1为标准把原数组中的数字分成两个子数组，第一个子数组中每个数字的第N位都为1，而第二个子数组的每个数字的第N位都为0。现在我们已经把原数组分成了两个子数组，每个子数组都包含一个只出现一次的数字，而其它数字都出现了两次。
 */
public class FindNumsAppearOnce {
	public void findNumsAppearOnce(int[] array){
		if(array == null)
			return ;
		int number = 0;
		for(int i : array)
			number ^= i;
		int index = findFirstBitIs1(number);
		int number1 = 0;
		int number2 = 0;
		for(int i : array){
			if(isBit1(i,index))
				number1 ^= i;
			else
				number2 ^= i;		
		}
		System.out.println(number1);
		System.out.println(number2);
	}
	//找到number二进制表示中最右边1所在位置
	private int findFirstBitIs1(int number){
		int indexBit = 0;
		while((number & 1) == 0){
			number = number >> 1;
			indexBit++;
		}
		return indexBit;
	}
	//判断在number的二进制表示中从右边数起的index位是不是1
	private boolean isBit1(int number,int index){
		number = number >> index;
		return (number & 1) == 0;
	}
	public static void main(String args[]){
		FindNumsAppearOnce test = new FindNumsAppearOnce();
		int[] array = {2,4,3,6,3,2,5,5};
		test.findNumsAppearOnce(array);
	}
}
