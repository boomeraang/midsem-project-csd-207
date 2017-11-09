package city;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
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

        System.out.print("date (DD/MM/YY:");
        String date = input.nextLine();
        System.out.print("time:");
        int time = Integer.parseInt(input.nextLine());
        System.out.println("notes:");
        String description = input.nextLine();

        File file = new File("/home/cybereagle3-1/IdeaProjects/midsem-project-csd-207/src/main/java/filestuff/crimes.txt");
        FileIO temp = new FileIO();
        temp.WritePlacesonFile(crime_location, file);
        temp.WriteText(date,file);
        temp.WriteText(String.valueOf(time),file);
        temp.WriteText(description,file);
    }

    public void ReportCrime(boolean automate) throws IOException
    {
        Random random = new Random();
        Places crime_location = new Places();
        Scanner input = new Scanner("");

        crime_location.SetName(input);
        System.out.println(crime_location.GetName());
        input = new Scanner(String.valueOf(random.nextInt(50)));
        crime_location.SetPictureID(input);
        crime_location.SetCoords(random.nextInt(100),random.nextInt(100));

        //doesnt run for some reason
        String description = "automated report";
        System.out.println(description);
        Date date = new Date();
        File file = new File("/home/cybereagle3-1/IdeaProjects/midsem-project-csd-207/src/main/java/filestuff/crimes.txt");
        FileIO temp = new FileIO();
        temp.WritePlacesonFile(crime_location, file);
        temp.WriteText(date.toString(),file);
        temp.WriteText(description,file);

        System.out.println(crime_location.GetPictureID());
    }

    public void ShowReports(String keyword) throws IOException
    {
        File file = new File("/home/cybereagle3-1/IdeaProjects/midsem-project-csd-207/src/main/java/filestuff/crimes.txt");
        new FileIO().SearchFile(keyword,file,7);
    }
}
