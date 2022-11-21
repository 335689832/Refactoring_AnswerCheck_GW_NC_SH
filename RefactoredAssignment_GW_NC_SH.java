import java.util.Scanner;

class RefactoredAssignment_GW_NC_SH{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the file path to the student data.");
        String studentFile = sc.nextLine();
        StudentData.scanStudent(studentFile);

        ResponseData studentObject = new ResponseData();
        System.out.println("Enter the student response array file: ");
        String responseFile = sc.nextLine();
        Student[] studentResponses = studentObject.process(responseFile);

        System.out.println("Please enter the file path to the answer data.\nType 'n/a' is you do not want to input answer data");
        String answerFile = sc.nextLine();

        System.out.println("Please enter the file path to the question data.\nType 'n/a' is you do not want to input question data");
        String questionFile = sc.nextLine();

        //GW_ArrayAssignment/data/student_data/student_data_1.csv
        //GW_ArrayAssignment/data/response_data/student_data_q1_response.csv
        //GW_ArrayAssignment/data/answer_data/sample_a_1.txt

        Files request = new Files(answerFile, questionFile);
        
        Chain answer = new AnswerData();
        Chain question = new QuestionData();

        answer.setNext(question);
        answer.process(request);

        //filename to be written into
        System.out.println("Please enter the name of the file you'd like to store the data in. \nNote: If you type an already existing file path in, the current file will override it.");
        String scoreFile = sc.nextLine();
        
        CompareData.process(studentResponses, answer.getArrayList(), scoreFile);

        CompareData.process(studentResponses, question.getArrayList(), scoreFile);

        sc.close();
    }
}