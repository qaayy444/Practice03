package practice.haygays;

import java.util.HashMap;

//題目:從一個陣列中，查找陣列其中兩個數字的和是否為某個特定的數字
//若存在，傳回兩數在陣列的index
//若無，傳回-1,-1
//假設陣列沒有相同的數字、陣列未排序，只有一個答案，且均是正整數
//EX: [2,5,3,7],8->傳回[1,2] *(5+3=8)
public class FindTwoNumSum {

    //1.依序檢索陣列的兩數和
    //若陣列內的值有4個，那可能性有01、02、03、12、13、23
    //i代表前面的index，k則是後面的index，j代表著k的初始值
    //i=0時，若與index1、2、3的和都不符合target時，跳到i=1時檢索，同時，讓j=2，使得k的可能性變成2、3
    public int[] findTwoSum_1(int[] num,int target)
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
    //2.使用hashmap查找
    //假設兩數a,b，兩數的和a+b=target
    //也就是說，b=target-a
    //如果存在一個數與target-某數相同，就意味著查找成功
    //hashmap會存兩個值:key和value，在迴圈時，會判斷map內是否存在陣列num[i]的key
    //第一次必定不存在，會將第一筆的key定為target-i,value則是i
    //若存在與target-i相同的數，傳回map的該key所存放的值，以及當前的i，沒有則存第二筆
    //迴圈次數為num的長度，會比第一種方法有效率
    //*containsKey:判斷是否有該key的存在
    //*i代表num的index
    public int[] findTwoSum_2(int[] num,int target)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<num.length;i++)
        {
            if(map.containsKey(num[i]))
            {
                return new int[]{map.get(num[i]),i};
                //此為回傳兩數而非index的方法
                //return new int[]{target-num[i],num[i]};
            }
            else
            {
                map.put(target-num[i],i);
            }
        }

        return new int[]{-1,-1};
    }
}
