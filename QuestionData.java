import java.util.*;

public class QuestionData implements Chain {
    private Chain nextInChain;
    private ArrayList<String> questionData;

    public void setNext(Chain nextChain){

        this.nextInChain = nextChain;
    }   

    public void process(Files request){
        if((request.getAData().equals("n/a"))){
            System.out.println("Penis");
        }
        else{
            nextInChain.process(request);
        }
    }

    public ArrayList<String> get(){
        return questionData;
    }
}
