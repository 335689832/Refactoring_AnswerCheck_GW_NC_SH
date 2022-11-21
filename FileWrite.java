import java.io.IOException;
import java.io.FileWriter;

public class FileWrite {

    /**Write each row of the 2d array arr to a seperate file
     * @param arr the array to be written to a file
     */
    public static void writeScore(Student[] studentList, int qAmount, String fName){
        try{
            //Write each line of arr into the file
            FileWriter f = new FileWriter(fName);
            for(int i = 1; i < studentList.length;i++){
                String line = "";
                line += studentList[i].getFirstName() + " ";
                line += studentList[i].getLastName() + ": ";
                line += "Score " + studentList[i].getScore() + "/" + qAmount;
                f.write(line + "\n");
                f.flush();
            }
            f.close();
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Something went wrong while creating your file.");
        }
    }
}
