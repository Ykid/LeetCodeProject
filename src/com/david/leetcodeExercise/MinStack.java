package com.david.leetcodeExercise;

import java.util.Stack;

public class MinStack {
	//key observation: need to check the new function getMin() remains valid under the operations of all other three functions
	Stack<Integer> stack;
	Stack<Integer> minStack;
	
	public MinStack(){
		stack = new Stack<>();
		minStack = new Stack<>();
	}
		
    public void push(int x) {
        if(minStack.empty()){
        	minStack.push(x);
        }else{
        	if(minStack.peek()>=x) minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if(!stack.empty()){
        	int x = stack.peek();
        	stack.pop();
        	if(x==minStack.peek()) minStack.pop();
        }
    }

    public int top() {
        if(!stack.empty()) return stack.peek();
        else return Integer.MAX_VALUE;
    }

    public int getMin() {
        if(!minStack.empty()) return minStack.peek();
        else return Integer.MAX_VALUE;
    }
}
