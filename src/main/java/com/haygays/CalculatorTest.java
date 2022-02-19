package com.haygays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CalculatorTest {
    String inputText="5*5*5";
    boolean lastIsNum=true;
    List<Integer> numList=new ArrayList<>();
    List<String> opeList=new ArrayList<>();
    public void PrepareCalculation() {
        int length = inputText.length();
        if (length <= 0 || !lastIsNum)
            return;

        StringBuilder addString = new StringBuilder();
        for (int i = 0, j = 0; i < length; i++) {
            String singleWord = inputText.substring(i, i + 1);
            boolean isNum = Character.isDigit(singleWord.charAt(0));
            //last word must be written
            if (isNum) {
                addString.append(singleWord);
                if (i == length - 1) {
                    NumListChange(j,numList,addString);
                }
            } else {
                NumListChange(j,numList,addString);
                opeList.add(j,singleWord);
                j++;
            }
        }
        System.out.println(StartCalculation(numList,opeList));

    }
    int StartCalculation(List<Integer> numList, List<String> opeList)
    {
        int result=numList.get(0);
        int mulDivResult=0;
        for(int i=0;i<opeList.size();i++)
        {
            if(i==0)
            {
                switch (opeList.get(0))
                {
                    case "*":
                        mulDivResult=result;
                        result=0;
                        mulDivResult=mulDivResult*numList.get(i+1);
                        break;
                    case "/":
                        mulDivResult=result;
                        result=0;
                        mulDivResult=mulDivResult/numList.get(i+1);
                        break;
                }

            }

            while (i+1<opeList.size()&&(opeList.get(i+1).equals("*")||opeList.get(i+1).equals("/")))
            {
                if(mulDivResult==0)
                    mulDivResult=numList.get(i+1);
                switch (opeList.get(i+1))
                {
                    case "*":
                        mulDivResult=mulDivResult*numList.get(i+2);
                        break;
                    case "/":
                        mulDivResult=mulDivResult/numList.get(i+2);
                        break;
                }
                i++;
            }
            if(mulDivResult!=0)
            {
                result+=mulDivResult;
                mulDivResult=0;
            }
            switch (opeList.get(i))
            {
                case "+":
                    result=result+numList.get(i+1);
                    break;
                case "-":
                    result=result-numList.get(i+1);
                    break;
            }
        }
        return result;
    }


    private void NumListChange(int index, List<Integer> numList, StringBuilder addString)
    {
        numList.add(index, Integer.parseInt(addString.toString()));
        addString.delete(0, addString.length());
    }
}
