import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class AnswerData implements Chain {

    private Chain nextInChain;

    public void setNext(Chain nextChain){

        this.nextInChain = nextChain;
    }

    public void process(Files request){
        String[][] aData = StudentData.populateArray(request.getAData(), true, ",");
        ArrayList<String> answerArrayList = storeAnswers(aData);
        for (int i = 0; i < answerArrayList.size(); i++){
            System.out.println(answerArrayList.get(i));
        }
    }

    public static ArrayList<String> storeAnswers(String[][] answers){
        ArrayList<String> a = new ArrayList<String>();
        for (int i = 0; i < answers.length; i++){
            for (int j = 0; j < answers[i].length; j++){
                if (answers[i][j].contains("=") || answers[i][j].contains("/")){
                    a.add(answers[i][j]);
                }
            }
        }
        return a;
    }

    /**Main body method that calls most other methods
     * Asks user for various filenames and stores the file data in associated arrays
     * Depending on user input for the answer file, will either: immediately crosscheck answers and student data, or calculate answers and crosscheck with student data 
     */
    public static void scanQuestions(){
        Scanner sc = new Scanner(System.in);
        //Get answer data file
        System.out.println("Please enter the file path to the answer data. \nIf there is no answer data, please type n/a");
        String aName = sc.nextLine();
        if(aName.toLowerCase().equals("n/a")){
            //Get question data and store it in an array
            System.out.println("Please enter the file path to the question data.");
            String qName = sc.nextLine();
            String[][] qArr = populateArray(qName, true, "q");
        }
        sc.close();
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
}
    