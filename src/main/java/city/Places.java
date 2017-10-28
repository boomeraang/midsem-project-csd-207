package city;

import java.util.Scanner;
import java.util.ArrayList;

public class Places
{
    private String name,pictureID,category;
    private int coords_x,coords_y;

    //set and get functions

    public void SetName(Scanner input)
    {
        name = input.nextLine();
    }

    public void SetPictureID(Scanner input)
    {
        pictureID = input.nextLine();
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

    public void SetAllData(Scanner input,String str,int x,int y)
    {
        System.out.println("enter the landmark details.\n name:");
        SetName(input);
        System.out.println("picture ID");
        SetPictureID(input);
        SetCategory(str);
        System.out.println("enter coordinates");
        SetCoords(x,y);
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

    //end of set and get functions
}
