package users;

import java.io.IOException;
import java.util.Scanner;
import city.CopDrone;

public class CopAdmin extends Admin
{
    public void CopAdminMenu()
    {
        int ch;
        Scanner input = new Scanner(System.in);
        boolean exit_loop = false;

        while(!exit_loop)
        {
            System.out.println("1.add cop\n2.logout");
            ch = Integer.parseInt(input.nextLine());

            if (ch == 1)
            {
                Cops cop = new Cops();

                System.out.println("enter cop ID");
                cop.SetUserID(input);
                System.out.println("set temporary password:");
                cop.SetUserPassword(input);

                new CopDrone().AddUser(cop,"cops.txt");
            }
            else if(ch == 2)
                return;
        }
    }
}
