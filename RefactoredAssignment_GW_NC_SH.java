
class RefactoredAssignment_GW_NC_SH{
    public static void main(String[] args){
        // String[][] arr = StudentData.scanStudent();

        ResponseData.process();

        //GW_ArrayAssignment/data/response_data/student_data_q1_response.csv
        //GW_ArrayAssignment/data/answer_data/sample_a_1.txt
        Files request = new Files("n/a", "");
        
        Chain answer = new AnswerData();
        Chain question = new QuestionData();

        answer.setNext(question);

        answer.process(request);
    }
}