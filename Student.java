import java.util.*;

class Student {

    //Attributes
    String firstName;
    String lastName;
    String email;
    ArrayList<String> responses;
    String studentNumber;
    int score;

    //Constructor
    public Student(){
        this.score = 0;
    }

    //Setters
    void setFirstName(String newFirst){
        this.firstName = newFirst;
    }

    void setLastName(String newLast){
        this.lastName = newLast;
    }

    void setEmail(String newEmail){
        this.email = newEmail;
    }

    void setResponses(ArrayList<String> newResponse){
        this.responses = newResponse;
    }

    void setStudentNumber(String newNum){
        this.studentNumber = newNum;
    }

    void setScore(int newScore){
        this.score = newScore;
    }

    //Getters
    String getFirstName(){
        return firstName;
    }

    String getLastName(){
        return lastName;
    }

    String getEmail(){
        return email;
    }

    ArrayList<String> getResponses(){
        return responses;
    }

    String getStudentNumber(){
        return studentNumber;
    }

    int getScore(){
        return score;
    }

}
