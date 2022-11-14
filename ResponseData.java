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
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr[i].length-1; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
