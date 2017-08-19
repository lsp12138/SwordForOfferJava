package problem30;

import java.util.Arrays;

/*
 * 面试题30：最小的K个数(涉及快排与堆)
 * 输入n个整数，找出其中最小的k个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。最简单的方法是先排序再输出，复杂度为O(nlogn)，但还有更快的方法。
 * 思路1：类似面试题29，也用快排的思想。快排一轮后检查我们选择的快排的key所在的下标是不是k-1就行了（不一定是排序的）。复杂度为O(n)，但是要修改数组。
 * 思路2：如果不允许修改数组，还有一种O(nlogK)的方法，很适合处理海量数据，即利用大根堆保存K个最小的数。
 * 关于堆：堆是一个完全二叉树，如果按照层序遍历结果存储为数组，下标为i且根节点i=0，则满足Key[i]>=Key[2i+1]&&Key[i]>=key[2i+2]的称为大根堆，即根结点大于子结点，堆顶为最大值。
 * 关于堆排序：第一步建堆，即将输入序列看作是层序遍历结果，然后按顺序写成完全二叉树的形式。第二步调整堆，即从最后一个非叶结点开始调整，它的数组下标为最后一个数的下标-1之后除以2，保证这个结点是最值。然后下标减一继续调整，交换结点之后的孩子结点有可能不满足堆的性质，继续调整直到下标为0，这里有递归和非递归两种方法。
 * 堆排序就是根据前边建好的堆先取出根结点和最后一个结点交换，然后对前边len-1个结点进行堆调整，再取出根结点和倒数第二个结点交换，对前边len-2个结点堆调整，以此类推直到所有结点都取出。建堆复杂度为O(n)调用一次，调整堆复杂度O(logn)调用n-1次，总复杂度为O(nlogn)，是不稳定的排序。
 * 两种思路的比较：第一种复杂度O(n)，比第二种快，但是缺点是修改了数组。第二种适合处理大数据，可以一次读一些数据和容器中的k个数比较，不用一次性全部读入数据。
 */
public class GetLeastNumbers {
	public static void main(String[] args) {
		GetLeastNumbers test = new GetLeastNumbers();
		test.getLeastNumbers1(new int[]{4,5,1,6,2,7,3,8}, 4);
		test.getLeastNumbers2(new int[]{4,5,1,6,2,7,3,8}, 4);
	}
	//思路1：基于快排的
	void getLeastNumbers1(int[] array,int k){
		if(array == null || k <= 0 || k > array.length){
			return ;
		}
		int left = 0;
		int right = array.length - 1;
		int keyIndex = partirion(array, left, right);
		while(keyIndex != k-1){
			if(keyIndex > k-1){
				right = keyIndex-1;
				keyIndex = partirion(array, left, right);
			}else{
				left = keyIndex+1;
				keyIndex = partirion(array, left, right);
			}
		}
		for(int i = 0;i<=keyIndex;i++){
			System.out.println(array[i]);
		}
	}
	//一轮快排
	Integer partirion(int[] array,int left,int right){
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
		return i;
	}
	//思路2：借用一个保存有k个数字的大根堆
		void getLeastNumbers2(int[] array,int k){
			if(array==null || k<=0 || k>array.length){
				return ;
			}
			//根据输入数组前k个数建立大根堆，从k+1个数开始与根节点比较，大于根节点则舍去，反之取代根节点并重排大根堆
			int[] kArray = Arrays.copyOfRange(array, 0, k);
			buildMaxHeapify(kArray);//建立大根堆
			for(int i=k;i<array.length;i++){
				if(array[i] < kArray[0]){//kArray[0]是堆顶
					kArray[0] = array[i];
					maxHeapify(kArray, k, 0);//替换堆顶后，执行堆排序以调整堆，保证堆顶数最大
				}			
			}
			for(int i:kArray){
				System.out.println(i);
			}
		}
		//建堆
		void buildMaxHeapify(int[] array){
			for(int i = (array.length-2) >> 1; i >= 0; i--){//这里i是最后一个非叶结点的数组下标
				maxHeapify(array, array.length, i);//调整堆
			}
		}
		//调整堆，递归法，参数heapSize为要调整的堆的大小，参数parent为当前堆顶的数组下标
		void maxHeapify(int[] array,int heapSize,int parent)
		{
			int left = 2*parent+1;//左孩子下标
			int right = left+1;//右孩子下标
			int largest = parent;//最大值下标
			if(left < heapSize && array[left] > array[parent]){
				largest=left;
			}
			if(right < heapSize && array[right] > array[largest]){
				largest=right;
			}
			//交换之后子结点可能就不满足堆的特性了，要继续调整
			if(largest != parent){
				int temp = array[parent];
				array[parent] = array[largest];
				array[largest] = temp;
				maxHeapify(array, heapSize, largest);
			}
		}
		//调整堆，循环法，参数heapSize为要调整的堆的大小，参数parent为当前堆顶的数组下标
//		void maxHeapify(int[] array, int heapSize, int parent) {
//		    int temp = array[parent]; // temp保存当前父节点
//		    int child = 2 * parent + 1; // 先获得左孩子
//		    while (child < heapSize) {
//		        // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
//		        if (child + 1 < heapSize && array[child] < array[child + 1]) {
//		            child++;
//		        }
//		        // 如果父结点的值已经大于孩子结点的值，则直接结束
//		        if (temp >= array[child]){
//		        	break;
//		        }
//		        // 把孩子结点的值赋给父结点
//		        array[parent] = array[child];
//		        // 选取孩子结点的左孩子结点,继续向下筛选
//		        parent = child;
//		        child = 2 * child + 1;
//		    }
//		    // 把原先父结点的值赋给现在的结点
//		    array[parent] = temp;
//		}
		//堆排序，执行之前要先建堆！
		void heapSort(int[] array){
			for(int i = array.length-1;i>0;i--){
				int temp = array[0];
				array[0] = array[i];
				array[i] = temp;
				maxHeapify(array, i, 0);
			}
		}
}
