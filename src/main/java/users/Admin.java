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
        File file = new File("/home/cybereagle3-1/IdeaProjects/midsem-project-csd-207/src/main/java/filestuff/" + filename);
        new FileIO().WriteUsersonFile(this, file);
    }
}

