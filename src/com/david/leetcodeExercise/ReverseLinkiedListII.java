package com.david.leetcodeExercise;

	/**
	Reverse a linked list from position m to n. Do it in-place and in one-pass.
	
	For example:
	Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	
	return 1->4->3->2->5->NULL.
	
	Note:
	Given m, n satisfy the following condition:
	1 <= m <= n <= length of list.
	*/

 // Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class ReverseLinkiedListII {
	public ListNode head;
	int size;
	ListNode tail;
	ReverseLinkiedListII(){
		head = null;
		size = 0;
		tail = null;
	}
	
	public ReverseLinkiedListII add(ListNode item){
		if (head == null){
			head = item;
			tail = item;
			size++;
		}else{
			tail.next = item;
			item.next = null;
			tail = item;
			size++;
		}
		return this;
	}
	
	public void print(){
		ListNode cur = this.head;
		for (int i =0; i<this.size;i++){
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
	
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;
        ListNode nodeBeforeM;
        ListNode prev;
        ListNode cur=head;
        
        ListNode nodeM;
        if(m==1){
        	nodeBeforeM = null;
        }
        else{
        	for (int i=1;i<m-1;i++){
        		cur = cur.next;
        	}
        	System.out.println(cur.val);
        	nodeBeforeM = cur;
            cur = cur.next;
        }
        
        //get the mth node
        nodeM= cur;
        System.out.println(nodeM.val);
        
        //set up iteration
        //cur should point to the m+1 th node
        prev = cur;
        cur = cur.next;
        
        for ( int i =0;i<n-m-1;i++){
        	//loop till the n-1 th node
        	ListNode next = cur.next;
        	cur.next = prev;
        	prev = cur;
        	cur = next;
        }
        //cur is pointing to the nth node
        if(cur.next == null)
        	//the new tail
        	nodeM.next = null;
        else nodeM.next = cur.next;
        
        //point the nth to one node backward
        cur.next = prev;
        
        if(nodeBeforeM == null){
        	return cur;
        }
        else {
        	nodeBeforeM.next = cur;
        	return head;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkiedListII instance = new ReverseLinkiedListII();
		for (int i =0;i<10;i++){
			instance.add(new ListNode(i+1));
		}
		instance.print();
		instance.head = instance.reverseBetween(instance.head, 2, 4);
		instance.print();
		instance.head = instance.reverseBetween(instance.head, 1, 1);
		instance.print();
		instance.head = instance.reverseBetween(instance.head, 1, 10);
		instance.print();
		
	}

}
