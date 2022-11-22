import java.util.*;

public class ResponseData extends PopulateArray{

    public static Student[] studentList;
    
    /**
     * Populate 2D Array and creates student list from it, then returns it
     * @param responseFile Name of file of student responses
     * @return Return an array of students
     */
    public Student[] process(String responseFile){
        String[][] response2D = populateArray(responseFile, true, ",");
        Student[] studentList = createStudentList(response2D);
        for(int i = 0; i < studentList.length;i++){
            System.out.println(studentList[i].getResponses());
        }
        return studentList;
    }

    /**
     * Creates list of student using 2D array
     * @param arr2D 2D Array used to create student list
     * @return returns created student list
     */
    private static Student[] createStudentList(String[][] arr2D){
        studentList = new Student[arr2D.length];
        for(int i = 0; i < arr2D.length; i++){
            studentList[i] = new Student();
            studentList[i].setStudentNumber(arr2D[i][0]);
            studentList[i].setFirstName(arr2D[i][1]);
            studentList[i].setLastName(arr2D[i][2]);
            studentList[i].setEmail(arr2D[i][3]);
            studentList[i].setResponses(storeResponses(arr2D, i));
        } 
        return studentList;
    }

    /**
     * Store student responses in ArrayList
     * @param arr2D 2D Array from student responses
     * @param index current student number
     * @return returns created response ArrayList
     */
    private static ArrayList<String> storeResponses(String[][] arr2D, int index){

        ArrayList<String> responseArrList = new ArrayList<String>();

            for(int j = 0; j < arr2D[index].length; j++){
                if(arr2D[index][j].contains("=") || arr2D[index][j].contains("/")){
                    responseArrList.add(arr2D[index][j]);
                }
            }
        return responseArrList;
    }

    // Getter for student Array
    public Student[] getStudentList(){
        return studentList;
    }

}
