import java.util.*;

public class CompareData{
    
    public static void process(Student[] studentList, ArrayList<String> answerList){
        if (!(answerList == null)){
<<<<<<< HEAD
            for(int i = 0; i < studentList.length; i++){
=======
            Scanner sc = new Scanner(System.in);
            //filename to be written into
            System.out.println("Please enter the name of the file you'd like to store the data in. \nNote: If you type an already existing file path in, the current file will override it.");
            String fName = sc.nextLine();
            for(int i = 1; i < studentList.length; i++){
>>>>>>> parent of 428398b (Revert "Cringe")
                int score = 0;
                for(int j = 0; j < studentList[i].getResponses().size(); j++){
                    ArrayList<String> studentResponse = studentList[i].getResponses();
                    if(compareAnswers(answerList.get(j), studentResponse.get(j))){
                        score++;
                    }   
                }
                studentList[i].setScore(score);
<<<<<<< HEAD
                System.out.println(score);
            }
=======
                int amount = answerList.size();
                FileWrite.writeScore(studentList, amount, fName);
            }
            System.out.println("Program complete, please check file " + fName + " for results.");
            sc.close();
>>>>>>> parent of 428398b (Revert "Cringe")
        }
    }

    public static boolean compareAnswers(String answer, String response){
        if(answer.equals(response)){
            return true;
        }
        else{
            return false;
        }
    }
}
