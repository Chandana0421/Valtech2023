package com.valtech.training.jdkfeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
	
	public void traditional() {
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> squares = new ArrayList<Integer>();
		for(int i : nums) {
			squares.add(i*i);
		}
		//you can run w/o toString method also
		System.out.println(nums);
		System.out.println(squares.toString());
	}
	public static void main(String[] args) {
		Streams streams = new Streams();
		streams.traditional();
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> sqrs = nums.stream().map(i->i*i).collect(Collectors.toList());
		List<Double> sqrroot = nums.stream().map(i-> Math.sqrt(i)).collect(Collectors.toList());
		List<Integer> odd = nums.stream().filter(i -> (i%2) == 1 ).collect(Collectors.toList());
		//List<Integer> oddsqr = nums.stream().filter(i -> {(i%2) == 1? i*i: i}).collect(Collectors.toList());
//		(i%2) == 1? i*i: i
		System.out.println(sqrs);
		System.out.println(sqrroot);
		System.out.println(odd);
	}
}
