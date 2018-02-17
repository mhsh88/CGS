package sample.util;

import sample.controller.stationController.StationController;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileLocation {
    private  String readFile(String path)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, Charset.defaultCharset());
    }
    public  File getFileLocation() throws IOException {
        String location = readFile(StationController.class.getResource("../../saveFile/cgs").getPath().toString());
        location = location.trim();
        File tempFile = new File(location);
        File recordsDir = new File(System.getProperty("user.home"), "Behin-Simulator/");;

        if (!recordsDir.exists()) {
            recordsDir.mkdirs();
        }
        if(tempFile.exists())
            return tempFile;
        else
            return recordsDir;

    }

    public void setFileLocation(String dir) throws IOException {
        Path path = Paths.get(StationController.class.getResource("../../saveFile/cgs").getPath().toString());
        Files.write(path, Arrays.asList(dir));
    }
}
