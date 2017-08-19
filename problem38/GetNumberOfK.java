package problem38;
/*
 * 面试题38：数字在排序数组中出现的次数
 * 例如输入{1,2,3,3,3,3,4,5}和3，由于3出现了4次，输出4。
 * 思路：顺序查找复杂度为O(n)，我们有O(logn)的方法，就是用二分查找，找到该数字第一次出现和最后一次出现的位置即可，详见代码。
 */
public class GetNumberOfK {
	
	// 二分法找第一个出现的k
	static int getFirstK(int[] arr, int k, int start, int end){
		if(start > end)
			return -1;
		int mid = (start + end) / 2;
		if(arr[mid] == k){
			if((mid > 0 && arr[mid-1] != k) || mid == 0)
				return mid;
			else
				end = mid - 1;
		}else if(arr[mid] > k)
			end = mid - 1;
		else
			start = mid + 1;
		return getFirstK(arr, k, start, end);
	}
	// 二分法找最后一个k
	static int getLastK(int[] arr, int k, int start, int end){
		if(start > end)
			return -1;
		int mid = (start + end) / 2;
		if(arr[mid] == k){
			if((mid < arr.length-1 && arr[mid+1] != k) || mid == arr.length-1)
				return mid;
			else
				start = mid + 1;
		}else if(arr[mid] < k)
			start = mid + 1;
		else
			end = mid - 1;
		return getLastK(arr, k, start, end);
	}
	
	// 计算个数
	static int getNumberOfK(int[] arr, int k){
		int number = 0;
		if(arr != null && arr.length > 0){
			int first = getFirstK(arr, k, 0, arr.length-1);
			int last = getLastK(arr, k, 0, arr.length-1);
			if(first >= 0 && last >= 0)
				number = last - first + 1;
		}
		return number;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,3,3,3,4,5};
		int k = 3;
		System.out.println(getNumberOfK(arr, k));
	}
}
