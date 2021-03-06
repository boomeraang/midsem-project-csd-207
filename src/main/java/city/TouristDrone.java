package city;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

            System.out.print("enter the landmark details.\n name:");
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

    public void SuggestPlaces(Tourists tourist) throws IOException
    {
        Scanner input = new Scanner(System.in);
        int choice;

        System.out.println("what kind of place do you want to go");
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

        File file = new File("/home/cybereagle3-1/IdeaProjects/midsem-project-csd-207/src/main/java/filestuff/" + choice_type);
        FileIO fileIO = new FileIO();
        int start_at_line = 1;
        boolean dont_exit = true;

        //ArrayList<Double> distances = new ArrayList<>();
        ArrayList<Places> places = new ArrayList<>();

        while(dont_exit)
        {
            Places place = fileIO.SearchFileforPlaces(file,start_at_line);
            if(place == null)
                break;

            place.SetDistance(CalculateDistance(place));
            places.add(place);

            start_at_line = start_at_line+5;
        }

        Collections.sort(places, Comparator.comparingDouble(Places :: GetDistance));
        //Collections.reverse(places);

        System.out.println("places near you...");
        for(Places temp:places)
            System.out.println("place:" + temp.GetName() + " distance:" + temp.GetDistance());
    }
}
