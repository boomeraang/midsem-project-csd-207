package city;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import filestuff.FileIO;
import users.Tourists;
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

            File file = new File("/home/cybereagle3-1/IdeaProjects/midsem-project-csd-207/src/main/java/filestuff/" + choice_type);
            new FileIO().WritePlacesonFile(landmark, file);

            System.out.println("do you want to add any more places y/n");
            if (input.nextLine().equals("n"))
                dont_exit_loop = false;
        }

        return;
    }

    public void AddTourist(Tourists tourist)
    {
        File file = new File("/home/cybereagle3-1/IdeaProjects/midsem-project-csd-207/src/main/java/filestuff/tourists.txt");
        new FileIO().WriteUsersonFile(tourist, file);
    }

    public void WhereAmI(Tourists tourist)
    {
        System.out.println("X=" + tourist.GetUserCoordsX());
        System.out.println("Y=" + tourist.GetUserCoordsY());
    }

    public void MoveDrone(Tourists tourist)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("enter coordinates");
        System.out.print("X:");
        int x = Integer.parseInt(input.nextLine());
        System.out.print("Y:");
        int y = Integer.parseInt(input.nextLine());
        tourist.SetUserCoords(x,y);
    }

}
