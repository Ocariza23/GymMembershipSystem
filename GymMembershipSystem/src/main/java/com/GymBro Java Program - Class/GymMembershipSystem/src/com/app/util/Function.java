package com.app.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import com.app.gymbro.*;

public class Function extends DbConnection {
	public void printAsciiArt(String filePath) {
		try {
			FileReader reader = new FileReader(filePath); // Use the filePath parameter
			int data = reader.read();
			while (data != -1) {
				System.out.print((char) data);
				data = reader.read();
			}
			reader.close();
			System.out.println(); // For a new line after printing the art
		} catch (FileNotFoundException e) {
			System.out.println("ASCII art file not found: " + filePath);
		} catch (IOException e) {
			System.out.println("Error reading the ASCII art file: " + e.getMessage());
		}
	}


	//READ OPS
	public void readUsers() throws SQLException {
		String query = "SELECT * FROM tblusers";


		try {
			connect();
			state = con.createStatement();
			result = state.executeQuery(query);
			while (result.next()) {
				int id = result.getInt("users_id");
				String username = result.getString("users_username");
				String password = result.getString("users_password");
				String roles = result.getString("users_roles");
				String lastname = result.getString("users_lastname");
				String firstname = result.getString("users_firstname");
				String middlename = result.getString("users_middlename");
				String gender = result.getString("users_gender");
				String address = result.getString("users_address");
				String contact = result.getString("users_contact");
				String registration = result.getString("users_registration_date");
				String expiration = result.getString("users_expiration_date");
				String status = result.getString("users_status");
				int users_package_id = result.getInt("users_package_id");
				int archive = result.getInt("archive");

				System.out.print(id + "\t" + firstname + "\t" + lastname + "\t" + username + "\t" + password);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}
	}

	public void createUsers(String username, String password, String roles, String lastname, String firstname, String middlename, String gender, String address, String contact, String status) throws SQLException {
		String query = "INSERT INTO tblusers ( users_username, users_password, users_roles, users_lastname," + "users_firstname,users_middlename,users_gender, users_address, users_contact,users_status)" + "VALUES (?,?)";

		try {
			connect();
			prep = con.prepareStatement(query);
			prep.setString(1, username);
			prep.setString(2, password);
			prep.setString(3, roles);
			prep.setString(4, lastname);
			prep.setString(5, firstname);
			prep.setString(6, middlename);
			prep.setString(7, gender);
			prep.setString(8, address);
			prep.setString(9, contact);
			prep.setString(10, status);

			System.out.println("UserName: " + username + "\nPassword: " + password);
			readUsers();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}
	}

	public void updateUsers(String userName) throws SQLException {
		String query = "UPDATE tblusers SET users_username = test888 where = users_id=?";
		try {
			connect();
			prep = con.prepareStatement(query);
			prep.setString(1, userName);

			System.out.println("Username: " + userName + " Updated Successfully");

			readUsers();
		} catch (SQLException e) {
			System.out.printf(e.getMessage());
		} finally {
			con.close();
		}

	}

	public void softDelete() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter which ID to be deleted ");
		int softObj = sc.nextInt();
		sc.nextLine();

		String query = "UPDATE tblauthors SET archive 1 where authid_id=?";

		try {
			connect();
			prep = con.prepareStatement(query);
			prep.setInt(1, softObj);
			prep.executeUpdate();
			System.out.println("ID " + softObj + " Archived Successfully");


		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}
	}

	public void permaDelete() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter which ID to be deleted ");
		int permaObj = sc.nextInt();
		sc.nextLine();

		String query = "UPDATE tblauthors SET archive 0 where authid_id=?";

		try {
			connect();
			prep = con.prepareStatement(query);
			prep.setInt(0, permaObj);
			prep.executeUpdate();
			System.out.println("ID " + permaObj + " Archived Successfully");


		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}
	}

	public void searchUser() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Search for name: ");
		String userNameKW = sc.nextLine();
		String query = "SELECT * from tblusers where users_username like ?";
		try {
			connect();
			prep = con.prepareStatement(query);
			prep.setString(1, "%" + userNameKW + "%");
			result = prep.executeQuery();
			System.out.println("ID\t\tUSERNAME\t\tNAME\t\tADDRESS");
			while (result.next()) {
				int userID = result.getInt("users_id");
				String userName = result.getString("users_username");
				String firstName = result.getString("users_firstname");
				String address = result.getString("users_address");
				System.out.println(userID + "\t" + userName + "\t" + firstName);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}

	}

	public void loginUser() throws SQLException {
		Scanner sc = new Scanner(System.in);            
                
		System.out.println("Login");
		System.out.print("Enter Username: ");
		String userName = sc.nextLine();
		System.out.print("Enter Password: ");
		String userPass = sc.nextLine();

		String query = "SELECT users_roles FROM tblusers WHERE users_username = ? AND users_password = ? AND archive = 0";

		try {
			connect();
			prep = con.prepareStatement(query);
			prep.setString(1, userName);
			prep.setString(2, userPass);
			result = prep.executeQuery();

			if (result.next()) {
				String role = result.getString("users_roles");

				if ("Admin".equalsIgnoreCase(role)) {
					System.out.println("Login Successful");
					DashboardAdmin dashAdmin = new DashboardAdmin();
					dashAdmin.dashAdmin();
				} else if ("Member".equalsIgnoreCase(role)) {
					System.out.println("Login Successful");
					DashboardMembers dashMember = new DashboardMembers();
					dashMember.dashMembers();
				} else {
					System.out.println("Did not exist");
				}
			} else {
				System.out.println("Login Failed: Invalid username or password.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}
	}
}

