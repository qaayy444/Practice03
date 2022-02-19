package practice.haygays;

import java.util.*;

//有一整數陣列，尋找三個數a、b、c，相加等於0的存在，並印出結果
//如果存在兩種以上可能性，也將其印出來
//不能重複相同index的值(a、b、c都是在不同index上的)，且不能三數都與前一結果相同
//數列未經排列
//EX: [-1, 0, 1, 2, -1, -4]->[-1,0,1],[-1,-1,2]
public class FindThreeSum {

    //方法1:吃我的暴力解
    //問題:時間複雜度高，且無法解決重複的狀況
    //解決:先將陣列排序，然後再用set解決
    public Set<List<Integer>> findSum_1(int[] nums)
    {
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                for(int k=j+1;k<nums.length;k++)
                {
                    if(nums[i]+nums[j]+nums[k]==0) {
                        set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
        return set;
    }
    //方法2:雙指標法
    public List<List<Integer>> findSum_2(int[] nums)
    {
       //LinkedList適合用在需要大量增刪資料時使用(順序讀取能力強)
       //而ArrayList適合在需要經常搜尋資料時使用(隨機讀取能力強)
       //ArrayList:陣列資料結構;LinkedList:鏈結資料結構
       //何謂鏈結:如同線串起了每個節點(資料)，節點會存放自己的資訊外，還有下一個節點的位址
       //陣列資料使用index紀錄每筆資料，可快速尋找特定的資料，但修改陣列資料時，需要修改所有資料的位址以及index，效率較低
       //而鏈結資料要插入中間時，只要改動前一個節點的指向即可，效率較高，但搜尋特定資料時，就必須依序尋找，較浪費時間
       List<List<Integer>> result=new LinkedList<>();
       Arrays.sort(nums);

       //至少要比較兩個數，故停在兩個數之前
       for(int i=0;i<nums.length-2;i++)
       {
            //避免這筆和下筆重複判斷
           if(i == 0 || nums[i] != nums[i-1])
           {
               int left=i+1;int right=nums.length-1;
               int target=-nums[i];
               //left>right:零交集
               //left=right:題目不允許存在(不重複)
               while (left<right)
               {
                   //左邊的要大一點
                   if(nums[left]+nums[right]<target)
                       left++;
                   //右邊的要小一點
                   else if(nums[left]+nums[right]>target)
                       right--;
                   //相等的狀況
                   else
                   {
                       result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                       //避免重複判斷
                       while (left<right&&nums[left]==nums[left+1])
                           left++;
                       while (left<right&&nums[right]==nums[right-1])
                           right--;
                       left++;
                       right--;
                   }
               }
           }

       }

       return result;
    }
}
