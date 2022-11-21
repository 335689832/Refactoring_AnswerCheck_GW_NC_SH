import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResponseData{

    public static Student[] studentList;
    
    public static Student[] process(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student response array file: ");
        String file = sc.nextLine();
        String[][] rData = populateArray(file, true, ",");
        Student[] studentList = createStudentList(rData);
        for(int i = 0; i < studentList.length;i++){
            System.out.println(studentList[i].getResponses());
        }
        return studentList;
    }

    private static Student[] createStudentList(String[][] studentData){
        studentList = new Student[studentData.length];
        for(int i = 0; i < studentData.length; i++){
            studentList[i] = new Student();
            studentList[i].setStudentNumber(studentData[i][0]);
            studentList[i].setFirstName(studentData[i][1]);
            studentList[i].setLastName(studentData[i][2]);
            studentList[i].setEmail(studentData[i][3]);
            studentList[i].setResponses(responseList(studentData, i));
        } 
        return studentList;
    }

    private static ArrayList<String> responseList(String[][] responses, int index){

        ArrayList<String> r = new ArrayList<String>();

            for(int j = 0; j < responses[index].length; j++){
                if(responses[index][j].contains("=") || responses[index][j].contains("/")){
                    r.add(responses[index][j]);
                }
            }
        return r;
    }

    /**Fills the 2d array being returned with the data from files
    * @param file name of the file being read
    * @param lower whether or not the file should be read in lower case
    * @param delim string that upon being read, splits string into two columns
    * @return 2D array data that has been populated with the file data
    */
    public static String[][] populateArray(String file, boolean lower, String delim){
        BufferedReader br = null;   
        int lineNum = 0;
        String[][] data = new String[countLines(file)][];
        try{		
            System.out.println("Loading data...");
            br = new BufferedReader(new FileReader(file));

            System.out.println("Populating 2d array...");
            //if the contentline is not empty, set the data[linenum] to the associated file row
            String contentLine = br.readLine();
            while (contentLine != null) {
                if(!lower){
                    data[lineNum] = contentLine.split(delim, -1);
                }
                else{
                    data[lineNum] = contentLine.toLowerCase().split(delim, -1);
                }
                lineNum++;
                contentLine = br.readLine();
            }			
            System.out.println("Data loaded sucessfully.");
            return data;
        } 
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Error loading file path");
            return data;
        } 
        finally{
            try {
                if (br != null){
                    br.close();
                }
            } 
            catch (IOException e) {
                System.out.println("Error in closing the BufferedReader");
            }
        }
    }

    /**Counts the number of rows within a text file
    * @param file path of the text file
    * @return the number of rows inside the text file. If file is invalid, method returns -1
    */
    public static int countLines(String file){
        BufferedReader br = null;
        int count = 0;
        //Try to read the file
        try{			
            br = new BufferedReader(new FileReader(file));	
            String contentLine = br.readLine();
            //while the file still has rows, add one for each row
            while (contentLine != null) {
                count++;
                contentLine = br.readLine();
            }
            return count;			
        } 
        //if file cannot be read return -1 and print message
        catch (IOException |  NullPointerException e){
            System.out.println("Input invalid, please enter the correct file name");
            return -1;
        }
        finally{
            try {
                if (br != null){
                br.close();
                }  
            } 
            catch (IOException e) {
                System.out.println("Error in closing the BufferedReader");
            }
        }
    }

    public Student[] getStudentList(){
        return studentList;
    }

}
