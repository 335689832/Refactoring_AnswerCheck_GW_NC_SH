public class Files {
    private String responseData;
    private String answerData;
    private String questionData;

    public Files(String rData, String aData, String qData){

        responseData = rData;
        answerData = aData;
        questionData = qData;
    
    }

    public String getRData(){ 
        return responseData; 
    }
    public String getAData(){ 
        return answerData; 
    }
    public String getQData(){ 
        return questionData; 
    }
}
