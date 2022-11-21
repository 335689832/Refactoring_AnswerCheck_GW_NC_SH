import java.util.*;

public class CompareData{
    
    public static void process(Student[] studentList, ArrayList<String> answerList){
        if (!(answerList == null)){
            for(int i = 1; i < studentList.length; i++){
                int score = 0;
                for(int j = 0; j < studentList[i].getResponses().size(); j++){
                    ArrayList<String> studentResponse = studentList[i].getResponses();
                    if(compareAnswers(answerList.get(j), studentResponse.get(j))){
                        score++;
                    }   
                }
                studentList[i].setScore(score);
                String name = studentList[i].getFirstName();
                int amount = answerList.size();
                System.out.println(name + " scored " + score + "/" + amount);
            }
            sc.close();
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
