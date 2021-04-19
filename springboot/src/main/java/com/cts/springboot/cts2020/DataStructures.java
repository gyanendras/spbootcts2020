package com.cts.springboot.cts2020;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DataStructures {
	LinkedList<String> list = new LinkedList<>();
	Queue<String> q = list; //FIFO
	Stack<String > stack = new Stack(); //LIFO
	
	HashMap m = new HashMap();
	HashSet hs = new HashSet();
	
    public void dSUsage(){	
    	q.add("hello");
    	q.poll();
    	stack.push("abc");
    	stack.pop();
    	
    	
    	
    	
    	
    }
    
	

}
