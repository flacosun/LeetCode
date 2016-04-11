/**
 * 264. Ugly Number II
 * https://leetcode.com/problems/ugly-number-ii/
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/10/2016.
 */
public class UglyNumberII {

    public class Solution {

        public int nthUglyNumber(int n) {
            ListNode current = new ListNode(1);
            ListNode n2 = current;
            ListNode n3 = current;
            ListNode n5 = current;

            for (int i = 2; i <= n; i++) {
                int min = Math.min(n2.val * 2, Math.min(n3.val * 3, n5.val * 5));
                current.next = new ListNode(min);
                current = current.next;
                n2 = n2.val * 2 == min ? n2.next : n2;
                n3 = n3.val * 3 == min ? n3.next : n3;
                n5 = n5.val * 5 == min ? n5.next : n5;
            }

            return current.val;
        }

        private class ListNode {
            private int val;
            private ListNode next;

            private ListNode(int value) {
                val = value;
            }
        }
    }
}
