package city;

import filestuff.FileIO;
import users.Tourists;
import users.User;

import java.io.File;
import java.util.Scanner;

public class Drone
{
    private String ID;
    private float coords_x,coords_y;

    //set and get functions

    public void SetID(Scanner input)
    {
        ID = input.nextLine();
    }

    public void SetCoords(int x, int y)
    {
        coords_x = x;
        coords_y = y;
    }

    public String GetID()
    {
        return ID;
    }

    public float GetCoordsX()
    {
        return coords_x;
    }

    public float GetCoordsY()
    {
        return coords_y;
    }

    //end of set and get functions

    public void AddUser(User user,String filename)
    {
        File file = new File("/home/cybereagle3-1/IdeaProjects/midsem-project-csd-207/src/main/java/filestuff/" + filename);
        new FileIO().WriteUsersonFile(user, file);
    }

    public void WhereAmI(User user)
    {
        System.out.println("X=" + user.GetUserCoordsX());
        System.out.println("Y=" + user.GetUserCoordsY());
    }

    public void MoveDrone(User user)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("enter coordinates");
        System.out.print("X:");
        int x = Integer.parseInt(input.nextLine());
        System.out.print("Y:");
        int y = Integer.parseInt(input.nextLine());
        user.SetUserCoords(x,y);
    }
}



