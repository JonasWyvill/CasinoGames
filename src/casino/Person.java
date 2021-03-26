package casino;

public class Person {

    private String firstName;
    private String lastName;
    private String userName;
    private int accountID;
    private int casinoCoins;

    public Person(String firstName, String lastName, String userName, int accountID, int casinoCoins) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.accountID = accountID;
        this.casinoCoins = casinoCoins;
    }
    public String toString() {
        return userName + " " + firstName + " " + lastName + " " + accountID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getAccountID() {
        return this.accountID;
    }
    
    public void setCasinoCoins(int CasinoCoins) {
        this.casinoCoins = casinoCoins;
    }

    public int getCasinoCoins() {
        return this.casinoCoins;
    }

}
