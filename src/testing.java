import org.junit.jupiter.api.Test;
import uk.ac.uos.i2p.assignment.ContactTracingImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testing {
    @Test
    public void testFindMatchingCourses(){
        ContactTracingImpl ContactTracingObject = MainClass.loadData();
        assertEquals("SE01", ContactTracingObject.findMatchingCourses("S101").get(0));
    }

    @Test
    public void testFindMatchingStudents(){
        List<String> courseList = new ArrayList<String>();
        courseList.add("SE01");

        List<String> expectedOutcome = new ArrayList<String>();
        expectedOutcome.add("S109");
        expectedOutcome.add("S106");
        expectedOutcome.add("S107");
        expectedOutcome.add("S104");
        expectedOutcome.add("S103");
        expectedOutcome.add("S101");

        ContactTracingImpl ContactTracingObject = MainClass.loadData();
        assertEquals(expectedOutcome, ContactTracingObject.findMatchingStudents(courseList));
    }
    @Test
    public void testContactTracing(){
        ContactTracingImpl ContactTracingObject = MainClass.loadData();

        List<String> expectedOutcome = new ArrayList<String>();
        expectedOutcome.add("tmc@uos.ac.uk");
        expectedOutcome.add("kkm@uos.ac.uk");
        expectedOutcome.add("tls@uos.ac.uk");
        expectedOutcome.add("bdp@uos.ac.uk");
        expectedOutcome.add("klm@uos.ac.uk");

        assertEquals(expectedOutcome, ContactTracingObject.contactTracing("S101"));
    }
}
