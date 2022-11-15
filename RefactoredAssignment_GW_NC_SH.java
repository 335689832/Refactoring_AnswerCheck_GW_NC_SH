
class RefactoredAssignment_GW_NC_SH{
    public static void main(String[] args){
        String[][] arr = StudentData.scanStudent();

        Chain test = new ResponseData();

        Files request = new Files("GW_ArrayAssignment/data/response_data/student_data_q1_response.csv", "", "");
        test.process(request);
    }
}