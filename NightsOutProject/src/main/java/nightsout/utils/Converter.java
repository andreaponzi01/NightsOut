package nightsout.utils;

import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Converter {

    private Converter(){
        //ignore
    }

    private static final int DEFAULT_BUFFER_SIZE = 8192*4;


    public  static void fromInputStreamToFile(InputStream inputStream, File file) throws SystemException {
        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            int read;
            byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }
}