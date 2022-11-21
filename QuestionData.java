import java.util.*;

public class QuestionData implements Chain {
    private Chain nextInChain;
    
    private ArrayList<String> questionData;

    public void setNext(Chain nextChain){

        this.nextInChain = nextChain;
    }   

    public void process(Files request){
        if((request.getAData().equals("n/a"))){
            
        }
        else{
            System.out.println("File invalid");
        }
    }

    public ArrayList<String> getArrayList(){
        return questionData;
    }
}
