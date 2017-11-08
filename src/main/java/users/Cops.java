package users;

import filestuff.FileIO;

import java.io.IOException;
import java.util.Scanner;

public class Cops extends User
{
    public void CopMenu()
    {
        Scanner input = new Scanner(System.in);
        boolean exit_loop = false;

        System.out.println("welcome. what would you like to do");

        while (!exit_loop)
        {

            System.out.println("1.where am i\n2.go to place\n3.file a crime report\n4.automated drone patrol\n5.view past reports\n6.change password\n7.logout");
            int choice = Integer.parseInt(input.nextLine());

            if (choice == 7)
                break;
            else if(choice == 1)
            {
                System.out.println("X=" + GetUserCoordsX());
                System.out.println("Y=" + GetUserCoordsY());
            }
            else if(choice == 2)
            {
                System.out.println("enter coordinates");
                System.out.print("X:");
                int x = Integer.parseInt(input.nextLine());
                System.out.print("Y:");
                int y = Integer.parseInt(input.nextLine());
                SetUserCoords(x,y);
            }
            else if(choice == 6)
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
        }

        return;
    }
}