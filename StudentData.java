public class StudentData extends PopulateArray{
    public static String[][] scanStudent(String fileName){
        //Populate the array and return it
        String[][] studentArr2D = (populateArray(fileName, false, ","));
        return studentArr2D;
    }

}
