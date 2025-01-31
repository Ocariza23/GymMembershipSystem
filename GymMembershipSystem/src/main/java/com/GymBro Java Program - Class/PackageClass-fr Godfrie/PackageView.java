package com.app.view;

import com.app.model.Package;
import java.util.ArrayList;
import java.util.Scanner;

public class PackageView {

	private Scanner scanner;

	public PackageView() {
		scanner = new Scanner(System.in);
	}

	public Package createPackage() {
		System.out.println("*** Enter Package Details ***");

		System.out.print("Package Name: ");
		String packageName = scanner.nextLine();

		System.out.print("Package Access: ");
		String packageAccess = scanner.nextLine();

		System.out.print("Package Fee: ");
		int packageFee = Integer.parseInt(scanner.nextLine());

		System.out.print("Package Training Duration(Days): ");
		int packageTrainingDuration = Integer.parseInt(scanner.nextLine());

		System.out.print("Package Freebies: ");
		String packageFreebies = scanner.nextLine();

		System.out.print("Package Instructor (Yes/No): ");
		String packageInstructor = scanner.nextLine();

		return new Package(packageName, packageAccess, packageFee, packageTrainingDuration, packageFreebies, packageInstructor);
	}

	public void displayPackages(ArrayList<Package> packages) {
		if (packages.isEmpty()) {
			System.out.println("No packages found");
		} else {
			for (Package p : packages) {
				System.out.println(p.toString());
			}
		}
	}

	public void displayPackage(Package packageObj) {
		if (packageObj != null) {
			System.out.println(packageObj.toString());
		} else {
			System.out.println("Package not found!");
		}
	}

	public String searchPackage() {
		System.out.print("Enter search criteria (Package Name or Access): ");
		return scanner.nextLine();
	}

	public int getPackageId() {
		System.out.print("Enter Package ID: ");
		return Integer.parseInt(scanner.nextLine());
	}

	public Package updatePackage(Package packageObj) {
		System.out.println("Updating Package: " + packageObj.getPackageName());

		System.out.print("New Package Name (leave blank to keep same): ");
		String newName = scanner.nextLine();
		if (!newName.isEmpty()) {
			packageObj.setPackageName(newName);
		}

		System.out.print("New Package Access (leave blank to keep same): ");
		String newAccess = scanner.nextLine();
		if (!newAccess.isEmpty()) {
			packageObj.setPackageAccess(newAccess);
		}

		System.out.print("New Package Fee (enter -1 to keep same): ");
		int newFee = Integer.parseInt(scanner.nextLine());
		if (newFee != -1) {
			packageObj.setPackageFee(newFee);
		}

		System.out.print("New Package Training Duration (enter -1 to keep same): ");
		int newDuration = Integer.parseInt(scanner.nextLine());
		if (newDuration != -1) {
			packageObj.setPackageTrainingDuration(newDuration);
		}

		System.out.print("New Package Freebies (leave blank to keep same): ");
		String newFreebies = scanner.nextLine();
		if (!newFreebies.isEmpty()) {
			packageObj.setPackageFreebies(newFreebies);
		}

		System.out.print("New Package Instructor (leave blank to keep same): ");
		String newInstructor = scanner.nextLine();
		if (!newInstructor.isEmpty()) {
			packageObj.setPackageInstructor(newInstructor);
		}

		return packageObj;
	}

	public void displayDeletionConfirmation() {
		System.out.println("Package deleted successfully");
	}

	public void displayArchiveConfirmation() {
		System.out.println("Package archived successfully");
	}

	public void displayRestoreConfirmation() {
		System.out.println("Package restored successfully");
	}

	public void confirmArchiveOrRestore() {
		System.out.println("Please choose an action:");
		System.out.println("1. Archive Package");
		System.out.println("2. Restore Package");
	}
}
