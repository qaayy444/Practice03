package practice.haygays;

//題目:有兩個已排序的LinkedList，將兩List整理成一個排序過的LinkedList
//EX: 5->8->10 1->4->7  result:1->4->5->7->8->10
//ListedList的節點結構為ListNode.class，裡面存放的自身的值以及該節點指向的下一個位址
public class ListNodeSoft {
    public ListNode nodeSoft(ListNode l1,ListNode l2)
    {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        if(l1.val>l2.val)
        {
            l2.next=nodeSoft(l1,l2.next);
            return l2;
        }
        else
        {
            l1.next=nodeSoft(l1.next,l2);
            return l1;
        }
    }
}
