import java.util.*;

public class ResponseData{

    public static Student[] studentList;
    
    public static void process(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student response array file: ");
        String file = sc.nextLine();
        String[][] rData = StudentData.populateArray(file, true, ",");
        Student[] studentList = createStudentList(rData);
        for(int i = 0; i < studentList.length;i++){
            System.out.println(studentList[i].getResponses());
        }
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

    public Student[] getStudentList(){
        return studentList;
    }

}
