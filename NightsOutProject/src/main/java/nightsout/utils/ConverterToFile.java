package nightsout.utils;

import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ConverterToFile {


    private static final int DEFAULTBUFFERSIZE = 8192*4;

    public void fromInputStreamToFile(InputStream inputStream, File file) throws SystemException {
        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            int read;
            byte[] bytes = new byte[DEFAULTBUFFERSIZE];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}