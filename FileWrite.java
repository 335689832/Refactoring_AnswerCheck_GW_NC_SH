import java.io.IOException;
import java.io.FileWriter;

public class FileWrite {

    /**Write each row of the 2d array arr to a seperate file
     * @param arr the array to be written to a file
     */
    public static void writeScore(Student[] studentList, int questionAmount, String fileName){
        try{
            //Write each line of arr into the file
            FileWriter file = new FileWriter(fileName);
            for(int i = 1; i < studentList.length;i++){
                String line = "";
                line += studentList[i].getFirstName() + " ";
                line += studentList[i].getLastName() + ": ";
                line += "Score " + studentList[i].getScore() + "/" + questionAmount;
                file.write(line + "\n");
                file.flush();
            }
            file.close();
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Something went wrong while creating your file.");
        }
    }
}
