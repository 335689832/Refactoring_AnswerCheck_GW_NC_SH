import java.io.IOException;
import java.io.FileWriter;


public class FileWrite {

    /**
     * Creates new file and writes the score of each student from selected student list
     * @param studentList List of student objects
     * @param qAmount Amount of questions
     * @param fName Name of file to be created
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
