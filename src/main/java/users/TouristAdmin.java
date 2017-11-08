package users;

import java.io.IOException;
import java.util.Scanner;

import city.TouristDrone;

public class TouristAdmin extends Admin
{
    public void TouristAdminMenu()
    {
        int ch;
        Scanner input = new Scanner(System.in);
        boolean exit_loop = false;

        while(!exit_loop)
        {
            System.out.println("1.add tourist\n2.add place\n3.logout");
            ch = Integer.parseInt(input.nextLine());

            if (ch == 1)
            {
                Tourists tourist = new Tourists();

                System.out.println("enter tourist ID");
                tourist.SetUserID(input);
                System.out.println("set temporary password:");
                tourist.SetUserPassword(input);

                new TouristDrone().AddTourist(tourist);
            }
            else if(ch == 2)
            {
            }
            else if(ch == 2)
            {
                new TouristDrone().AddPlace();
            }
            else if(ch == 3)
                return;
        }
    }
}
