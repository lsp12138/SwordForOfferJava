package problem07;
import java.util.Queue;
import java.util.LinkedList;

//相关题，两个队列实现栈。
public class CStack {
	//是LinkedList类实现了Queue接口
	private static Queue<Integer> queue1 = new LinkedList<>();
	private static Queue<Integer> queue2 = new LinkedList<>();
	
	private void appendTail(int elem){
		//Queue使用时要尽量避免Collection的add()和remove()方法，而是要使用offer()来加入元素，使用poll()来获取并移出元素。
		//它们的优点是通过返回值可以判断成功与否，add()和remove()方法在失败的时候会抛出异常。 
		//如果要使用前端而不移出该元素，使用element()或者peek()方法。
		//这里是向非空的队列里添加值。都为空的话向队列1添加。
		if(!queue2.isEmpty()){
			queue2.offer(elem);
		}else{
			queue1.offer(elem);
		}
		System.out.println("queue1:" + queue1.toString());
		System.out.println("queue2:" + queue2.toString());
	}
	private void deleteHead(){
		//一个表示空队列，一个表示非空队列
		Queue<Integer> emptyQueue = queue1;
		Queue<Integer> notEmptyQueue = queue2;
		if(!emptyQueue.isEmpty()){
			emptyQueue = queue2;
			notEmptyQueue = queue1;
		}
		//除了非空队列的最后一个元素，别的都按顺序移到空队列
		while(notEmptyQueue.size()!=1){
			emptyQueue.offer(notEmptyQueue.poll());
		}
		//删除刚才留下的最后一个元素
		notEmptyQueue.poll();
		
		System.out.println("queue1:" + queue1.toString());
		System.out.println("queue2:" + queue2.toString());
	}

	public static void main(String[] args) {
		CStack test = new CStack();
		test.appendTail(1);
		test.appendTail(2);
		test.appendTail(3);
		test.deleteHead();
		test.appendTail(4);
		test.deleteHead();
	}
}
