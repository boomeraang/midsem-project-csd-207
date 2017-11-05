package filestuff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;

import city.Places;
import users.User;

public class FileIO
{
    public void WritePlacesonFile(Places place, File file)
    {
        try
        {
            FileOutputStream file_writer = new FileOutputStream(file, true);

            //writing places details by converting individual data members to byte arrays
            file_writer.write(place.GetName().getBytes());
            file_writer.write(place.GetPictureID().getBytes());
            //using ByteBuffer to getbytes float stuff
            file_writer.write(ByteBuffer.allocate(10).putFloat(place.GetCoordsX()).array());
            file_writer.write(ByteBuffer.allocate(10).putFloat(place.GetCoordsY()).array());

            file_writer.flush();
            file_writer.close();
        } catch (FileNotFoundException fno)
        {
            System.out.println("file not found");
        } catch (IOException io)
        {
            System.out.println("IOException occurred");
        }
    }

    public void WriteUsersonFile(User user, File file)
    {
        try
        {
            FileOutputStream file_writer = new FileOutputStream(file,true);

            file_writer.write(user.GetUserID().getBytes());
            file_writer.write(user.GetUserPassword().getBytes());

            file_writer.flush();
            file_writer.close();
        }
        catch (FileNotFoundException fno)
        {
            System.out.println("file not found");
        }
        catch (IOException io)
        {
            System.out.println("IOexception occured");
        }
    }

    public boolean DeleteUsersfromFile(User user,File read_file) throws IOException
    {
        File temp_file = new File("/home/cybereagle3-1/AndroidStudioProjects/FirstApp/midsem_project/src/main/java/filestuff/temp.txt");

        BufferedReader file_reader = new BufferedReader(new FileReader(read_file));
        BufferedWriter file_writer = new BufferedWriter(new FileWriter(temp_file));

        String lineToRemove = user.GetUserID() + user.GetUserPassword();
        String currentLine;

        while((currentLine = file_reader.readLine()) != null)
        {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove))
                continue;
            file_writer.write(currentLine + System.getProperty("line.separator"));
        }
        file_writer.close();
        file_reader.close();

        boolean success = temp_file.renameTo(read_file);
        return success;
    }

    public boolean UserLogin(String filename,String ID,String password) throws IOException
    {
        File file = new File("/home/cybereagle3-1/AndroidStudioProjects/FirstApp/midsem_project/src/main/java/filestuff/" + filename);
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
    }
}
