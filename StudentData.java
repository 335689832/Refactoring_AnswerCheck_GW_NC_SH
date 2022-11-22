public class StudentData extends PopulateArray{
    /**
     * Scans file and populates array called "studentArr2D"
     * @param fileName Name of file that it takes data from
     * @return 2D Array populated with data
     */

    public static String[][] scanStudent(String fileName){
        //Populate the array and return it
        String[][] studentArr2D = (populateArray(fileName, false, ","));
        return studentArr2D;
    }

}
