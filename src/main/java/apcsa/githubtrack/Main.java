package apcsa.githubtrack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


// Implement your main application logic here
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<CString> list = new ArrayList<CString>();
                
        File myFile = new File("secretMessage.txt");
        Scanner scan = new Scanner(myFile);

        int m = 0;
        while (scan.hasNext()){
            String word = scan.next();
            list.set(m, new CString(word));
            m++;
        }
        scan.close(); 




        
    }

    public static void rotate(CString[] arr, int d){
        
    }



}


