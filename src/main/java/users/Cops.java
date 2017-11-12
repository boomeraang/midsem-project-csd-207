package users;

import city.CopDrone;
import city.Places;
import filestuff.FileIO;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Cops extends User
{
    public Cops()
    {
        super();
    }

    public Cops(String copID, String pass)
    {
        super(copID,pass);
    }

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

            CopDrone cdrone = new CopDrone();
            if(choice == 1)
            {
                cdrone.WhereAmI(cdrone);
            }
            else if(choice == 2)
            {
                cdrone.MoveDrone(this);
            }
            else if(choice == 3)
            {
                try
                {
                    cdrone.ReportCrime();
                }catch (IOException io)
                {
                    System.out.println("IOException occurred");
                }
            }
            else if(choice == 4)
            {
                Random random = new Random();
                try
                {
                    for (int i = 0; i <random.nextInt(3) ; i++)
                    {
                        cdrone.ReportCrime(true);
                    }
                }catch (IOException io)
                {
                    System.out.println("IOException occurred");
                }
            }
            else if (choice == 5)
            {
                try
                {
                    System.out.println("enter picture ID");
                    cdrone.ShowReports(input.nextLine());
                } catch (IOException io)
                {
                    System.out.println("IOException occurred");
                }
            }
            else if(choice == 6)
            {
                try
                {
                    System.out.println("please enter password to confirm your identity");
                    String temp_password = input.nextLine();

                    if(new FileIO().UserLogin("cops.txt",this.GetUserID(),temp_password))
                    {
                        System.out.println("enter new password");
                        temp_password = input.nextLine();
                        System.out.println("re-enter password");
                        if(temp_password.equals(input.nextLine()))
                            ChangeUserPassword("cops.txt",temp_password);
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