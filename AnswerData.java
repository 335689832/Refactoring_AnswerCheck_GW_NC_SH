import java.util.*;

public class AnswerData extends PopulateArray implements Chain {

    private Chain nextInChain;

    private ArrayList<String> answerArrayList;

    // Sets next in chain
    public void setNext(Chain nextChain){
        this.nextInChain = nextChain;
    }

    /**
     * Takes in request to process
     * Process -> Stores and prints out answer data inside ArrayList
     */
    public void process(Files request){
        if(!(request.getAData().equals("n/a"))){
            String[][] answer2D = populateArray(request.getAData(), true, ",");
            answerArrayList = storeAnswers(answer2D);
            for (int i = 0; i < answerArrayList.size(); i++){
                System.out.println(answerArrayList.get(i));
            }
        }
        else{
            nextInChain.process(request);
        }
    }

    /**
     * Stores answers into ArrayList
     * @param arr2D Takes 2D Array and converts into ArrayList
     * @return Completed ArrayList
     */
    public static ArrayList<String> storeAnswers(String[][] arr2D){
        ArrayList<String> a = new ArrayList<String>();
        for (int i = 0; i < arr2D.length; i++){
            for (int j = 0; j < arr2D[i].length; j++){
                if (arr2D[i][j].contains("=") || arr2D[i][j].contains("/")){
                    a.add(arr2D[i][j]);
                }
            }
        }
        return a;
    }

    /**
     * Getter for answer ArrayList
     */
    public ArrayList<String> getArrayList(){
        return answerArrayList;
    }

}
    