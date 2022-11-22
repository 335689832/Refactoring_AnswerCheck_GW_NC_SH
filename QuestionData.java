import java.util.*;

public class QuestionData extends PopulateArray implements Chain {
    private Chain nextInChain;
    
    private ArrayList<String> questionData;

    public void setNext(Chain nextChain){

        this.nextInChain = nextChain;
    }   

    public void process(Files request){
        if((request.getAData().equals("n/a"))){
            String[][] question2D = populateArray(request.getQData(), true, ",");
            for(int i = 0; i < question2D.length; i++){
                String temp = "";
                for(int j = 0; j < question2D[i].length; j++){
                    if(question2D[i][j].contains("=")){
                        temp += question2D[i][j];
                    }
                }
                questionData.add(temp);
            }
        }
        else{
            System.out.println("File invalid");
        }
    }

    public ArrayList<String> getArrayList(){
        return questionData;
    }
}
