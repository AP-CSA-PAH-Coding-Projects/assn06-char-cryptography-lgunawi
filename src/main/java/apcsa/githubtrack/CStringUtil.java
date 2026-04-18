package apcsa.githubtrack;

import java.util.ArrayList;

// Implement your CStringUtil class here
public class CStringUtil{

    public static boolean isPalindrome(CString theString){
    
        String temp2 = theString.toString();
        
       
        temp2  = temp2.replace(" ", "");
        temp2 = temp2.toLowerCase();
    
        String reverse = "";

        for (int i = temp2.length() - 1; i >=0; i--){
            reverse += temp2.charAt(i);

        }
       if (temp2.equals(reverse)){
            return true;
       }
       else return false;
       
    }

    public static int[] toNumerical(CString str, int offset){
        // cast (int)
        int[] temp = new int[str.length()];
        for (int i = 0; i < str.length(); i++){
            int tempInt = str.charAt(i);
            temp[i] = tempInt + offset; 

        } 
        return temp;
    }

    public static int maxMirror(CString str){

        int[] temp = toNumerical(str, 0);

        return (maxMirror(temp));
        

    }

    public static int maxMirror(int[] str){
        // convert to int first

        int max = 0;
        int arrLength = str.length;
        for (int i = 0; i < arrLength; i++){
            
         
            for (int j = arrLength - 1; j >= 0; j--){
                int n = i;
                int m = j; 
                int maxLength = 0;
                
                while ((n < arrLength && m >= 0) && str[n] == str[m]){
                    maxLength++;
                    n++;
                    m--;
                }
                
                if (maxLength > max){
                    max = maxLength;
                }    

            }
            
        }
        return max;

    }

    public static int[] memeifyArray(int[] nums){
      

        int[] tempFinal = new int[nums.length];
        int index = 0; 
        for (int j = 0; j < nums.length; j++){

            
            if (nums[index] != 6 && nums[index] != 7){
                tempFinal[index] = nums[index];
            } 
            
            else if (nums[j] == 6){
                tempFinal[index++] = 6;
                tempFinal[index++] = 7;
            }
        }
        
        System.out.println(tempFinal);
        return tempFinal;
        

    }

    public static boolean nestedSequence(CString outer, CString inner){
        // convert to int arrays
        // sort in increasing order
        // use previous methods

        int[] temp1 = toNumerical(new CString(outer.sortAscending()), 0);
        int[] temp2 = toNumerical(new CString(inner.sortAscending()), 0);
        int i= 0;
        int j=0; 

        while (i < temp1.length && j < temp2.length){
            if (temp1[i] == temp2[j]){
                    j++;
            }
            i++;
        }

   
        return j == temp2.length;

    }

    public static CString decrypt(CString str){
       
        int[] list = toNumerical(str, 0);
        int length = str.length();
        
       // CString temp2 = str;
       
        int clumpCount = 0;
        int count = 1;

        for (int j = 1; j < list.length; j++){
            if (list[j] == list[j-1]){
                count++;
            }
            else{
                if (count >= 2){
                    clumpCount++;
                }
                count = 1; 
            }

        }
        if (count >= 2){
            clumpCount++;
        }

        // shift backwards
        for (int k = 0; k < list.length; k++){
            list[k] -= clumpCount;
        }
        
        // reverse
        int[] tempList = new int[list.length];
        for (int l = list.length -1; l >= 0; l--){
            tempList[l] = list[list.length - l -1];
        }
        

        String tempString = "";
        for (int i = 0; i < length; i++){
            tempString += (char) tempList[i];
            
        }
        CString newResult = new CString(tempString);

        return newResult;


    }





}