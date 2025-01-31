package com.app.model; 

public class Package {
    private int packageId;
    private String packageName; 
    private String packageAccess; 
    private double packageFee;
    private String packageTrainingDuration;
    private String packageFreebies; 
    private int packageInstructor; 

    public Package(int packageId, String packageName, String packageAccess, double packageFee, String packageTrainingDuration, String packageFreebies, int packageInstructor) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.packageAccess = packageAccess;
        this.packageFee = packageFee;
        this.packageTrainingDuration = packageTrainingDuration;
        this.packageFreebies = packageFreebies;
        this.packageInstructor = packageInstructor;
    }

        
    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageAccess() {
        return packageAccess;
    }

    public void setPackageAccess(String packageAccess) {
        this.packageAccess = packageAccess;
    }

    public double getPackageFee() {
        return packageFee;
    }

    public void setPackageFee(double packageFee) {
        this.packageFee = packageFee;
    }

    public String getPackageTrainingDuration() {
        return packageTrainingDuration;
    }

    public void setPackageTrainingDuration(String packageTrainingDuration) {
        this.packageTrainingDuration = packageTrainingDuration;
    }

    public String getPackageFreebies() {
        return packageFreebies;
    }

    public void setPackageFreebies(String packageFreebies) {
        this.packageFreebies = packageFreebies;
    }

    public int getPackageInstructor() {
        return packageInstructor;
    }

    public void setPackageInstructor(int packageInstructor) {
        this.packageInstructor = packageInstructor;
    }
    
    
}
