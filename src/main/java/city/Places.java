package city;

import java.util.Scanner;
import java.util.ArrayList;

public class Places
{
    private String name,pictureID,category;
    private int coords_x,coords_y;
    private double distance;
    //set and get functions


    public void SetName(Scanner input)
    {
        name = input.nextLine();
    }

    public void SetPictureID(Scanner input)
    {
        pictureID = input.nextLine();
    }

    public void SetName(String x)
{
    name = x;
}

    public void SetPictureID(String x)
    {
        pictureID = x;
    }

    public void SetCategory(String x)
    {
        category = x;
    }

    public void SetCoords(int x, int y)
    {
        coords_x = x;
        coords_y = y;
    }

    public void SetDistance(double d)
    {
        distance = d;
    }

    public String GetName()
    {
        return name;
    }

    public String GetPictureID()
    {
        return pictureID;
    }

    public String Getcategory()
    {
        return category;
    }

    public float GetCoordsX()
    {
        return coords_x;
    }

    public float GetCoordsY()
    {
        return coords_y;
    }

    public double GetDistance()
    {
        return distance;
    }
    //end of set and get functions
}
