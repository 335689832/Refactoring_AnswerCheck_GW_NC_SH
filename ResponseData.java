import java.util.*;

public class ResponseData extends PopulateArray{

    public static Student[] studentList;
    
    public Student[] process(String responseFile){
        String[][] response2D = populateArray(responseFile, true, ",");
        Student[] studentList = createStudentList(response2D);
        for(int i = 0; i < studentList.length;i++){
            System.out.println(studentList[i].getResponses());
        }
        return studentList;
    }

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

    private static ArrayList<String> storeResponses(String[][] arr2D, int index){

        ArrayList<String> responseArrList = new ArrayList<String>();

            for(int j = 0; j < arr2D[index].length; j++){
                if(arr2D[index][j].contains("=") || arr2D[index][j].contains("/")){
                    responseArrList.add(arr2D[index][j]);
                }
            }
        return responseArrList;
    }

    public Student[] getStudentList(){
        return studentList;
    }

}
