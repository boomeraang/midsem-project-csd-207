package users;

import filestuff.FileIO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class User
{
    private String userID,user_password;
    private int coords_x,coords_y;

    public User()
    {
        this.userID = "";
        this.user_password = "";
        this.coords_x = 0;
        this.coords_y = 0;
    }

    public User(String name, String pass)
    {
        this.userID = name;
        this.user_password = pass;
        this.coords_x = 0;
        this.coords_y = 0;
    }

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

    public void DeleteUser(String filename) throws IOException
    {
        File read_file = new File("/home/cybereagle3-1/IdeaProjects/midsem-project-csd-207/src/main/java/filestuff/" + filename);
        new FileIO().DeleteUsersfromFile(this,read_file);
    }

    public void ChangeUserPassword(String filename,String new_password) throws IOException
    {
        File read_file = new File("/home/cybereagle3-1/IdeaProjects/midsem-project-csd-207/src/main/java/filestuff/" + filename);
        new FileIO().ChangePasswordfromFile(this,read_file,new_password);
    }
}
