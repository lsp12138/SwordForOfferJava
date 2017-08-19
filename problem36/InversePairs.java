package problem36;
/*
 * 面试题36：数组中的逆序对
 * 数组中的两个数字，如果前边一个大于后边一个，则组成一个逆序对。如{7，5，6，4}中有5个逆序对，分别是(7,6)、(7,5)、(7,4)、(6,4)、(5,4)。
 * 思路：对每一个元素都从头到尾扫描的O(n^2)的方法是不好的，我们以{7，5，6，4}为例介绍一种复杂度低的方法：
 * 先把数组不断地对半分，直到子数组长度为1，接下来一边合并相邻的子数组，一边统计逆序对。比如7和5组成逆序对，6和4也是，再统计它们之间的逆序对，这之前要先排序以免重复统计，其实不好理解，详见程序。
 */
public class InversePairs {
	
	// tmp为临时数组，leftEnd和rightEnd分别指向前半段和后半段最后一个数字，leftBegin和rightBegin表示两段开始位置
	private static int merge(int[] arr, int[] tmp, int leftBegin, int rightBegin, int rightEnd){
        int leftEnd = rightBegin - 1;
        int tmpEnd = rightEnd; // 指向临时数组最后一位
        int length = rightEnd - leftBegin + 1; // 两段一共的长度
        int count = 0; // 逆序对数目
        while (leftBegin <= leftEnd && rightBegin <= rightEnd) {
        	// 如果前半段最后一个数小于等于后半段最后一个数，则这两个数构不成逆序对，把后半段最后一个数放入新数组，同时rightEnd前移一位。
            if (arr[leftEnd] <= arr[rightEnd]) {
                tmp[tmpEnd--] = arr[rightEnd--];
            }else {
            	// 如果前半段最后一个数比后半段最后一个数大，说明前半段最后一个数比后半段所有数都大，逆序对数目为后半段长度。
            	// 然后把前半段最后一个数放入新数组的最后一个（这个数组最终是正序），同时leftEnd前移一位。
                tmp[tmpEnd--] = arr[leftEnd--];
                count += rightEnd - rightBegin + 1;
            }
        }
        // 如果某一段已经全部进入新数组，现在把另一段按顺序放进新数组。
        while (leftBegin <= leftEnd) {
            tmp[tmpEnd--] = arr[leftEnd--];
        }
        while (rightBegin <= rightEnd) {
            tmp[tmpEnd--] = arr[rightEnd--];
        }
        // 更新原数组
        for (int i = 0; i < length; i++, leftBegin++) {
            arr[leftBegin] = tmp[leftBegin];
        }
        return count;
    }
	
	// left和right是分段后的起始、终止位置。leftCount是前一段内部的逆序对数目，rightCount是后半段的，count是两段之间的。
    private static int InversePairesCore(int[] arr, int[] tmp, int left, int right){
        int leftCount = 0;
        int rightCount = 0;
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            leftCount = InversePairesCore(arr, tmp, left, mid);
            rightCount = InversePairesCore(arr, tmp, mid+1, right);
            count = merge(arr, tmp, left, mid+1, right);
        }
        return leftCount + rightCount + count;
    }
    // 入口
    public int inversePaires(int[] arr){
        if (arr == null || arr.length <= 0) {
            return 0;
        }
        // 临时数组保存排序后的中间结果，然后再赋值给原数组。
        int[] tmp = arr.clone();
        int count = InversePairesCore(arr, tmp, 0, arr.length - 1);
        return count;
    }
    // 主程序
    public static void main(String[] args) throws Exception {
        InversePairs test = new InversePairs();
        System.out.println(test.inversePaires(new int[]{7,5,6,4}));
    }
}
