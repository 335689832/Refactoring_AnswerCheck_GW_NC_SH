
class RefactoredAssignment_GW_NC_SH{
    public static void main(String[] args){
        // String[][] arr = StudentData.scanStudent();

        // ResponseData.printArray(arr);

        Chain test = new ResponseData();
        Chain test2 = new AnswerData();
        Chain test3 = new QuestionData();

        Files request = new Files("GW_ArrayAssignment/data/response_data/student_data_q1_response.csv", "GW_ArrayAssignment/data/answer_data/sample_a_1.txt", "");

        test.setNext(test2);
        test2.setNext(test3);
        

        test.process(request);
    }
}