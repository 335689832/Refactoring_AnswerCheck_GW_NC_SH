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
    void setFirstName(String first){
        this.firstName = first;
    }

    void setLastName(String last){
        this.lastName = last;
    }

    void setEmail(String e){
        this.email = e;
    }

    void setResponses(ArrayList<String> res){
        this.responses = res;
    }

    void setStudentNumber(String num){
        this.studentNumber = num;
    }

    void setScore(int s){
        this.score = s;
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
