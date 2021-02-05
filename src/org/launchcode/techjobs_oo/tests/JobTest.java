package org.launchcode.techjobs_oo.tests;

import org.junit.*;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;

public class JobTest {
    private static Job test_jobWithIdConstructorOne;
    private static Job test_jobWithIdConstructorTwo;
    private static Job test_jobWithFullConstructorOne;
    private static Job test_jobWithFullConstructorTwo;
    private static Job test_jobWithEmptyProperties;

    @BeforeClass
    public static void createJobObjects() {
    test_jobWithIdConstructorOne = new Job();
    test_jobWithIdConstructorTwo = new Job();

    test_jobWithFullConstructorOne = new Job("Product tester",
            new Employer("ACME"),
            new Location("Desert"),
            new PositionType("Quality control"),
            new CoreCompetency("Persistence"));
    test_jobWithFullConstructorTwo = new Job("Product tester",
            new Employer("ACME"),
            new Location("Desert"),
            new PositionType("Quality control"),
            new CoreCompetency("Persistence"));

    test_jobWithEmptyProperties = new Job("",
            new Employer(""),
            new Location(""),
            new PositionType(""),
            new CoreCompetency(""));

}

    @Test
    public void testSettingJobId() {
        int idOne = test_jobWithIdConstructorOne.getId();
        int idTwo = test_jobWithIdConstructorTwo.getId();
        assertNotEquals(idOne, idTwo);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        String name = test_jobWithFullConstructorOne.getName();
        Employer employer = test_jobWithFullConstructorOne.getEmployer();
        Location location = test_jobWithFullConstructorOne.getLocation();
        PositionType positionType = test_jobWithFullConstructorOne.getPositionType();
        CoreCompetency coreCompetency = test_jobWithFullConstructorOne.getCoreCompetency();

        assertEquals("Product tester", name);

        assertTrue(employer instanceof Employer);
        assertEquals("ACME", employer.getValue());

        assertTrue(location instanceof Location);
        assertEquals("Desert", location.getValue());

        assertTrue(positionType instanceof PositionType);
        assertEquals("Quality control", positionType.getValue());

        assertTrue(coreCompetency instanceof CoreCompetency);
        assertEquals("Persistence", coreCompetency.getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(test_jobWithFullConstructorOne.equals(test_jobWithFullConstructorTwo));
    }

    @Test
    public void shouldPrintNewLineAtBeginningAndEndOfInfo() {
        assertTrue(test_jobWithFullConstructorOne.toString().startsWith("\n"));
        assertTrue(test_jobWithFullConstructorOne.toString().endsWith("\n"));
    }

    @Test
    public void toStringShouldPrintEachPropertyOnSeparateLine() {
        String expected = """
                
                ID: 3                
                Name: Product tester
                Employer: ACME
                Location: Desert
                Position Type: Quality control
                Core Competency: Persistence
                """;
        String actual = test_jobWithFullConstructorOne.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void returnsDataNotAvailableOnEmptyField() {
        String expected = """
                
                ID: 5                
                Name: Data not available
                Employer: Data not available
                Location: Data not available
                Position Type: Data not available
                Core Competency: Data not available
                """;
        String actual = test_jobWithEmptyProperties.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void returnsErrorIfOnlyID() {
        String actual = test_jobWithIdConstructorOne.toString();
        assertEquals("OOPS! This job does not seem to exist.", actual);
    }
}
