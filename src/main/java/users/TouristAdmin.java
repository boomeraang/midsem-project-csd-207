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
            System.out.println("1.add tourist\n2.delete tourist\n3.add place\n4.logout");
            ch = Integer.parseInt(input.nextLine());

            if (ch == 1)
            {
                User tourist = new User();

                System.out.println("enter tourist ID");
                tourist.SetUserID(input);
                System.out.println("set temporary password:");
                tourist.SetUserPassword(input);

                new TouristDrone().AddTourist(tourist);
            }
            else if(ch == 2)
            {
                User to_be_deleted = new User();

                System.out.println("enter username to be deleted:");
                to_be_deleted.SetUserID(input);

                try
                {
                    DeleteUser(to_be_deleted,"tourists.txt");
                } catch (IOException io)
                {
                    System.out.println("IOException occurred");
                }
            }
            else if(ch == 3)
            {
                new TouristDrone().AddPlace();
            }
            else if(ch == 4)
                return;
        }
    }
}
