package users;

import filestuff.FileIO;

import java.io.IOException;
import java.util.Scanner;

public class Tourists extends User
{
    /*public Tourists(String temp_username, String temp_password)
    {
        super();
    }*/

    public Tourists(String touristID, String pass)
    {
        super(touristID,pass);
    }

    public void TouristMenu()
    {
        Scanner input = new Scanner(System.in);
        boolean exit_loop = false;

        System.out.println("welcome " + this.GetUserID() + ". what would you like to do");

        while (!exit_loop)
        {
            System.out.println("1.where am i\n2.suggest places\n3.go to place\n4.change password\n5.delete account\n6.logout");
            int choice = Integer.parseInt(input.nextLine());

            if (choice == 6)
                break;
            else if (choice == 1)
            {
                System.out.println("X=" + GetUserCoordsX());
                System.out.println("Y=" + GetUserCoordsY());
            }
            else if(choice == 2)
            {

            }
            else if(choice == 3)
            {
                System.out.println("enter coordinates");
                System.out.print("X:");
                int x = Integer.parseInt(input.nextLine());
                System.out.print("Y:");
                int y = Integer.parseInt(input.nextLine());
                SetUserCoords(x,y);
            }
            else if(choice == 4)
            {
                try
                {
                    System.out.println("please enter password to confirm your identity");
                    String temp_password = input.nextLine();

                    if(new FileIO().UserLogin("tourists.txt",this.GetUserID(),temp_password))
                    {
                        System.out.println("enter new password");
                        temp_password = input.nextLine();
                        System.out.println("re-enter password");
                        if(temp_password.equals(input.nextLine()))
                            ChangeUserPassword("tourists.txt",temp_password);
                    }
                } catch (IOException io)
                {
                    System.out.println("IOException occurred");
                }
            }
            else if(choice == 5)
            {
                try
                {
                    System.out.println("this is permanent. enter your password to confirm");
                    String temp_password = input.nextLine();

                    if(new FileIO().UserLogin("tourists.txt",this.GetUserID(),temp_password))
                        DeleteUser("tourists.txt");
                } catch (IOException io)
                {
                    System.out.println("IOException occurred");
                }
            }
        }

        return;
    }
}
