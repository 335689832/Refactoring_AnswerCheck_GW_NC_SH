public class QuestionData implements Chain {
    private Chain nextInChain;

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
}
