package city;

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
}



