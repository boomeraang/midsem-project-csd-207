package city;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Scanner;
import java.util.ArrayList;

public class TouristDrone extends Drone
{
    /*private static ArrayList<Places> restaurants = new ArrayList<>();
    private static ArrayList<Places> landmarks = new ArrayList<>();
    private static ArrayList<Places> recreational_places = new ArrayList<>();
    private static ArrayList<Places> hotels = new ArrayList<>();
    private static ArrayList<Places> shops = new ArrayList<>();
    */

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
                System.out.println("enter the landmark details.\n name:");
                landmark.SetName(input);
                System.out.println("picture ID");
                landmark.SetPictureID(input);
                landmark.SetCategory("landmark");
                System.out.println("enter coordinates");
                landmark.SetCoords(Integer.parseInt(input.nextLine()),Integer.parseInt(input.nextLine()));

                File file = new File("/home/cybereagle3-1/AndroidStudioProjects/FirstApp/midsem_project/src/main/java/filestuff/landmarks.txt");
                try
                {
                    FileOutputStream file_writer = new FileOutputStream(file,true);

                    //writing landmark details by converting individual data members to byte arrays
                    file_writer.write(landmark.GetName().getBytes());
                    file_writer.write(landmark.GetPictureID().getBytes());
                    //using ByteBuffer to getbytes float stuff
                    file_writer.write(ByteBuffer.allocate(10).putFloat(landmark.GetCoordsX()).array());
                    file_writer.write(ByteBuffer.allocate(10).putFloat(landmark.GetCoordsY()).array());

                    file_writer.flush();
                    file_writer.close();
                } catch (FileNotFoundException fno)
                {
                    System.out.println("file not found");
                }
                catch (IOException io)
                {
                    System.out.println("IOException occured");
                }

            }
        }
    }
}
