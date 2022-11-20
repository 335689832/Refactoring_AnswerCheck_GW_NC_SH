public class Files {
    private String answerData;
    private String questionData;

    public Files(String aData, String qData){
        answerData = aData;
        questionData = qData;
    }
    public String getAData(){ 
        return answerData; 
    }
    public String getQData(){ 
        return questionData; 
    }
}
