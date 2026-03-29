package apcsa.githubtrack;

// Implement your CString class here
public class CString{
    private String[] word;

    public CString(String word){
        String[] temp = new String[word.length()];

        for (int i = 0; i < word.length(); i++){
            temp[i] = word.substring(i, i+1);
        }
        this.word = temp; 


    }

    public void reverse(){
        String[] tempRev = new String[word.length];

        int index = 0;
        for (int j = word.length-1; j >= 0; j--){
            tempRev[index] = word[j];
            index++;
        }
        word = tempRev;

    }

    public void sortAscending(){
        // selection sort 
        for (int m = 0; m < word.length -1; m++){
            int minIndex = m;
            for (int n = m + 1; n < word.length; n++){
                if (word[n].compareToIgnoreCase(word[minIndex]) < 0){
                    minIndex = n;
                }
            }
            String temp = word[m];
            word[m] = word[minIndex];
            word[minIndex] = temp; 
        }

    }

    public int length(){
        return word.length;
    }

    public String get(int index){
        return word[index];
    }

    public void set(int index, String value){
        word[index] = value;
    }

    public void sortDescending(){
        // insertion sort
        for (int l = 1; l < word.length; l++){
            String temp = word[l];
            int possibleIndex = l;
            while (possibleIndex > 0 && temp.compareToIgnoreCase(word[possibleIndex -1]) < 0){
                word[possibleIndex] = word[possibleIndex - 1];
                possibleIndex--;
            }
            word[possibleIndex] = temp; 

        }
    }    

    

}

