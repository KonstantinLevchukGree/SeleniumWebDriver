package modelUser;

public class User {
    private String userName;
    private String userPosition;
    private String userOffice;
    private int ageUser;
    private int salaryUser;

    public User() {
    }

    public User(String userName, String userPosition, String userOffice, int ageUser, int salaryUser) {
        this.userName = userName;
        this.userPosition = userPosition;
        this.userOffice = userOffice;
        this.ageUser = ageUser;
        this.salaryUser = salaryUser;
    }

    public int getAgeUser() {
        return ageUser;
    }

    public int getSalaryUser() {
        return salaryUser;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public void setUserOffice(String userOffice) {
        this.userOffice = userOffice;
    }

    public void setAgeUser(int ageUser) {
        this.ageUser = ageUser;
    }

    public void setSalaryUser(int salaryUser) {
        this.salaryUser = salaryUser;
    }
}
