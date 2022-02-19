package practice.haygays;

//題目:有一字串陣列，請印出陣列的所有元素中有重複前綴的字串
//EX1:["apple","application","apex"] result:"ap"
//EX2:["back","book","sb"] result:""
//比對是前綴，故EX2不會印出(b不是在第一個)
public class FindSameString {
    public String findString_1(String[] vocabStr)
    {
        //方法1:逐字檢索，挑出陣列的第0筆資料的第一個字，與後面的資料去做比較
        //使用一個字串來儲存目前前綴相同的字元，如果有不符合的就直接跳出，都符合就比對第二個字...
        //a: break用的標籤，可用來表示break的範圍(放在外圈代表break a時跳出外圈)
        StringBuilder result= new StringBuilder();
        a:for(int i=0;i<vocabStr[0].length();i++)
        {
            char indexZeroChar=vocabStr[0].charAt(i);
            for(int j=1;j<vocabStr.length;j++)
            {
                if(indexZeroChar!=vocabStr[j].charAt(i))
                    break a;
            }
            result.append(indexZeroChar);
        }

        return result.toString();
    }
    //方法2:減字檢索，找出陣列的第一筆資料，設計一個新字串作儲存，並與後面的資料直接比較
    //如果不符合，就把資料的最後一個字元扣掉，然後繼續比較，直到找到完全一樣為止
    public String findString_2(String[] vocabStr)
    {
        if(vocabStr.length==0)
            return "";
        String result=vocabStr[0];
        //i代表陣列元素
        int i=0;
        while (i<vocabStr.length)
        {
            //indexOf(str):若字串存在str的文字時，印出str在字串的index
            //若不存在，則回傳-1
            while (vocabStr[i].indexOf(result)!=0)
                result=result.substring(0,result.length()-1);
            i++;
        }

        return result;
    }
}
