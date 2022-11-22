import java.util.*;

public class QuestionData extends PopulateArray implements Chain {
    
    private ArrayList<String> questionData;

    // Sets next in chain
    public void setNext(Chain nextChain){
    }   

    /**
     * Takes in request to process
     * 
     * Process
     * Solves questions using system of equations
     * Returns ArrayList of solved questions
     */
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

    /**
     * Getter for question ArrayList
     */
    public ArrayList<String> getArrayList(){
        return questionData;
    }
}
