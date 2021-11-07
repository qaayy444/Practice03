package com.haygays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Person {
    public void Hello()
    {
        //System.out.print("Hello!");
        int[] numTest={4,3,7,5};
        int t=9;
        //System.out.println(Arrays.toString(findTwoSum(numTest, t)));
        System.out.println(Arrays.toString(twoSum(numTest, t)));
    }
    public int[] findTwoSum(int[] num,int target)
    {
        int length=num.length;
        for(int i=0,j=1;i<length-1;i++) {
           for(int k = j; k<length; k++) {
               if(num[i]+num[k]==target) {
                   return new int[]{i,k};
               }
           }
            j++;
        }
        return new int[]{-1,-1};
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};

            }
            System.out.println(target - nums[i]);
            map.put(target - nums[i], i);
            System.out.println(map);
        }
        return null;
    }

}
