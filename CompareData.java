import java.lang.reflect.Array;
import java.util.*;

public class CompareData implements Chain{
    private Chain nextInChain;

    public void setNext(Chain nextChain){

        this.nextInChain = nextChain;
    }   

    public void process(Files request){

        ResponseData r = new ResponseData();
        AnswerData a = new AnswerData();

        Student[] studentList = r.getStudentList();
        ArrayList<String> answerList = a.getAnswerList();

        for(int i = 0; i < studentList.length; i++){
            int score = 0;
            for(int j = 0; j < studentList[i].getResponses().size(); j++){
                ArrayList<String> studentResponse = studentList[i].getResponses();
                if(compareAnswers(answerList.get(j), studentResponse.get(j))){
                    score++;
                }   
            }
            studentList[i].setScore(score);
            System.out.println(score);
        }
    }

    public boolean compareAnswers(String answer, String response){
        if(answer.equals(response)){
            return true;
        }
        else{
            return false;
        }
    }
}
