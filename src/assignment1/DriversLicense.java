/*
 * Student Name: Boris Gueye
 * Lab Professor: Leanne Seaward
 * Due Date: 02/27/2026
 * Modified: 02/18/2026
 * Description: This program  stores all relevant license data 
 * and provides methods to compute license-related information.
 */

package assignment1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Represents an Ontario Driver's License.
 * This class stores all relevant license data and provides methods
 * to compute license-related information such as days to expiry,
 * driver age and height conversion.
 * 
 * @author Boris Gueye
 */

public class DriversLicense {

    /** The last name of the license holder. */
    private String lastName;

    /** The first name of the license holder. */
    private String firstName;

    /** The street address of the license holder. */
    private String address;

    /** The city of the license holder. */
    private String city;

    /** The province of the license holder. */
    private String province;

    /** The postal code of the license holder. */
    private String postalCode;

    /** The unique license number assigned to the license holder. */
    private String licenseNumber;

    /** The date the license was issued. */
    private LocalDate dateOfIssue;

    /** The date the license expires. */
    private LocalDate expiryDate;

    /** The document reference number on the license. */
    private String referenceNumber;

    /** The height of the license holder in centimeters. */
    private int height;

    /** The sex of the license holder (M or F). */
    private char sex;

    /** The class of the driver's license (e.g. G, G1, G2). */
    private String licenseClass;

    /** Any restrictions on the license (e.g. corrective lenses). Default is "None". */
    private String restrictions;

    /** The date of birth of the license holder. */
    private LocalDate dateOfBirth;

    /**
     * The No-arg constructor creates a DriversLicense with default values
     * based on the fictional character Arthur Leywin from The Beginning After The End.
     * Date of birth defaults to 30 years before the current system date.
     * Date of issue defaults to the current system date.
     * Expiry date defaults to 5 years after the current system date.
     */
    public DriversLicense() {
        this("Leywin", "Arthur", "1 Xyrus Academy Road", "Toronto", "ON", "N1N 1N1",
                "Z00000000", LocalDate.now(), LocalDate.now().plusYears(5),
                "AA0000000", 175, 'M', "G", "None", LocalDate.now().minusYears(30));
    }

    /**
     * The partial constructor creates a DriversLicense with personal details provided
     * and all other fields set to default values.
     * Date of issue defaults to the current system date.
     * Expiry date defaults to 5 years after the current system date.
     * License class defaults to "G" and restrictions default to "None".
     * 
     * @param lastName    the last name of the license holder
     * @param firstName   the first name of the license holder
     * @param sex         the sex of the license holder
     * @param dateOfBirth the date of birth of the license holder
     * @param height      the height of the license holder in centimeters
     * @param address     the street address of the license holder
     * @param city        the city of the license holder
     * @param province    the province of the license holder
     * @param postalCode  the postal code of the license holder
     */
    public DriversLicense(String lastName, String firstName, char sex, LocalDate dateOfBirth,
            int height, String address, String city, String province, String postalCode) {
        this(lastName, firstName, address, city, province, postalCode,
                "Z00000000", LocalDate.now(), LocalDate.now().plusYears(5),
                "AA0000000", height, sex, "G", "None", dateOfBirth);
    }

    /**
     * Full constructor. Creates a DriversLicense with all fields specified.
     * All other constructors chain to this constructor.
     * 
     * @param lastName        the last name of the license holder
     * @param firstName       the first name of the license holder
     * @param address         the street address of the license holder
     * @param city            the city of the license holder
     * @param province        the province of the license holder
     * @param postalCode      the postal code of the license holder
     * @param licenseNumber   the unique license number
     * @param dateOfIssue     the date the license was issued
     * @param expiryDate      the date the license expires
     * @param referenceNumber the document reference number
     * @param height          the height of the license holder in centimeters
     * @param sex             the sex of the license holder
     * @param licenseClass    the class of the driver's license (e.
     * @param restrictions    any restrictions on the license
     * @param dateOfBirth     the date of birth of the license holder
     */
    public DriversLicense(String lastName, String firstName, String address, String city,
            String province, String postalCode, String licenseNumber, LocalDate dateOfIssue,
            LocalDate expiryDate, String referenceNumber, int height, char sex,
            String licenseClass, String restrictions, LocalDate dateOfBirth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.licenseNumber = licenseNumber;
        this.dateOfIssue = dateOfIssue;
        this.expiryDate = expiryDate;
        this.referenceNumber = referenceNumber;
        this.height = height;
        this.sex = sex;
        this.licenseClass = licenseClass;
        this.restrictions = restrictions;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Computes the number of days until the license expires.
     * Returns a positive number if the license is still valid,
     * 0 if it expires today, and a negative number if already expired.
     * 
     * @return the number of days until the license expires
     */
    public int computeDaysToExpiry() {
        return (int) ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
    }

    /**
     * Computes the current age of the license holder in years
     * based on the system date and the date of birth.
     * 
     * @return the age of the license holder in years
     */
    public int computeDriverAge() {
        return (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }

    /**
     * Computes the number of days since the license was issued
     * based on the system date and the date of issue.
     * 
     * @return the number of days since the license was issued
     */
    public int computeDaysSinceIssue() {
        return (int) ChronoUnit.DAYS.between(dateOfIssue, LocalDate.now());
    }

    /**
     * Computes the number of years since the license was issued
     * based on the system date and the date of issue.
     * 
     * @return the number of years since the license was issued as a double
     */
    public double computeYearsSinceIssue() {
        return (double) ChronoUnit.YEARS.between(dateOfIssue, LocalDate.now());
    }

    /**
     * Converts the license holder's height from centimeters to inches.
     * 
     * @return the height of the license holder in inches
     */
    public double computeHeightInInches() {
        return height / 2.54;
    }

    /**
     * Generates a formatted report of all license details including
     * personal information, license information, and computed values.
     * 
     * @return a formatted String containing all license details and computed values
     */
    public String printLicenseReport() {
        return String.format(
                "%-20s %s, %s%n" +
                "%-20s %s%n" +
                "%-20s %s, %s, %s%n" +
                "%-20s %s%n" +
                "%-20s %s%n" +
                "%-20s %s%n" +
                "%-20s %s%n" +
                "%-20s %c%n" +
                "%-20s %s%n" +
                "%-20s %s%n" +
                "%-20s %d cm (%.1f inches)%n" +
                "%-20s %s%n" +
                "%-20s %d days%n" +
                "%-20s %d years%n" +
                "%-20s %d days%n" +
                "%-20s %.1f years%n",
                "Name:", lastName, firstName,
                "License Number:", licenseNumber,
                "Address:", address, city, province,
                "Postal Code:", postalCode,
                "Date of Birth:", dateOfBirth,
                "Date of Issue:", dateOfIssue,
                "Expiry Date:", expiryDate,
                "Sex:", sex,
                "License Class:", licenseClass,
                "Restrictions:", restrictions,
                "Height:", height, computeHeightInInches(),
                "Reference Number:", referenceNumber,
                "Days to Expiry:", computeDaysToExpiry(),
                "Driver Age:", computeDriverAge(),
                "Days Since Issue:", computeDaysSinceIssue(),
                "Years Since Issue:", computeYearsSinceIssue()
        );
    }

    /**
     * Returns the last name of the license holder.
     * @return the last name
     */
    public String getLastName() { return lastName; }

    /**
     * Returns the first name of the license holder.
     * @return the first name
     */
    public String getFirstName() { return firstName; }

    /**
     * Returns the street address of the license holder.
     * @return the address
     */
    public String getAddress() { return address; }

    /**
     * Returns the city of the license holder.
     * @return the city
     */
    public String getCity() { return city; }

    /**
     * Returns the province of the license holder.
     * @return the province
     */
    public String getProvince() { return province; }

    /**
     * Returns the postal code of the license holder.
     * @return the postal code
     */
    public String getPostalCode() { return postalCode; }

    /**
     * Returns the license number.
     * @return the license number
     */
    public String getLicenseNumber() { return licenseNumber; }

    /**
     * Returns the date of issue of the license.
     * @return the date of issue
     */
    public LocalDate getDateOfIssue() { return dateOfIssue; }

    /**
     * Returns the expiry date of the license.
     * @return the expiry date
     */
    public LocalDate getExpiryDate() { return expiryDate; }

    /**
     * Returns the document reference number.
     * @return the reference number
     */
    public String getReferenceNumber() { return referenceNumber; }

    /**
     * Returns the height of the license holder in centimeters.
     * @return the height in centimeters
     */
    public int getHeight() { return height; }

    /**
     * Returns the sex of the license holder.
     * @return the sex
     */
    public char getSex() { return sex; }

    /**
     * Returns the class of the driver's license.
     * @return the license class
     */
    public String getLicenseClass() { return licenseClass; }

    /**
     * Returns any restrictions on the license.
     * @return the restrictions
     */
    public String getRestrictions() { return restrictions; }

    /**
     * Returns the date of birth of the license holder.
     * @return the date of birth
     */
    public LocalDate getDateOfBirth() { return dateOfBirth; }

    /**
     * Sets the last name of the license holder.
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * Sets the first name of the license holder.
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /**
     * Sets the street address of the license holder.
     * @param address the address to set
     */
    public void setAddress(String address) { this.address = address; }

    /**
     * Sets the city of the license holder.
     * @param city the city to set
     */
    public void setCity(String city) { this.city = city; }

    /**
     * Sets the province of the license holder.
     * @param province the province to set
     */
    public void setProvince(String province) { this.province = province; }

    /**
     * Sets the postal code of the license holder.
     * @param postalCode the postal code to set
     */
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    /**
     * Sets the license number.
     * @param licenseNumber the license number to set
     */
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    /**
     * Sets the date of issue of the license.
     * @param dateOfIssue the date of issue to set
     */
    public void setDateOfIssue(LocalDate dateOfIssue) { this.dateOfIssue = dateOfIssue; }

    /**
     * Sets the expiry date of the license.
     * @param expiryDate the expiry date to set
     */
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    /**
     * Sets the document reference number.
     * @param referenceNumber the reference number to set
     */
    public void setReferenceNumber(String referenceNumber) { this.referenceNumber = referenceNumber; }

    /**
     * Sets the height of the license holder in centimeters.
     * @param height the height in centimeters to set
     */
    public void setHeight(int height) { this.height = height; }

    /**
     * Sets the sex of the license holder.
     * @param sex the sex to set
     */
    public void setSex(char sex) { this.sex = sex; }

    /**
     * Sets the class of the driver's license.
     * @param licenseClass the license class to set
     */
    public void setLicenseClass(String licenseClass) { this.licenseClass = licenseClass; }

    /**
     * Sets any restrictions on the license.
     * @param restrictions the restrictions to set
     */
    public void setRestrictions(String restrictions) { this.restrictions = restrictions; }

    /**
     * Sets the date of birth of the license holder.
     * @param dateOfBirth the date of birth to set
     */
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

}