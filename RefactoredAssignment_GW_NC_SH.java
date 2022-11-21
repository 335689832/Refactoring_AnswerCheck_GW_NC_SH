import java.util.Scanner;

class RefactoredAssignment_GW_NC_SH{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // String[][] arr = StudentData.scanStudent();

        ResponseData responses = new ResponseData();
        Student[] studentResponses = responses.process();

        System.out.println("Please enter the file path to the answer data.\nType 'n/a' is you do not want to input answer data");
        String userAnswer = sc.nextLine();

        System.out.println("Please enter the file path to the question data.\nType 'n/a' is you do not want to input question data");
        String userQuestion = sc.nextLine();

        //GW_ArrayAssignment/data/response_data/student_data_q1_response.csv
        //GW_ArrayAssignment/data/answer_data/sample_a_1.txt

        Files request = new Files(userAnswer, userQuestion);
        
        Chain answer = new AnswerData();
        Chain question = new QuestionData();

        answer.setNext(question);
        answer.process(request);

        CompareData.process(studentResponses, answer.get());

        CompareData.process(studentResponses, question.get());

    }
}