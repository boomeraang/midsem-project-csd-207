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
            System.out.println("1.add cop\n2.delete cop\n3.view reports\n4.logout");
            ch = Integer.parseInt(input.nextLine());

            if (ch == 1)
            {
                Cops cop = new Cops();

                System.out.println("enter cop ID");
                cop.SetUserID(input);
                System.out.println("set temporary password:");
                cop.SetUserPassword(input);

                new CopDrone().AddCop(cop);
            }
            else if(ch == 2)
            {
                Cops to_be_deleted = new Cops();

                System.out.println("enter username to be deleted:");
                to_be_deleted.SetUserID(input);

                try
                {
                    DeleteUser(to_be_deleted,"cops.txt");
                } catch (IOException io)
                {
                    System.out.println("IOException occurred");
                }
            }
            else if(ch == 3)
            {

            }
            else if(ch == 4)
                return;
        }
    }
}
