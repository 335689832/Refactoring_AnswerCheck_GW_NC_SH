import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileWrite {

    /**Write each row of the 2d array arr to a seperate file
     * @param arr the array to be written to a file
     */
    public static void writeArray(String[][] arr){
        Scanner sc = new Scanner(System.in);

        //filename to be written into
        System.out.println("Please enter the name of the file you'd like to store the data in. \nNote: If you type an already existing file path in, the current file will override it.");
        String fName = sc.nextLine();

        try{
            //Write each line of arr into the file
            FileWriter f = new FileWriter(fName);
            for(int i = 1; i < arr.length;i++){
                String line = "";
                for(int j = 0; j < arr[i].length;j++){
                    line += arr[i][j];
                }
                f.write(line + "\n");
                f.flush();
            }
            f.close();
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Something went wrong while creating your file.");
        }
        System.out.println("Program complete, please check file " + fName + " for results.");
        sc.close();
    }
}
