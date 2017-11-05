package users;

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

            System.out.println("1.where am i\n2.go to place\n3.file a crime report\n4.view past reports\n5.change password\n6.logout");
            int choice = Integer.parseInt(input.nextLine());

            if (choice == 6)
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
        }

        return;
    }
}