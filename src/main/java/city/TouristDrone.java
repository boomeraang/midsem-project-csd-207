package city;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import filestuff.FileIO;
import users.User;

public class TouristDrone extends Drone
{
    public void AddPlace()
    {
        int choice;
        Scanner input = new Scanner(System.in);
        boolean dont_exit_loop = true;

        while (dont_exit_loop)
        {
            System.out.println("enter the kind of place do you want to add.");
            System.out.println("1.landmarks\n2.restaurants\n3.hotels\n4.recreational places\n5.shops");
            choice = Integer.parseInt(input.nextLine());

            String choice_type = "garbage.txt";

            if (choice == 1)
                choice_type = "landmarks.txt";
            else if (choice == 2)
                choice_type = "restaurants.txt";
            else if (choice == 3)
                choice_type = "hotels.txt";
            else if (choice == 4)
                choice_type = "recreations.txt";
            else if (choice == 5)
                choice_type = "shops.txt";

            Places landmark = new Places();

            System.out.println("enter the landmark details.\n name:");
            landmark.SetName(input);
            System.out.println("picture ID");
            landmark.SetPictureID(input);
            System.out.println("enter coordinates");
            landmark.SetCoords(Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine()));
            landmark.SetCategory("landmark");

            File file = new File("/home/cybereagle3-1/AndroidStudioProjects/FirstApp/midsem_project/src/main/java/filestuff/" + choice_type);
            new FileIO().WritePlacesonFile(landmark, file);

            System.out.println("do you want to add any more places y/n");
            if (input.nextLine().equals("n"))
                dont_exit_loop = false;
        }

        return;
    }

    public void AddTourist(User tourist)
    {
        File file = new File("/home/cybereagle3-1/AndroidStudioProjects/FirstApp/midsem_project/src/main/java/filestuff/tourists.txt");
        new FileIO().WriteUsersonFile(tourist, file);
    }

    public void TouristMenu()
    {
        Scanner input = new Scanner(System.in);
        boolean exit_loop = false;

        while (!exit_loop)
        {
            System.out.println("welcome. what would you like to do");
            System.out.println("1.\n2.cop login\n3.tourist admin login\n4.cop admin login\n5.shutdown system");
            int choice = Integer.parseInt(input.nextLine());

            if (choice == 1)
            {
            } else if (choice == 2)
            {

            }

        }
    }
}
