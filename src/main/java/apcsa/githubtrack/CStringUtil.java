package apcsa.githubtrack;

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
        // convert to int first

        int[] temp = toNumerical(str, 0);
        return maxMirror(temp);

    }

    public static int maxMirror(int[] str){
        // convert to int first

        int max = 0;
        for (int i = 0; i < str.length; i++){
            
            int[] temp;
            for (int j = 0; j < i; j++){
                temp = new int[i];
                temp[j] = str[i -j];

                int count = 0;
                for (int k = 0; k< str.length; k++){
                    for (int m = 0; m < temp.length -1; m++){
                        if (str[k + m] == temp[m]){
                            count++;
                        }
                    }
                }
                if (count > max){
                    max = count;
                }    

            }
            
        }
        return max;

    }

    public static int[] memeifyArray(int[] nums){
        int[] temp = nums;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 6){
                temp[i+1] = 7;

                int count = 0;
                for (int j = 0; j < nums.length && count <= 1; j++){
                    if (nums[j] == 7){
                        temp[j] = nums[i+1];
                        count++;
                    }
                }
            }
        }
            
        
        return temp;

    }

    public static boolean nestedSequence(CString outer, CString inner){
        // convert to int arrays
        // sort in increasing order
        // use previous methods

     

        int[] temp1 = toNumerical(new CString(outer.sortAscending()), 0);
        int[] temp2 = toNumerical(new CString(inner.sortAscending()), 0);


        
        for (int i = 0; i < temp2.length; i++){
            int count = 0;
            for (int j = 0; j < temp1.length && count <=1; j++){
                if (temp1[i] == temp2[j]){
                    count++;
                }
            }
            if (!(count > 0)){
                return false;
            }
        }
        return true;



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
            tempList[l] = list[list.length - l];
        }
        /* 
        for (int i = 0; i < length; i++){
            temp.set(i, (char)(str.charAt(i) - clumpCount));
        } */

        String tempString = "";
        for (int i = 0; i < length; i++){
            tempString += (char) tempList[i];
            // temp2.set(i, (char) tempList[i]);
        }
        CString newResult = new CString(tempString);

        return newResult;


    }





}