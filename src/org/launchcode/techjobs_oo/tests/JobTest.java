package org.launchcode.techjobs_oo.tests;

import org.junit.*;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;

public class JobTest {
    private static Job testJobWithIdConstructorOne;
    private static Job testJobWithIdConstructorTwo;
    private static Job testJobWithFullConstructorOne;
    private static Job testJobWithFullConstructorTwo;
    private static Job testJobWithSomeEmptyProperties;
    private static Job testJobWithAllEmptyProperties;

    @BeforeClass
    public static void createJobObjects() {
    testJobWithIdConstructorOne = new Job();
    testJobWithIdConstructorTwo = new Job();

    testJobWithFullConstructorOne = new Job("Product tester",
            new Employer("ACME"),
            new Location("Desert"),
            new PositionType("Quality control"),
            new CoreCompetency("Persistence"));
    testJobWithFullConstructorTwo = new Job("Product tester",
            new Employer("ACME"),
            new Location("Desert"),
            new PositionType("Quality control"),
            new CoreCompetency("Persistence"));

    testJobWithSomeEmptyProperties = new Job("Test Job",
            new Employer(""),
            new Location(""),
            new PositionType("Unknown Test"),
            new CoreCompetency("Who Really Knows?"));

        testJobWithAllEmptyProperties = new Job("",
                new Employer(""),
                new Location(""),
                new PositionType(""),
                new CoreCompetency(""));

}

    @Test
    public void testSettingJobId() {
        int idOne = testJobWithIdConstructorOne.getId();
        int idTwo = testJobWithIdConstructorTwo.getId();
        assertNotEquals(idOne, idTwo);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        String name = testJobWithFullConstructorOne.getName();
        Employer employer = testJobWithFullConstructorOne.getEmployer();
        Location location = testJobWithFullConstructorOne.getLocation();
        PositionType positionType = testJobWithFullConstructorOne.getPositionType();
        CoreCompetency coreCompetency = testJobWithFullConstructorOne.getCoreCompetency();

        assertEquals("Product tester", name);
        assertEquals("ACME", employer.getValue());
        assertEquals("Desert", location.getValue());
        assertEquals("Quality control", positionType.getValue());
        assertEquals("Persistence", coreCompetency.getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(testJobWithFullConstructorOne.equals(testJobWithFullConstructorTwo));
    }

    @Test
    public void shouldPrintNewLineAtBeginningAndEndOfInfo() {
        assertTrue(testJobWithFullConstructorOne.toString().startsWith("\n"));
        assertTrue(testJobWithFullConstructorOne.toString().endsWith("\n"));
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
        String actual = testJobWithFullConstructorOne.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void returnsDataNotAvailableOnEmptyField() {
        String expected = """
                
                ID: 5                
                Name: Test Job
                Employer: Data not available
                Location: Data not available
                Position Type: Unknown Test
                Core Competency: Who Really Knows?
                """;
        String actual = testJobWithSomeEmptyProperties.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void returnsErrorIfOnlyIDAndNullFields() {
        String actual = testJobWithIdConstructorOne.toString();
        assertEquals("OOPS! This job does not seem to exist.", actual);
    }

    @Test
    public void returnsErrorIfOnlyIDAndEmptyStringFields() {
        String actual = testJobWithAllEmptyProperties.toString();
        assertEquals("OOPS! This job does not seem to exist.", actual);
    }
}
