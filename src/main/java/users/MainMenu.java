package users;

import java.util.Scanner;

public class MainMenu
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        boolean exit_loop = false;

        while(!exit_loop)
        {
            System.out.println("1.tourist login\n2.cop login\n3.admin login");
            int choice = Integer.parseInt(input.nextLine());

            if(choice == 1)
            {
            }
            else if(choice == 2)
            {

            }
            else if(choice == 3)
            {
                Admin admin = new Admin();

                System.out.println("enter username");
                String temp_username = input.nextLine();
                System.out.println("enter password");
                String temp_password = input.nextLine();

                try
                {
                    if(admin.AdminLogin(temp_username,temp_password)
                        admin.AdminMenu();
                }
            }
        }

    }
}
