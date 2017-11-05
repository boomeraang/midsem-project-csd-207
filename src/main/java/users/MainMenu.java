package users;

import java.io.IOException;
import java.util.Scanner;

import filestuff.FileIO;

public class MainMenu
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        boolean exit_loop = false;

        while(!exit_loop)
        {
            System.out.println("1.tourist login\n2.cop login\n3.tourist admin login\n4.cop admin login\n5.shutdown system");
            int choice = Integer.parseInt(input.nextLine());

            if(choice == 5)
            {
                System.out.println("shutting down");
                System.exit(0);
            }

            System.out.println("enter username");
            String temp_username = input.nextLine();
            System.out.println("enter password");
            String temp_password = input.nextLine();

            if(choice == 1)
            {
                try
                {
                    if(new FileIO().UserLogin("tourists.txt",temp_username,temp_password))
                    {
                        User tourist = new User();
                        tourist.Tenu();
                    }

                } catch (IOException io)
                {
                    System.out.println("IOException occurred");
                }
            }
            else if(choice == 2)
            {

            }
            else if(choice == 3)
            {
                try
                {
                    if(new FileIO().UserLogin("tourist_admin.txt",temp_username,temp_password))
                    {
                        TouristAdmin admin = new TouristAdmin();
                        admin.TouristAdminMenu();
                    }

                } catch (IOException io)
                {
                    System.out.println("IOException occurred");
                }
            }
        }

    }
}
