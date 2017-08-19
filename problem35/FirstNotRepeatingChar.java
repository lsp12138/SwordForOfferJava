package problem35;

import java.util.LinkedHashMap;

/*
 * 面试题35：第一个只出现一次的字符
 * 例如输入“abaccdeff”，输出b。
 * 思路：从头到尾挨个扫描肯定是不行的，复杂度O(n^2)太高了。所以用哈希，空间换时间。
 * 相关题目1：输入两个字符串，从第一个字符串中删除在第二个字符串中出现过的字符。可以用哈希来存储第二个字符串中的字符，然后扫描第一个字符串，用O(1)的时间就能判断字符在不在第二个字符串里，总时间复杂度O(n)。
 * 相关题目2：删除字符串中所有重复出现的字符。比如输入“google”，输出“gole”。方法是从头到尾扫描，第一次出现的放进哈希中，然后重复出现的不管了。
 * 相关题目3：如果两个单词中出现的字母相同，并且每个字母出现的次数也相同，那么这两个单词互为变位词。例如evil和live。进行判断时可以用哈希，key为出现的字母，value为出现次数。
 */
public class FirstNotRepeatingChar {
	public Character firstNotRepeatingChar(String str){
		if(str == null){
			return null;
		}
		char[] chars = str.toCharArray();
		LinkedHashMap<Character, Integer> hash = new LinkedHashMap<Character, Integer>();
		for(char item : chars){
			if(hash.containsKey(item)){
				hash.put(item, hash.get(item)+1);
			}else{
				hash.put(item, 1);
			}
		}
		// 不用LinkedHashMap只用HashMap的话，这里就错了，因为顺序不一样。
		for(char key : hash.keySet()){
			if(hash.get(key) == 1)
				return key;
		}
		return null;
	}
	public static void main(String[] args) {
		FirstNotRepeatingChar test = new FirstNotRepeatingChar();
		System.out.println(test.firstNotRepeatingChar("abaccdeff"));
	}
}
