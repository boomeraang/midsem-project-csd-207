package users;

import java.util.Scanner;

public class User
{
    private String userID,user_password;

    public void SetUserID(Scanner input)
    {
        userID = input.nextLine();
    }

    public void SetUserPassword(Scanner input)
    {
        user_password = input.nextLine();
    }

    public String GetUserID()
    {
        return userID;
    }

    public String GetUserPassword()
    {
        return user_password;
    }


}
