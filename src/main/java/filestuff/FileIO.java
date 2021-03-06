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
                file_writer.write(System.lineSeparator().getBytes());
            file_writer.write(place.GetPictureID().getBytes());
                file_writer.write(System.lineSeparator().getBytes());
            file_writer.write(place.GetName().getBytes());
            //using ByteBuffer to getbytes float stuff
                file_writer.write(System.lineSeparator().getBytes());
            file_writer.write(String.valueOf(place.GetCoordsX()).getBytes());
                file_writer.write(System.lineSeparator().getBytes());
            file_writer.write(String.valueOf(place.GetCoordsY()).getBytes());
                file_writer.write(System.lineSeparator().getBytes());

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

    public void WriteText(String text,File file) throws IOException
    {
        FileOutputStream file_writer = new FileOutputStream(file,true);

        file_writer.write(text.getBytes());
        file_writer.write(System.lineSeparator().getBytes());

        file_writer.flush();
        file_writer.close();
    }

    public void WriteUsersonFile(User user, File file)
    {
        try
        {
            FileOutputStream file_writer = new FileOutputStream(file,true);

            file_writer.write(System.lineSeparator().getBytes());
            file_writer.write(user.GetUserID().getBytes());
            file_writer.write(System.lineSeparator().getBytes());
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
        File temp_file = new File("/home/cybereagle3-1/IdeaProjects/midsem-project-csd-207/src/main/java/filestuff/temp.txt");

        BufferedReader file_reader = new BufferedReader(new FileReader(read_file));
        BufferedWriter file_writer = new BufferedWriter(new FileWriter(temp_file));

        String user_line = user.GetUserID();
        String currentLine;

        while((currentLine = file_reader.readLine()) != null)
        {
            // trim newline when comparing with user_line
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(user_line))
            {
                user_line = user.GetUserPassword();
                continue;
            }
            file_writer.write(currentLine);
            file_writer.newLine();
            //file_writer.write(currentLine + System.getProperty("line.separator"));
        }
        file_writer.close();
        file_reader.close();

        boolean success = temp_file.renameTo(read_file);
        return success;
    }

    public void SearchFile(String keyword, File read_file, int no_of_lines) throws IOException
    {
        BufferedReader file_reader = new BufferedReader(new FileReader((read_file)));

        String line_so_search = keyword;
        String current_line;

        while((current_line = file_reader.readLine()) != null)
        {
            String trimmed_line = current_line.trim();

            if(trimmed_line.equals(line_so_search))
            {
                for (int i = 0; i < no_of_lines ; i++)
                {
                    System.out.println(current_line);
                    current_line = file_reader.readLine();
                    //trimmed_line screws the function up
                    //trimmed_line = current_line.trim();
                }

                break;
            }
        }

        file_reader.close();
    }

    public Places SearchFileforPlaces(File read_file,int start_at_line) throws IOException
    {
        BufferedReader file_reader = new BufferedReader(new FileReader((read_file)));
        int i=1,x=0,y=0;
        String current_line;
        Places place =null;

        //reads lines that will never be used
        for(int j=1;j<start_at_line;j++)
            file_reader.readLine();

        while((current_line = file_reader.readLine()) != null)
        {
            String trimmed_line = current_line.trim();

            if(i == 2)
            {   place = new Places();
                place.SetPictureID(current_line);
            }
            else if(i == 3)
                place.SetName(current_line);
            else if(i == 4)
                x = Integer.parseInt(current_line);
            else if(i == 5)
            {
                y = (int) Float.parseFloat(current_line);
                place.SetCoords(x, y);
                break;
            }

            i++;
            //trimmed_line screws the function up
            //trimmed_line = current_line.trim();
        }

        file_reader.close();
        return place;
    }


    public boolean ChangePasswordfromFile(User user, File read_file, String new_password) throws IOException
    {
        File temp_file = new File("/home/cybereagle3-1/IdeaProjects/midsem-project-csd-207/src/main/java/filestuff/temp.txt");

        BufferedReader file_reader = new BufferedReader(new FileReader(read_file));
        BufferedWriter file_writer = new BufferedWriter(new FileWriter(temp_file));

        String line_to_replace = user.GetUserPassword();
        String currentLine;

        while((currentLine = file_reader.readLine()) != null)
        {
            // trim newline when comparing with line_to_replace
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(line_to_replace))
            {
                line_to_replace = new_password;
            }
            file_writer.write(currentLine);
            file_writer.newLine();
            //file_writer.write(currentLine + System.getProperty("line.separator"));
        }
        file_writer.close();
        file_reader.close();

        boolean success = temp_file.renameTo(read_file);
        return success;
    }

    public boolean UserLogin(String filename,String ID,String password) throws IOException
    {
        File file = new File("/home/cybereagle3-1/IdeaProjects/midsem-project-csd-207/src/main/java/filestuff/" + filename);
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
