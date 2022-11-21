import java.util.Scanner;

public class StudentData extends PopulateArray{
    public static String[][] scanStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the file path to the student data.");
        String fName = sc.nextLine();
        //Populate the array and return it
        String[][] studentArr2D = (populateArray(fName, false, ","));
        return studentArr2D;
    }

}
