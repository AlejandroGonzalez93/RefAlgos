import java.util.Objects;

/* https://leetcode.com/problems/add-two-numbers/submissions/1552618467/ */

public class AddTwoNumbers {	
	public static void main(String[] args) {
		ListNode l1 = ListNode.createListNode(new int[] {9,9,9,9,9,9,9});
		ListNode l2 = ListNode.createListNode(new int[] {9,9,9,9});
		
		ListNode.printListNode(addTwoNumbersRecursive(l1, l2, false));
	}
	
	/* Recursive method for adding the listnodes. */
	static ListNode addTwoNumbersRecursive(ListNode l1,ListNode l2, boolean carry) {
        if ( Objects.isNull(l1) && Objects.isNull(l2) ) {
            if (carry) return new ListNode(1);
        	return null;
        }

        int accumulated = 0;
        if (!Objects.isNull(l1)) accumulated += l1.val; l1 = l1.next;
        if (!Objects.isNull(l2)) accumulated += l2.val; l2 = l2.next;        
        if (carry) accumulated++;
        
        carry = false;
        if (accumulated >= 10) carry = true; accumulated -= 10;

        return new ListNode(accumulated, addTwoNumbersRecursive(l1,l2,carry));	
	}
}

class ListNode {
	public int val;
	public ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }	
	
	static ListNode createListNode(int[] intList) {
		if (intList.length==0) return new ListNode();
		return createListNodeRecursive(intList[0], intList, 0);
	}
	
	private static ListNode createListNodeRecursive(int val, int[] nums, int position) {
		if (position == nums.length-1) { 
			return new ListNode(nums[position]); 
		}
		position++;
		return new ListNode(val, createListNodeRecursive(nums[position], nums, position));
	}
	
	static void printListNode(ListNode listNode) {
		while ( !(listNode == null || Integer.valueOf(listNode.val).equals(null)) ) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}
}
