package LeetCode._21MergeTwoSortedLists;

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        /* 두 리스트가 모두 공백이라면, null을 반환한다 */
        if((list1 == null)&&(list2 == null))
            return null;

        /* 한 리스트가 공백이면, 다른 리스트를 반환한다. */
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;


        ListNode cur1 = list1;  // list1을 순회할 노드포인터이다.
        ListNode cur2 = list2;  // list2를 순회할 노드포인터이다.

        ListNode cur = null;    // 두 리스트를 연결한 리스트를 이을 노드 포인터이다.
        ListNode head = null;   // 연결한 리스트의 헤드 노드 포인터이다.

        // 첫 노드를 결정하여 헤드 포인터를 지정한다.
        if(cur1.val >= cur2.val)
        {
            head = list2;
            cur = cur2;
            cur2 = cur2.next;
        }
        else
        {
            head = list1;
            cur = cur1;
            cur1 = cur1.next;
        }

        while((cur1!=null)&&(cur2!=null))
        {
            if(cur1.val >= cur2.val)
            {
                cur.next = cur2;
                cur = cur2;
                cur2 = cur2.next;
            }
            else
            {
                cur.next = cur1;
                cur = cur1;
                cur1 = cur1.next;
            }
        }

        if(cur1 != null)
            cur.next = cur1;

        if(cur2 != null)
            cur.next = cur2;

        return head;

    }
}


