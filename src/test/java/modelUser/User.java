package modelUser;

public class User {
    private final String userName;
    private final String userPosition;
    private final String userOffice;
    private final int ageUser;
    private final int salaryUser;

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

}
