package users;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import filestuff.FileIO;

public class User implements Cloneable
{
    private String userID,user_password;

    public void SetUserID(Scanner input)
    {
        userID = input.nextLine();
    }

    public void SetUserPassword(Scanner input)
    {
        user_password = input.nextLine();
    }

    public String GetUserID()
    {
        return userID;
    }

    public String GetUserPassword()
    {
        return user_password;
    }

    /*@Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }*/

    public void AddUser()
    {
        File file = new File("/home/cybereagle3-1/AndroidStudioProjects/FirstApp/midsem_project/src/main/java/filestuff/users.txt");
        new FileIO().WriteUsersonFile(this,file);
    }

    public void DeleteUser(User x) throws IOException, FileNotFoundException
    {
        File read_file = new File("myFile.txt");
        File temp_file = new File("myTempFile.txt");

        BufferedReader file_reader = new BufferedReader(new FileReader(read_file));
        BufferedWriter file_writer = new BufferedWriter(new FileWriter(temp_file));

        String lineToRemove = x.GetUserID() + x.GetUserPassword();
        String currentLine;

        while((currentLine = file_reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove)) continue;
            file_writer.write(currentLine + System.getProperty("line.separator"));
        }
        file_writer.close();
        file_reader.close();

        boolean success = temp_file.renameTo(read_file);
    }
}
