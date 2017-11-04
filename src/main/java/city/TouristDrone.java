package city;

import java.io.File;
import java.util.Scanner;

import filestuff.FileIO;
import users.User;

public class TouristDrone extends Drone
{
    public static void TouristMenu()

    public void AddPlace()
    {
        int choice;
        Scanner input = new Scanner(System.in);
        boolean dont_exit_loop = true;

        while(dont_exit_loop)
        {
            System.out.println("enter the kind of place do you want to add.");
            System.out.println("1.landmarks\n2.restaurants\n3.hotels\n4.recreational places\n5.shops");
            choice = Integer.parseInt(input.nextLine());

            if(choice == 1)
            {
                Places landmark = new Places();
                landmark.SetAllData(input,"landmark",Integer.parseInt(input.nextLine()),Integer.parseInt(input.nextLine()));

                File file = new File("/home/cybereagle3-1/AndroidStudioProjects/FirstApp/midsem_project/src/main/java/filestuff/landmarks.txt");
                new FileIO().WritePlacesonFile(landmark,file);
            }
            else if(choice == 2)
            {
                {
                    Places restaurant = new Places();
                    restaurant.SetAllData(input,"restaurant",Integer.parseInt(input.nextLine()),Integer.parseInt(input.nextLine()));

                    File file = new File("/home/cybereagle3-1/AndroidStudioProjects/FirstApp/midsem_project/src/main/java/filestuff/restaurants.txt");
                    new FileIO().WritePlacesonFile(restaurant,file);
                }
            }
            else if(choice == 3)
            {
                Places hotel = new Places();
                hotel.SetAllData(input,"hotel",Integer.parseInt(input.nextLine()),Integer.parseInt(input.nextLine()));

                File file = new File("/home/cybereagle3-1/AndroidStudioProjects/FirstApp/midsem_project/src/main/java/filestuff/hotels.txt");
                new FileIO().WritePlacesonFile(hotel,file);
            }
            else if(choice == 4)
            {
                Places recreation = new Places();
                recreation.SetAllData(input,"recreation",Integer.parseInt(input.nextLine()),Integer.parseInt(input.nextLine()));

                File file = new File("/home/cybereagle3-1/AndroidStudioProjects/FirstApp/midsem_project/src/main/java/filestuff/recreations.txt");
                new FileIO().WritePlacesonFile(recreation,file);
            }
            else if(choice == 5)
            {
                Places shop = new Places();
                shop.SetAllData(input,"shop",Integer.parseInt(input.nextLine()),Integer.parseInt(input.nextLine()));

                File file = new File("/home/cybereagle3-1/AndroidStudioProjects/FirstApp/midsem_project/src/main/java/filestuff/shops.txt");
                new FileIO().WritePlacesonFile(shop,file);
            }

            System.out.println("do you want to add any more places y/n");
            if(input.nextLine().equals("n"))
                dont_exit_loop = false;
        }
    }

    public void AddTourist(User tourist)
    {
        File file = new File("/home/cybereagle3-1/AndroidStudioProjects/FirstApp/midsem_project/src/main/java/filestuff/tourists.txt");
        new FileIO().WriteUsersonFile(tourist, file);
    }

}
