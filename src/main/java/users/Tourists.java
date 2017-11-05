package users;

import java.util.Scanner;

public class Tourists extends User
{
    public void TouristMenu()
    {
        Scanner input = new Scanner(System.in);
        boolean exit_loop = false;

        while (!exit_loop)
        {
            System.out.println("welcome. what would you like to do");
            System.out.println("1.where am i\n2.suggest places\n3.go to place\n4.change password\n5.logout");
            int choice = Integer.parseInt(input.nextLine());

            if (choice == 5)
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

            }
        }

        return;
    }
}
