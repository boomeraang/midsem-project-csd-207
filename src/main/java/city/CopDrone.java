package city;

import java.io.File;

import filestuff.FileIO;
import users.User;

public class CopDrone extends Drone
{
    public void AddCop(User cop)
    {
        File file = new File("/home/cybereagle3-1/AndroidStudioProjects/FirstApp/midsem_project/src/main/java/filestuff/cops.txt");
        new FileIO().WriteUsersonFile(cop, file);
    }
}
