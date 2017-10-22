package city;

import java.util.Scanner;

public class Drone
{
    private String ID;
    private float coords_x,coords_y;

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

}

