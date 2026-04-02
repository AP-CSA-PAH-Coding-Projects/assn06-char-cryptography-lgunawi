package apcsa.githubtrack;

// Implement your CString class here
public class CString{
    private char[] word;

    public CString(String word){
        char[] temp = new char[word.length()];

        for (int i = 0; i < word.length(); i++){
            temp[i] = word.charAt(i);
        }
        this.word = temp; 


    }

    public void reverse(){
        char[] tempRev = new char[word.length];

        int index = 0;
        for (int j = word.length-1; j >= 0; j--){
            tempRev[index] = word[j];
            index++;
        }
        word = tempRev;

    }

    public String sortAscending(){
        // selection sort 
        for (int m = 0; m < word.length -1; m++){
            int minIndex = m;
            for (int n = m + 1; n < word.length; n++){
                if (word[n] < word[minIndex]){
                    minIndex = n;
                }
            }
            char temp = word[m];
            word[m] = word[minIndex];
            word[minIndex] = temp; 
        }

        String temp = "";

        for (int i = 0; i < word.length; i++){
            temp += word[i];

        }
        return temp;
    }

    public int length(){
        return word.length;
    }

    public char get(int index){
        return word[index];
    }

    public char charAt(int index){
        return word[index];
    }

    public void set(int index, char value){
        word[index] = value;
    }

    public String toString(){
        String temp = "";
        for (int i = 0; i < word.length; i++){
            temp += word[i];
        }

        return temp; 
    }

   

    public String sortDescending(){
        // insertion sort
        for (int l = 1; l < word.length; l++){
            char temp = word[l];
            int possibleIndex = l;
            while (possibleIndex > 0 && temp < word[possibleIndex -1]){
                word[possibleIndex] = word[possibleIndex - 1];
                possibleIndex--;
            }
            word[possibleIndex] = temp; 

        }
        char[] tempRev = new char[word.length];

        int index = 0;
        for (int j = word.length-1; j >= 0; j--){
            tempRev[index] = word[j];
            index++;
        }
        word = tempRev;

        String temp2 = "";

        for (int i = 0; i < word.length; i++){
            temp2 += word[i];

        }
        return temp2;
    }    

    

}

