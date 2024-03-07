package core.java.practice;
import java.util.*;
public class Listpractice {
	public static void main(String[] args) {
		
		//List<String> --> generic, list of string
		//of() --> static method in list intf
		List<String> words = List.of("avs","df","fg");
		
		
		//.length in array in collections it's .size()
		System.out.println(words.size());
	}
}
