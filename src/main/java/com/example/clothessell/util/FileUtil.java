package com.example.clothessell.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Objects;

public class FileUtil {

    public static String convertFileToBase64(File file) throws IOException {
        if(Objects.isNull(file)) {
            return "";
        }
        byte[] fileContent = org.aspectj.util.FileUtil.readAsByteArray(file);
        return Base64.getEncoder().encodeToString(fileContent);
    }

    public static File convertBase64ToFile(String ouputFileName, String base64String) {
        File file = null;
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            file = new File(ouputFileName);
            writeByte(decodedBytes, file);
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }
        return file;
    }

    public static void writeByte(byte[] bytes, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
