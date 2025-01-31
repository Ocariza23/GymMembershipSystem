package com.app.dao.impl;

import com.app.dao.PackageDAO;
import com.app.model.Package;
import com.app.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;

public class PackageDAOIMPL extends DbConnection implements PackageDAO {

	@Override
	public boolean create(Package packageObj) {
		String query = "INSERT INTO packages (package_name, package_access, package_fee, package_training_duration, package_freebies, package_instructor, package_archive) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			prep = con.prepareStatement(query);
			prep.setString(1, packageObj.getPackageName());
			prep.setString(2, packageObj.getPackageAccess());
			prep.setInt(3, packageObj.getPackageFee());
			prep.setInt(4, packageObj.getPackageTrainingDuration());
			prep.setString(5, packageObj.getPackageFreebies());
			prep.setString(6, packageObj.getPackageInstructor());
			prep.setInt(7, packageObj.getPackageArchive());

			int result = prep.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			System.out.println("Error creating package: " + e.getMessage());
			return false;
		}
	}

	@Override
	public ArrayList<Package> read() {
		ArrayList<Package> packages = new ArrayList<>();
		String query = "SELECT * FROM packages";
		try {
			state = con.createStatement();
			result = state.executeQuery(query);

			while (result.next()) {
				Package packageObj = new Package(result.getString("package_name"),
						result.getString("package_access"),
						result.getInt("package_fee"),
						result.getInt("package_training_duration"),
						result.getString("package_freebies"),
						result.getString("package_instructor"));
				packageObj.setPackageId(result.getInt("package_id"));
				packageObj.setPackageArchive(result.getInt("package_archive"));  // Get the correct archive status (0 or 1)
				packages.add(packageObj);
			}
		} catch (SQLException e) {
			System.out.println("Error reading packages: " + e.getMessage());
		}
		return packages;
	}

	@Override
	public Package read(int packageId) {
		Package packageObj = null;
		String query = "SELECT * FROM packages WHERE package_id = ?";
		try {
			prep = con.prepareStatement(query);
			prep.setInt(1, packageId);
			result = prep.executeQuery();

			if (result.next()) {
				packageObj = new Package(result.getString("package_name"),
						result.getString("package_access"),
						result.getInt("package_fee"),
						result.getInt("package_training_duration"),
						result.getString("package_freebies"),
						result.getString("package_instructor"));
				packageObj.setPackageId(result.getInt("package_id"));
				packageObj.setPackageArchive(result.getInt("package_archive"));
			}
		} catch (SQLException e) {
			System.out.println("Error reading package by ID: " + e.getMessage());
		}
		return packageObj;
	}

	@Override
	public boolean update(Package packageObj) {
		String query = "UPDATE packages SET package_name = ?, " +
				"package_access = ?, " +
				"package_fee = ?, " +
				"package_training_duration = ?, " +
				"package_freebies = ?, " +
				"package_instructor = ?, " +
				"package_archive = ? " +
				"WHERE package_id = ?";
		try {
			prep = con.prepareStatement(query);
			prep.setString(1, packageObj.getPackageName());
			prep.setString(2, packageObj.getPackageAccess());
			prep.setInt(3, packageObj.getPackageFee());
			prep.setInt(4, packageObj.getPackageTrainingDuration());
			prep.setString(5, packageObj.getPackageFreebies());
			prep.setString(6, packageObj.getPackageInstructor());
			prep.setInt(7, packageObj.getPackageArchive());
			prep.setInt(8, packageObj.getPackageId());

			int result = prep.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			System.out.println("Error updating package: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(int packageId) {
		String query = "DELETE FROM packages WHERE package_id = ?";
		try {
			prep = con.prepareStatement(query);
			prep.setInt(1, packageId);

			int result = prep.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			System.out.println("Error deleting package: " + e.getMessage());
			return false;
		}
	}

	@Override
	public ArrayList<Package> search(String criteria) {
		ArrayList<Package> packages = new ArrayList<>();
		String query = "SELECT * FROM packages WHERE package_name LIKE ?";
		try {
			prep = con.prepareStatement(query);
			prep.setString(1, "%" + criteria + "%");
			result = prep.executeQuery();

			while (result.next()) {
				Package packageObj = new Package(result.getString("package_name"),
						result.getString("package_access"),
						result.getInt("package_fee"),
						result.getInt("package_training_duration"),
						result.getString("package_freebies"),
						result.getString("package_instructor"));
				packageObj.setPackageId(result.getInt("package_id"));
				packageObj.setPackageArchive(result.getInt("package_archive"));  // Get the correct archive status (0 or 1)
				packages.add(packageObj);
			}
		} catch (SQLException e) {
			System.out.println("Error searching packages: " + e.getMessage());
		}
		return packages;
	}

	@Override
	public boolean archive(int packageId) {
		String query = "UPDATE packages SET package_archive = 1 WHERE package_id = ?";
		try {
			prep = con.prepareStatement(query);
			prep.setInt(1, packageId);
			int result = prep.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			System.out.println("Error archiving package: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean restore(int packageId) {
		String query = "UPDATE packages SET package_archive = 0 WHERE package_id = ?";
		try {
			prep = con.prepareStatement(query);
			prep.setInt(1, packageId);
			int result = prep.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			System.out.println("Error restoring package: " + e.getMessage());
			return false;
		}
	}
}
