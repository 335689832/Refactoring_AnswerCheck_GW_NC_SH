import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

class ArrAssignment {

    /**Ask user for filename and call populateArray to fill the array with the data before returning it
     * @return 2d array containing data from file submitted
     */
    public static String[][] scanStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the file path to the student data.");
        String fName = sc.nextLine();
        //Populate the array and return it
        String[][] arr = (populateArray(fName, false, ","));
        return arr;
    }

    /**Main body method that calls most other methods
     * Asks user for various filenames and stores the file data in associated arrays
     * Depending on user input for the answer file, will either: immediately crosscheck answers and student data, or calculate answers and crosscheck with student data 
     */
    public static void scanQuestions(){
        Scanner sc = new Scanner(System.in);

        //Get student response data and store in array rArr
        System.out.println("Please enter the file path to the student response data.");
        String rName = sc.nextLine();
        String[][] rArr = populateArray(rName, false, ",");
        //Get answer data file
        System.out.println("Please enter the file path to the answer data. \nIf there is no answer data, please type n/a");
        String aName = sc.nextLine();
        if(aName.toLowerCase().equals("n/a")){
            //Get question data and store it in an array
            System.out.println("Please enter the file path to the question data.");
            String qName = sc.nextLine();
            String[][] qArr = populateArray(qName, true, "q");
            String[][] cArr = calculate(qArr, qName);
            checkAnswers(cArr, rArr);
        }
        else{
            String[][] aArr = populateArray(aName, true, "a");
            checkAnswers(aArr, rArr);
        }
        sc.close();
    }

    /**calculate system of equations using question array
     * @param qArr 2d array populated by questions asked
     * @param fName the filename of the questions file
     * @return a 2d array populated by the answers to the questions
     */
    public static String[][] calculate(String[][] qArr, String fName){
        //count total amount of questions based on the number of q's in the file
        int qAmount = countWords("q", qArr);
        int c = 0;
        int s1 = 0;
        int s2 = 0;
        //Set string length to the same format as the answer file so checkAnswers can still be used
        String[][] cArr = new String[((qAmount*3) -1)][1];
        
        //For each question
        for(int i = 0; i < qAmount;){
            //For each row, check if the cell length is less than 3(all question data rows have at least 3 characters)
            //If greater than/equals 3 solve
                if(qArr[i][0].length() < 3){
                    i++;
                }
                else{
                    //This is where I would put my system of equations code, IF I HAD ANY
                    //What I would have done was take the individual cells of the question array 
                    //and split them with regex "=" and store them in their own 2d array in rows
                    //I would then split the larger side of the equal sign with regex "+" or "-" and depending on whether it was negative or not, 
                    //I would modify the second cell to make it negative.
                    //When everything is in its own cell with the proper sign, I would use determinants to work out the solution
                    //ex: c1*c2 - b1*b2 / a1*b2 - a2*b1 = x
                    i++;
                }
            //Write to 2d array cArr in format of answer arrays
            cArr[c][0] = "A" + (i+1);
            c++;
            cArr[c][0] = s1 + ";" + s2;
            c++;
            cArr[c][0] = "";
            c++;
        }

        return cArr;
    }

    /**Compares each cell after 4 of two 2D arrays
     * Populates separate 2D with student data and score combined to write to a file
     * Print the student data, their answers, and whether each of them was correct
     * @param aArr 2D array populated with answer data user entered
     * @param rArr 2D array populated with student response data user entered
     */
    public static void checkAnswers(String[][] aArr, String[][] rArr ){
        //Setup 2D array gArr with same amount of rows as rArr and 5 columns
        //4 columns for student data, and 1 more for the score
        String[][] gArr= new String[rArr.length][5];
        //Loop through the length of 2d array rArr starting at row 1
        for(int i = 1; i < rArr.length; i++){
            //Reset counter to count the columns greater than 4 (4 is where non answer student data ends)
            int counter = 4;
            //Reset count the total amount of questions
            int qTotal = 0;
            //Reset count the amount of correct questions
            int score = 0;
            //Reset String to populate gArr with
            String tScore = "";

            //Print student data with answers before each check
            for(int j = 0; j < rArr[i].length;j++){
                if(j < 4){
                    System.out.print(rArr[i][j] + " ");
                }
            }
            System.out.println();
            //Loop the amount of questions in aArr there are
            //Start at row 1 to skip unecessary data, increase by three rows to find next question
            for(int f = 1; f < aArr.length;f+=3){
                //Check if current answer is equal to current response
                //if matching print question number and answer is correct, add 1 to score
                if(rArr[i][counter].equals(aArr[f][0])){
                    System.out.println("Q"+ (qTotal+1) + ". " + rArr[i][counter] + " is correct.");
                    score++;
                }
                //if not matching, print student answer is incorrect and then the correct answer
                else{
                    System.out.println("Q"+ (qTotal+1) + ". " + rArr[i][counter] + " is incorrect.");
                    System.out.println("Correct answer is: " + aArr[f][0]);
                }
                //Add one to counter to move to next question
                counter++;
                //Add one to the total question counter
                qTotal = counter-4;
            }
            //Set tScore to equal score of student
            tScore = "Score: " + score + "/" + qTotal;
            System.out.println(tScore);
            System.out.println();
            //Set each cell of row[i] of gArr equal to student data + score
            for(int x = 0; x < rArr[i].length;x++){
                if(x < 4){
                    gArr[i][x] = rArr[i][x]+", ";
                }
                else{
                    gArr[i][x] = tScore;
                    break;
                }
            }
        }
        writeArray(gArr);
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

    /**Count the amount of times a substring appears in a 2d array
     * @param word the substring to be counted
     * @param arr the array to be read
     * @return total amount of times substring has appeared
     */
    public static int countWords(String word, String[][] arr){
        int count = 0;
        for(String[] row: arr){
            for(int i = 0; i< row.length; i++){
                if(row[i].toLowerCase().contains(word.toLowerCase())){
                    count++;
                }
            }
        }
        return count;
    }

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

    public static void main(String[] args){
        String[][] sData = scanStudent();
        scanQuestions();
    }

}
