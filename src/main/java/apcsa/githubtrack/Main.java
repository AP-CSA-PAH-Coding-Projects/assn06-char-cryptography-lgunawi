package apcsa.githubtrack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


// Implement your main application logic here
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<CString> list = new ArrayList<CString>();
                
        File myFile = new File("src/main/resources/secretMessage.txt");
        Scanner scan = new Scanner(myFile);

       // int m = 0;
        while (scan.hasNext()){
            String word = scan.next();
            list.add(new CString(word));
            System.out.println(list.size());
           // m++;
        }
        scan.close(); 

        for (int i = 0; i < list.size(); i ++){
            list.set(i, CStringUtil.decrypt(list.get(i)));
        }
        // rotate message
        // arraylist to array ?!?! 
        

        // find largest ASCII value. -60; --> d
        // use nested for loop
        // print to console

        int max = 0;
        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.get(i).length(); j++){
                if (list.get(i).charAt(j) > max){
                    max = list.get(i).charAt(j);
                }
            }
        }
        max -= 60;
        int d = max;

        CString[] temp = new CString[list.size()];
        for (int k = 0; k < list.size(); k++){
            temp[k] = (list.get(k));
        }
        rotate(temp, d);






        
    }

    public static CString[] rotate(CString[] arr, int d){

        for (int j = 0; j < d; j++){
            CString temp2 = arr[0];
            for (int i = 1; i < arr.length; i++){
                arr[i-1] = arr[i];

            }
            arr[arr.length-1] = temp2;
        }
        return arr;
        
        

    }



}


