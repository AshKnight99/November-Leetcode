/*
Insertion Sort List
Sort a linked list using insertion sort.
A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 
Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.
Example 1:
Input: 4->2->1->3
Output: 1->2->3->4
Example 2:
Input: -1->5->3->4->0
Output: -1->0->3->4->5
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode head2,ptr2;
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        
        head2 = null;
        ptr2 = null;
        ListNode ptr = head;
        ListNode temp = null;
        
        while(ptr != null){
            temp = ptr.next;
            sortedList(ptr);
            ptr = temp;
        } 
        return head2;
        
    }
    private void sortedList(ListNode node){
        if(head2 == null || node.val < head2.val){
            node.next = head2;
            head2 = node;
           // ptr2 = node;
        }
        else{
            
            ptr2 = head2;
            while(ptr2.next != null && ptr2.next.val < node.val){            
                ptr2 = ptr2.next;
            }
            node.next = ptr2.next;
            ptr2.next = node;            
        }        
    }
}