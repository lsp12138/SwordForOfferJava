package problem44;

import java.util.Arrays;

/*
 * 面试题44：扑克牌的顺子
 * 从一副牌中随机抽取5张判断是不是顺子，A为1，大小王可为任意值。
 * 思路：把5张牌看成大小为5的数组，大小王视为0，首先把数组排序，再统计数组中0的个数，还要统计有序数组中相邻数字之间的空缺数，去和0的个数相比，0比空缺数多的话就是顺子。
 */
public class IsContinuous {
	static boolean isContinuous(int[] arr) {
        if (arr == null || arr.length < 1)
            return false;
        int length = arr.length;
        Arrays.sort(arr);
        int numbersOfZero = 0;
        int numberOfGap = 0;
        for (int i = 0; i < length && arr[i] == 0; i++)
            ++numbersOfZero;
        int notZeroIndex = numbersOfZero;
        while (notZeroIndex < length-1) {
        	// 有重复的数肯定不是顺子
            if (arr[notZeroIndex] == arr[notZeroIndex+1])
                return false;
            numberOfGap += arr[notZeroIndex+1] - arr[notZeroIndex] - 1;
            notZeroIndex++;
        }
        return numberOfGap > numbersOfZero ? false : true;
    }
    public static void main(String[] args) {
        System.out.println(isContinuous(new int[]{2,4,5,0,0}));
    }
}
