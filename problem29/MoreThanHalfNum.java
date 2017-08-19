package problem29;
/*
 * 面试题29：数组中出现次数超过一半的数字(涉及快排)
 * 数组中有一个数字出现的次数超过数组长度的一半，输出这个数字。
 * 思路1：先用快排把数组排好序，然后中间的那个数就是出现次数最多的，快排复杂度为O(nlogn)。但实际中，我们不用一次性完成快排，只需快排一轮后检查我们选择的快排的key所在的下标是不是数组中间数就行了。总复杂度O(n)，这种方法会修改数组，因此要看是否允许这样做，快排是不稳定的排序。
 * 思路2：复杂度也是O(n)且不需修改数组，方法是根据数组特点：定义一个记录出现次数的变量并初始为1，然后从头开始遍历，如果该数与上一个数不同，次数减一，反之加一，如果次数为0，保存下一个数为要返回的数，并把次数设为1。因为要找的数字比其他数字总数多，所以要找到数字就是最后一次把次数设为1时对应的数字。
 */
public class MoreThanHalfNum {
	public static void main(String[] args) {
		MoreThanHalfNum test = new MoreThanHalfNum();
		test.moreThanHalfNum1(new int[]{1,8,5,2,2,2,2});
		test.moreThanHalfNum2(new int[]{2,4,2,6,6,6,6});
	}
	//思路1，快排的思想
	private void moreThanHalfNum1(int[] array){
		if(array == null){
			return ;
		}
		int middleIndex = array.length >> 1;//中间位置下标，用右移1位代替除以2
		int left = 0;
		int right = array.length-1;
		int keyIndex = partition(array, left, right);//返回一次快排后所选key的下标。
		while(keyIndex != middleIndex){//直到快排中所选key的下标等于原数组中间位置下标
			if(keyIndex > middleIndex){
				right = keyIndex - 1;
				keyIndex = partition(array, left, right);
			}else{
				left = keyIndex + 1;
				keyIndex = partition(array, left, right);
			}
		}
		if( check(array,array[keyIndex]) ){//检查数组满不满足“某个数超过一半”
			System.out.println(array[keyIndex]);
		}else{
			System.out.println("没有超过一半的数");
		}
	}
	//思路2：根据数组特点
	private void moreThanHalfNum2(int[] array){
		if(array == null){
			return ;
		}
		int count = 1;
		int number = array[0];
		for(int i = 1;i<array.length;i++){
			if(count == 0){
				number = array[i];
				count = 1;
			}else if(array[i] != number){
				count--;
			}else{
				count++;
			}
		}
		if( check(array,number) ){
			System.out.println(number);
		}else{
			System.out.println("没有超过一半的数");
		}
	}
	//注意这是拆解的快排中的一个步骤
	private Integer partition(int[] array,int left,int right){
		if(array == null){
			return null;
		}
		int i = left;
		int j = right;
		int key = array[left];
		while(i < j){
			while(i < j && array[j] >= key){
				j--;
			}
			array[i] = array[j];
			while(i < j && array[i] <= key){
				i++;
			}
			array[j] = array[i];
		}
		array[i] = key;
		return i;//返回所选key经过一轮排序后的下标
	}  
	private boolean check(int[] array,int number){
		int times=0;
		boolean isMoreThanHalf = false;
		for(int i=0;i<array.length;i++){
			if(array[i]==number){
				times++;
			}
		}
		if(times*2 > array.length){
			isMoreThanHalf = true;
		}
		return isMoreThanHalf;
	}
}
