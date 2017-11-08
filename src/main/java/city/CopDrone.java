package city;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import filestuff.FileIO;

public class CopDrone extends Drone
{
    public void ReportCrime() throws IOException
    {
        Scanner input = new Scanner(System.in);

        Places crime_location = new Places();
        System.out.print("enter location name.\n name");
        crime_location.SetName(input);
        System.out.println("picture ID");
        crime_location.SetPictureID(input);
        System.out.println("enter coordinates");
        crime_location.SetCoords(Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine()));
        crime_location.SetCategory("crime_location");

        System.out.println("notes:");
        String description = input.nextLine();

        File file = new File("/home/cybereagle3-1/IdeaProjects/midsem-project-csd-207/src/main/java/filestuff/crimes.txt");
        FileIO temp = new FileIO();
        temp.WritePlacesonFile(crime_location, file);
        temp.WriteText(description,file);
    }
}
