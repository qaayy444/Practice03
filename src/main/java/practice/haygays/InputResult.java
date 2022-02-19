package practice.haygays;

import com.haygays.CalculatorTest;

import java.util.Arrays;
import java.util.List;
public class InputResult {
    public static void main(String[] args) {
        FindTwoNumSum findTwoNumSum=new FindTwoNumSum();
        int[] num={2,3,5,7};
        int[] result=findTwoNumSum.findTwoSum_2(num,10);
        System.out.println(Arrays.toString(result));
        ///////////////////////////////////////////////////
        FindSameString findSameString=new FindSameString();
        String[] sameStr={"book","booker","boomer"};
        System.out.println(findSameString.findString_2(sameStr));
        //////////////////////////////////////////////////
        int[] nums={-1, 0, 1, 2, -1, -4};
        //new FindThreeSum().findSum_1(nums);
        System.out.println(new FindThreeSum().findSum_2(nums));
        new CalculatorTest().PrepareCalculation();
//        ListNode node_a=new ListNode(5);
//        ListNode node_b=new ListNode(8);
//        ListNode node_c=new ListNode(10);
//        ListNode node_d=new ListNode(1);
//        ListNode node_e=new ListNode(4);
//        ListNode node_f=new ListNode(6);
//        node_a.next=node_b;
//        node_b.next=node_c;
//        node_c.next=null;
//        node_d.next=node_e;
//        node_e.next=node_f;
//        node_f.next=null;
//        ListNode r=new ListNodeSoft().nodeSoft(node_a,node_d);
//        System.out.println(r.val);

    }
}
