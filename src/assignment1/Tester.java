/*
 * Student Name: Boris Gueye
 * Lab Professor: Leanne Seaward
 * Due Date: 02/27/2026
 * Modified: 02/18/2026
 * Description: This program collects driver's license information 
 * from the user and displays a license report using the DriversLicense class.
 */

package assignment1;

import java.util.Scanner;
import java.time.LocalDate;

/**
 * Tester class for the DriversLicense class.
 * Collects user input via Scanner to populate a DriversLicense object
 * and prints a formatted license report.
 * 
 * @author Boris Gueye
 */

public class Tester {

    /**
     * Main method. Prompts the user to enter all driver's license details
     * via the console, sets them on a DriversLicense object, and prints
     * a formatted license report.
     * 
     * @param args Command line arguments are not used by this program.
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        DriversLicense license1 = new DriversLicense();

        System.out.print("Enter your last name: ");
        license1.setLastName(scnr.nextLine());

        System.out.print("Enter your first name: ");
        license1.setFirstName(scnr.nextLine());

        System.out.print("Enter your address: ");
        license1.setAddress(scnr.nextLine());

        System.out.print("Enter your city: ");
        license1.setCity(scnr.nextLine());

        System.out.print("Enter your province: ");
        license1.setProvince(scnr.nextLine());

        System.out.print("Enter your postal code: ");
        license1.setPostalCode(scnr.nextLine());

        System.out.print("Enter your license number: ");
        license1.setLicenseNumber(scnr.nextLine());

        System.out.print("Enter your license class: ");
        license1.setLicenseClass(scnr.nextLine());

        System.out.print("Enter your restrictions: ");
        license1.setRestrictions(scnr.nextLine());

        System.out.print("Enter your reference number: ");
        license1.setReferenceNumber(scnr.nextLine());

        System.out.print("Enter your height in cm: ");
        license1.setHeight(scnr.nextInt());

        System.out.print("Enter your sex (M/F): ");
        license1.setSex(scnr.next().charAt(0));

        System.out.print("Enter your date of birth (YYYY-MM-DD): ");
        license1.setDateOfBirth(LocalDate.parse(scnr.next()));

        System.out.print("Enter your date of issue (YYYY-MM-DD): ");
        license1.setDateOfIssue(LocalDate.parse(scnr.next()));

        System.out.print("Enter your expiry date (YYYY-MM-DD): ");
        license1.setExpiryDate(LocalDate.parse(scnr.next()));

        System.out.println(license1.printLicenseReport());

        scnr.close();
    }
}