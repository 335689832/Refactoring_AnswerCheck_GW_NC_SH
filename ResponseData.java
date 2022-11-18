import java.util.*;

public class ResponseData implements Chain {

    private Chain nextInChain;

    public void setNext(Chain nextChain){

        this.nextInChain = nextChain;
    }   
    
    public void process(Files request){
        String[][] rData = StudentData.populateArray(request.getRData(), true, ",");
        createStudentList(rData);
    }

    private void createStudentList(String[][] studentData){
        Student[] studentList = new Student[studentData.length];
        for(int i = 0; i < studentData.length; i++){
            studentList[i] = new Student();
            studentList[i].setStudentNumber(studentData[i][0]);
            studentList[i].setFirstName(studentData[i][1]);
            studentList[i].setLastName(studentData[i][2]);
            studentList[i].setEmail(studentData[i][3]);
            studentList[i].setResponses(responseList(studentData));
        } 
    }

    private ArrayList<String> responseList(String[][] responses){

        ArrayList<String> r = new ArrayList<String>();
        for(int i = 0; i < responses.length; i++){
            for(int j = 0; j < responses[i].length; j++){
                if(responses[i][j].contains(";")){

                }
            }
        }
        return r;
    }

    public void printArray(String[][] arr){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr[i].length-1; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
