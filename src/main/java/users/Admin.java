package users;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import city.Places;
import city.TouristDrone;
import filestuff.FileIO;

public abstract class Admin extends User
{
    public void AddAdmin(String filename)
    {
        File file = new File("/home/cybereagle3-1/AndroidStudioProjects/FirstApp/midsem_project/src/main/java/filestuff/" + filename);
        new FileIO().WriteUsersonFile(this, file);
    }

    public void DeleteUser(User x,String filename) throws IOException
    {
        File read_file = new File("/home/cybereagle3-1/AndroidStudioProjects/FirstApp/midsem_project/src/main/java/filestuff/" + filename);
        new FileIO().DeleteUsersfromFile(x,read_file);
    }
}

