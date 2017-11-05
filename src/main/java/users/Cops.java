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

            System.out.println("1.where am i\n2.file a crime report\n3.view past reports\n4.change password\n5.logout");
            int choice = Integer.parseInt(input.nextLine());

            if (choice == 5)
                break;

        }
    }
}