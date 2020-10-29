import java.util.HashMap;
import uk.ac.uos.i2p.assignment.*;

public class MainClass {
    public static void Main(){
        HashMap<String, String> StudentList = new HashMap<String, String>();
        StudentList.put("Clint Eastwood", "S101");
        StudentList.put("Jamie Foxx", "S102");
        StudentList.put("Olivia Wilde", "S103");

        ContactTracingImpl test = new ContactTracingImpl();
        test.loadStudentList(StudentList);
    }
}
