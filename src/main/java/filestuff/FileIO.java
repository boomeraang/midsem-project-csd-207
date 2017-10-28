package filestuff;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

}
