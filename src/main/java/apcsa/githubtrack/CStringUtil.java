package apcsa.githubtrack;

// Implement your CStringUtil class here
public class CStringUtil{
    private static String[] word;

    public CStringUtil(String[] word){
        this.word = word;

    }

    public static boolean isPalindrome(){
        // decapitate & remove spaces
    
        int count = 0; // finding length w/o spaces
        for (int i = 0; i < word.length; i++){
            if (!(word[i].equals(""))){
                count++;
            }
        }

        String[] temp = new String[count];
        for (int j = 0; j < word.length; j++){
            if (!(word[j].equals(""))){
                temp[j] = word[j];
            }
        }
        int length = (temp.length / 2);
       
       
        for (int l = 0; l < length; l++){
            if (!(temp[l].equals(temp[temp.length - l]))){
                return false; 
            }

        }

        return true;
    }

    public static int[] toNumerical(CString str, int offset){
        // cast (int)
        int[] temp = new int[str.length()];
        for (int i = 0; i < str.length(); i++){
            char charTemp = str.get(0).charAt(0);
            int tempInt = charTemp;
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
                    for (int m = 0; m < temp.length; m++){
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
        int[] temp1 = toNumerical(outer, 0);
        int[] temp2 = toNumerical(inner, 0);


        for (int m = 0; m < temp1.length -1; m++){
            int minIndex = m;
            for (int n = m + 1; n < temp1.length; n++){
                if (temp1[n] < temp1[m]){
                    minIndex = n;
                }
            }
            int temp = temp1[m];
            temp1[m] = temp1[minIndex];
            temp1[minIndex] = temp; 
        }

        for (int m = 0; m < temp2.length -1; m++){
            int minIndex = m;
            for (int n = m + 1; n < temp2.length; n++){
                if (temp2[n] < temp2[m]){
                    minIndex = n;
                }
            }
            int temp = temp2[m];
            temp2[m] = temp2[minIndex];
            temp2[minIndex] = temp; 
        }
        
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
        // analyze numerical representation (call method)
        //
        // count # of clumps
        // shift ASCII values backwards ?? (by num of clumps)
        // sequence reversed ?? 
        int length = str.length();
        CString temp = str;

        for (int i = 0; i < length; i++){
            temp.set(i, str.get(length-i));
        }

        return temp;
    }





}