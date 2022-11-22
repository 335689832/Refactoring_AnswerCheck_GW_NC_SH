public class Files {
    private String answerData;
    private String questionData;

    /**
     * Create files object
     * @param aData answer data
     * @param qData question data
     */
    public Files(String aData, String qData){
        answerData = aData;
        questionData = qData;
    }

    // Getter for answer data
    public String getAData(){ 
        return answerData; 
    }

    // Getter for question data
    public String getQData(){ 
        return questionData; 
    }
}
