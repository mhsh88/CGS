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
        String pngpath = StationController.class.getResource("../../saveFile/cgs").getFile();
        File file = new File(pngpath);
        System.out.println(file.getAbsolutePath());

        String location = readFile(file.getAbsolutePath());
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
        String pngpath = StationController.class.getResource("../../saveFile/cgs").getFile();
        File file = new File(pngpath);
        Path path = Paths.get(file.getAbsolutePath());
        Files.write(path, Arrays.asList(dir));
    }
}
