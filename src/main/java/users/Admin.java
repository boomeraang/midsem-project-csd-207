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

    /*public boolean AdminLogin(String admin_filename,String ID,String password) throws IOException
    {
        File file = new File("/home/cybereagle3-1/AndroidStudioProjects/FirstApp/midsem_project/src/main/java/filestuff/" + admin_filename);
        BufferedReader file_reader = new BufferedReader(new FileReader(file));

        String trimmed_line,current_line;
        while((current_line = file_reader.readLine()) != null)
        {
            trimmed_line = current_line.trim();
            if(trimmed_line.equals(ID))
            {
                current_line = file_reader.readLine();
                trimmed_line = current_line.trim();

                if (trimmed_line.equals(password))
                    return true;
            }
        }

        file_reader.close();
        return false;
    }*/
}

