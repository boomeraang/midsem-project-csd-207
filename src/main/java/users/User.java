package users;

import java.util.Scanner;

public class User
{
    private String userID,user_password;
    private int coords_x,coords_y;

    public void SetUserID(Scanner input)
    {
        userID = input.nextLine();
    }

    public void SetUserPassword(Scanner input)
    {
        user_password = input.nextLine();
    }

    public void SetUserCoords(int x,int y)
    {
        coords_x = x;
        coords_y = y;
    }

    public String GetUserID()
    {
        return userID;
    }

    public String GetUserPassword()
    {
        return user_password;
    }

    public float GetUserCoordsX()
    {
        return coords_x;
    }

    public float GetUserCoordsY()
    {
        return coords_y;
    }
}
