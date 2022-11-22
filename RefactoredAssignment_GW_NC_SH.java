import java.util.Scanner;

class RefactoredAssignment_GW_NC_SH{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Asks user to enter file path that contains student data
        System.out.println("Please enter the file path to the student data.");
        String studentFile = sc.nextLine();
        StudentData.scanStudent(studentFile);

        // Creatse student object for each student
        ResponseData studentObject = new ResponseData();
        System.out.println("Enter the student response array file: ");
        String responseFile = sc.nextLine();
        Student[] studentResponses = studentObject.process(responseFile);

        // Asks user for file path to answer data
        System.out.println("Please enter the file path to the answer data.\nType 'n/a' is you do not want to input answer data");
        String answerFile = sc.nextLine();

        // Asks user for file path to question data
        System.out.println("Please enter the file path to the question data.\nType 'n/a' is you do not want to input question data");
        String questionFile = sc.nextLine();

        //GW_ArrayAssignment/data/student_data/student_data_1.csv
        //GW_ArrayAssignment/data/response_data/student_data_q1_response.csv
        //GW_ArrayAssignment/data/answer_data/sample_a_1.txt

        // Creates request
        Files request = new Files(answerFile, questionFile);
        
        // Set up chain for answer data and question data
        Chain answer = new AnswerData();
        Chain question = new QuestionData();

        // Setup and starts Chain
        answer.setNext(question);
        answer.process(request);

        // Name of file data will be written to and stored in
        System.out.println("Please enter the name of the file you'd like to store the data in. \nNote: If you type an already existing file path in, the current file will override it.");
        String scoreFile = sc.nextLine();
        
        // Compares student responses to answer file
        CompareData.process(studentResponses, answer.getArrayList(), scoreFile);

        // Compares student responses to question file (question file will turn into answer file later)
        CompareData.process(studentResponses, question.getArrayList(), scoreFile);

        sc.close();
    }
}