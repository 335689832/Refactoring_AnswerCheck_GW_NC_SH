public class ResponseData implements Chain {

    private Chain nextInChain;

    public void setNext(Chain nextChain){

        this.nextInChain = nextChain;
    }   
    
    public void process(Files request){
        String[][] rData = StudentData.populateArray(request.getRData(), true, ",");
        printArray(rData);
    }

    public void printArray(String[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
