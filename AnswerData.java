import java.util.*;

public class AnswerData implements Chain{

    private Chain nextInChain;

    private ArrayList<String> answerArrayList;

    public void setNext(Chain nextChain){

        this.nextInChain = nextChain;
    }

    public void process(Files request){
        if(!(request.getAData().equals("n/a"))){
            String[][] aData = StudentData.populateArray(request.getAData(), true, ",");
            answerArrayList = storeAnswers(aData);
            for (int i = 0; i < answerArrayList.size(); i++){
                System.out.println(answerArrayList.get(i));
            }
        }
        else{
            nextInChain.process(request);
        }
    }

    private static ArrayList<String> storeAnswers(String[][] answers){
        ArrayList<String> a = new ArrayList<String>();
        for (int i = 0; i < answers.length; i++){
            for (int j = 0; j < answers[i].length; j++){
                if (answers[i][j].contains("=") || answers[i][j].contains("/")){
                    a.add(answers[i][j]);
                }
            }
        }
        return a;
    }

    public ArrayList<String> get(){
        return answerArrayList;
    }

}
    