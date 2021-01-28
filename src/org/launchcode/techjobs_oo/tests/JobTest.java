package org.launchcode.techjobs_oo.tests;

import org.junit.*;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;

public class JobTest {
    private Job test_jobWithIdConstructorOne;
    private Job test_jobWithIdConstructorTwo;
    private Job test_jobWithFullConstructorOne;
    private Job test_jobWithFullConstructorTwo;

    @Before
    public void createJobObjects() {
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
}
