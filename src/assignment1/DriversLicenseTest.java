/*
 * Student Name: Boris Gueye
 * Lab Professor: Leanne Seaward
 * Due Date: 02/27/2026
 * Modified: 02/18/2026
 * Description: This program creates test cases for the DriversLicense class.
 */

package assignment1;

import static org.junit.Assert.*;
import java.time.LocalDate;

import org.junit.Test;

public class DriversLicenseTest {
	
	private static final double EPSILON = 0.01;

	@Test
	public void testComputeDaysToExpiry_Today() {
		DriversLicense license = new DriversLicense();
        license.setExpiryDate(LocalDate.now());
        assertEquals(0, license.computeDaysToExpiry());
	}

	@Test
	public void testComputeDaysToExpiry_Tomorrow() {
		DriversLicense license = new DriversLicense();
        license.setExpiryDate(LocalDate.now().plusDays(1));
        assertEquals(1, license.computeDaysToExpiry());
	}
	
	@Test
	public void testComputeDaysToExpiry_Expired() {
		DriversLicense license = new DriversLicense();
        license.setExpiryDate(LocalDate.now().minusDays(23));
        assertEquals(-23, license.computeDaysToExpiry());
	}
	
	@Test
	public void testComputeDriverAge_ThirtyToday() {
		DriversLicense license = new DriversLicense();
		license.setDateOfBirth(LocalDate.now().minusYears(30));
		assertEquals(30, license.computeDriverAge());
	}
	
	@Test
	public void testComputeDriverAge_ThirtyTomorrow() {
		DriversLicense license = new DriversLicense();
		license.setDateOfBirth(LocalDate.now().minusYears(30).plusDays(1));
		assertEquals(29, license.computeDriverAge());
	}
	
	@Test
	public void testComputeDriverAge_ThirtyYesterday() {
		DriversLicense license = new DriversLicense();
		license.setDateOfBirth(LocalDate.now().minusYears(30).minusDays(1));
		assertEquals(30, license.computeDriverAge());
	}
	
	@Test
	public void testDaysSinceIssue_YearAgo() {
		DriversLicense license = new DriversLicense();
		license.setDateOfIssue(LocalDate.now().minusYears(1));
		assertEquals(365, license.computeDaysSinceIssue());
	}
	
	@Test
	public void testDaysSinceIssue_Today() {
		DriversLicense license = new DriversLicense();
		license.setDateOfIssue(LocalDate.now());
		assertEquals(0, license.computeDaysSinceIssue());
	}
	
	@Test
	public void testDaysSinceIssue_Yesterday() {
		DriversLicense license = new DriversLicense();
		license.setDateOfIssue(LocalDate.now().minusDays(1));
		assertEquals(1, license.computeDaysSinceIssue());
	}
	
	@Test
	public void testYearsSinceIssue_YearAgo() {
		DriversLicense license = new DriversLicense();
		license.setDateOfIssue(LocalDate.now().minusYears(1));
		assertEquals(1, license.computeYearsSinceIssue(), EPSILON);
	}
	
	@Test
	public void testYearsSinceIssue_Today() {
		DriversLicense license = new DriversLicense();
		license.setDateOfIssue(LocalDate.now());
		assertEquals(0, license.computeYearsSinceIssue(), EPSILON);
	}
	
	@Test
	public void testYearsSinceIssue_Yesterday() {
		DriversLicense license = new DriversLicense();
		license.setDateOfIssue(LocalDate.now().minusDays(1));
		assertEquals(0, license.computeYearsSinceIssue(), EPSILON);
	}
	
	@Test
	public void testHeightInInches_194cm() {
		DriversLicense license = new DriversLicense();
		license.setHeight(194);
		assertEquals(76.378, license.computeHeightInInches(), EPSILON);
	}
	
	@Test
	public void testHeightInInches_0cm() {
		DriversLicense license = new DriversLicense();
		license.setHeight(0);
		assertEquals(0.0, license.computeHeightInInches(), EPSILON);
	}
	
	@Test
	public void testHeightInInches_254cm() {
		DriversLicense license = new DriversLicense();
		license.setHeight(254);
		assertEquals(100, license.computeHeightInInches(), EPSILON);
		
	}
	
	@Test
	public void testPrintLicenseReport_ContainsDefaultLastName() {
		DriversLicense license = new DriversLicense();
		assertTrue(license.printLicenseReport().contains("Leywin"));
	}
	
	@Test
	public void testPrintLicenseReport_ContainsInputLastName() {
		DriversLicense license = new DriversLicense();
		license.setLastName("Gueye");
		assertTrue(license.printLicenseReport().contains("Gueye"));
	}
	
	@Test
	public void testPrintLicenseReport_ContainsLicenseClass() {
		DriversLicense license = new DriversLicense();
		license.setLicenseClass("G1");
		assertTrue(license.printLicenseReport().contains("G1"));
	}

}
