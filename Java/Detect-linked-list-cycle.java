/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//          Detect Cycle in Linked List

 public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode slowPtr=head;
        ListNode fastPtr=head;
        
        while(fastPtr.next != null && fastPtr.next.next != null){
            
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
            if(slowPtr==fastPtr) return true;
        }
        
        return false;
    }
}