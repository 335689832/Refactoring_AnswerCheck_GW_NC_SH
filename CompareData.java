import java.util.*;

public class CompareData{
    
    /**
     * Takes in request to process
     * 
     * Process
     * @param studentList Student array
     * @param answerList Answers ArrayList 
     * @param fileName Name of file data being written to
     */
    public static void process(Student[] studentList, ArrayList<String> answerList, String fileName){
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
                int questionAmount = answerList.size();
                FileWrite.writeScore(studentList, questionAmount, fileName);
            }
            System.out.println("Program complete, please check file " + fileName + " for results.");
        }
    }

    /**
     * Compares answers and responses
     * @param answer answer String
     * @param response response String
     * @return returns true or false if answer equals to response
     */
    public static boolean compareAnswers(String answer, String response){
        if(answer.equals(response)){
            return true;
        }
        else{
            return false;
        }
    }
}
