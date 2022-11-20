import java.util.*;

public class ResponseData implements Chain {

    private Chain nextInChain;

    public Student[] studentList;

    public void setNext(Chain nextChain){

        this.nextInChain = nextChain;
    }   
    
    public void process(Files request){
        String[][] rData = StudentData.populateArray(request.getRData(), true, ",");
        Student[] studentList = createStudentList(rData);
        for(int i = 0; i < studentList.length;i++){
            System.out.println(studentList[i].getResponses());
        }
    }

    private Student[] createStudentList(String[][] studentData){
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

    private ArrayList<String> responseList(String[][] responses, int index){

        ArrayList<String> r = new ArrayList<String>();

            for(int j = 0; j < responses[index].length; j++){
                if(responses[index][j].contains("=") || responses[index][j].contains("/")){
                    r.add(responses[index][j]);
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

    public void printArrayList(ArrayList<String> arr){
        for(int i = 0; i < arr.size()-1; i++){
            System.out.println(arr.get(i));
        }
    }

    public Student[] getStudentList(){
        return studentList;
    }

}
