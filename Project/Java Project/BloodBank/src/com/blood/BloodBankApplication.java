package com.blood;

import com.blood.impl.DonorImpl;
import com.blood.impl.BloodDonorImpl;
import com.blood.impl.DonationImpl;
import com.blood.impl.BloodRequestImpl;
import com.blood.intf.DonorIntf;
import com.blood.intf.BloodDonorIntf;
import com.blood.intf.DonationIntf;
import com.blood.intf.BloodRequestIntf;
import com.blood.models.Donor;
import com.blood.models.BloodDonor;
import com.blood.models.Donation;
import com.blood.models.BloodRequest;

import java.util.Date;
import java.util.Scanner;

public class BloodBankApplication {

    public static void main(String[] args) {
        // Create service instances
        DonorIntf donorService = new DonorImpl();
        BloodDonorIntf bloodDonorService = new BloodDonorImpl();
        DonationIntf donationService = new DonationImpl();
        BloodRequestIntf bloodRequestService = new BloodRequestImpl();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nBlood Bank Management System");
            System.out.println("1. Add Donor");
            System.out.println("2. View All Donors");
            System.out.println("3. Update Donor");
            System.out.println("4. Delete Donor");
            System.out.println("5. View All Donations");
            System.out.println("6. View All Blood Donors");
            System.out.println("7. View All Blood Requests");
            System.out.println("8. Create Blood Request");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
            case 1:
                // Add Donor
                System.out.println("\nEnter Donor Details:");
                System.out.print("Donor ID: ");
                String donorId = scanner.nextLine();
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Blood Type: ");
                String bloodType = scanner.nextLine();
                System.out.print("Blood Units Received: ");
                String bloodunits = scanner.nextLine();


                Donor donor = new Donor(donorId, name, bloodType, bloodunits);
                donorService.addDonor(donor);
                System.out.println("Donor added successfully.");

                // Automatically link donor to donation
              //  System.out.println("\nEnter Donation Details:");
                String donationId = "DN" + donorId; // Example logic to create a unique donation ID
                Donation donation = new Donation(donationId, bloodType, new Date());
                donationService.addDonation(donation);
                BloodDonor bloodDonor = new BloodDonor(donorId, donationId);
                bloodDonorService.addBloodDonor(bloodDonor);
                System.out.println("Donor linked to donation successfully.");
                break;

            case 2:
                // View All Donors
                System.out.println("\nAll Donors:");
                System.out.println("| ID | Name | BloodType | Units |");
                donorService.getAllDonors().forEach(d -> 
                    System.out.println(d.getDonorId() + "   -  " + d.getName() + "   - " + d.getBloodType()+ "     -  " +d.GetBloodunit())//+ "   - " +d.GetBloodunit()
                );
                break;

            case 3:
                // Update Donor
                System.out.println("\nEnter Donor ID to update:");
                String updateDonorId = scanner.nextLine();
                Donor existingDonor = donorService.getAllDonors().stream()
                    .filter(d -> d.getDonorId().equals(updateDonorId))
                    .findFirst()
                    .orElse(null);

                if (existingDonor != null) {
                    System.out.println("Current Name: " + existingDonor.getName());
                    System.out.print("New Name: ");
                    String newName = scanner.nextLine();

                    System.out.println("Current Blood Type: " + existingDonor.getBloodType());
                    System.out.print("New Blood Type: ");
                    String newBloodType = scanner.nextLine();
                    
                    System.out.println("Current Blood Units: " + existingDonor.GetBloodunit());
                    System.out.print("New Blood Units: ");
                    String newBloodunits= scanner.nextLine();
                  

                    existingDonor.setName(newName);
                    existingDonor.setBloodType(newBloodType);
                    existingDonor.setBloodUnits(newBloodunits);

                    System.out.println("Donor updated successfully.");
                } else {
                    System.out.println("Donor with ID " + updateDonorId + " not found.");
                }
                break;

            case 4:
                // Delete Donor
                System.out.println("\nEnter Donor ID to delete:");
                String deleteDonorId = scanner.nextLine();

                Donor donorToDelete = donorService.getDonor(deleteDonorId);

                if (donorToDelete != null) {
                    donorService.deleteDonor(deleteDonorId); // Use the deleteDonor method from the service
                    System.out.println("Donor removed successfully.");
                } else {
                    System.out.println("Donor with ID " + deleteDonorId + " not found.");
                }
                break;



            case 5:
                // View All Donations
            	  System.out.println("\nAll Donations:");
                  donationService.getAllDonations().forEach(d -> 
                      System.out.println(d.getDonationId() + " - " + d.getBloodType() + " - " + d.getDonationDate())
                  );
                  break;


            case 6:
            	// View All Blood Donors
                System.out.println("\nAll Blood Donors:");
                bloodDonorService.getAllBloodDonors().forEach(bloodDonorEntry -> 
                    System.out.println(bloodDonorEntry.getDonorId() + " - " + bloodDonorEntry.getDonationId())
                );
                break;

            case 7:
                // View All Blood Requests
                System.out.println("\nAll Blood Requests:");
                bloodRequestService.getAllRequests().forEach(request -> 
                    System.out.println(request.getRequestId() + " - " + request.getBloodType() + " - " + request.getQuantity() + " units - " + request.getRequestDate())
                );
                break;


                case 8:
                    // Create Blood Request
                    System.out.println("\nEnter Blood Request Details:");
                    System.out.print("Request ID: ");
                    String requestId = scanner.nextLine();
                    System.out.print("Blood Type: ");
                    String bloodTypes = scanner.nextLine();
                    System.out.print("Quantity (units): ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    BloodRequest request = new BloodRequest(requestId, bloodTypes, quantity, new Date());
                    bloodRequestService.addRequest(request);
                    System.out.println("Blood request added successfully.");
                    break;

                case 9:
                    // Exit
                    System.out.println("Exiting the application.");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
