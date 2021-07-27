package com.main;

import com.commands.Conversion;
import com.domain.FFMpeg;
import com.enums.SupportedMediaFormats;
import com.exceptions.FileAlreadyExistsException;
import com.exceptions.UnsupportedFileFormatException;
import com.helpers.Constants;
import com.helpers.FileHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    public Converter() {}

    public static void convertFormat(String inputFilePath,
                                     String outputPath,
                                     String outputFileName,
                                     String outputFormat) {
        String extension = inputFilePath.substring(inputFilePath.length() - 4).replace(".", "");
        String outputFilePath = outputPath
                .concat("/").concat(outputFileName)
                .concat(".").concat(outputFormat);
        if (!SupportedMediaFormats.isSupportedMediaType(extension)) {
            throw new UnsupportedFileFormatException(Constants.FILE_FORMAT + extension + Constants.IS_NOT_SUPPORTED);
        }
        if (!SupportedMediaFormats.isSupportedMediaType(outputFormat)) {
            throw new UnsupportedFileFormatException(Constants.FILE_FORMAT + outputFormat + Constants.IS_NOT_SUPPORTED);
        }
        FileHelper fileHelper = new FileHelper();
        if (fileHelper.fileExists(outputFilePath)) {
            throw new FileAlreadyExistsException(Constants.FILE_ALREADY_EXISTS);
        }
        FFMpeg ffMpeg = new FFMpeg(fileHelper
                .getFileFromResource(Constants.FILE_NAME));
        List<String> commands = new ArrayList<>();
        commands.add(ffMpeg.getFfmpegPath());
        commands.add(Constants.INPUT);
        commands.add(inputFilePath);
        Conversion.addQualityEnforcementCommands(commands, outputFormat);
        commands.add(outputFilePath);

        ProcessBuilder builder = new ProcessBuilder(commands);
        try {
            Process process = builder.start();
            InputStream errorStream = process.getErrorStream();
            InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            if (bufferedReader != null)
                bufferedReader.close();
            if (inputStreamReader != null)
                inputStreamReader.close();
            if (errorStream != null)
                errorStream.close();
        } catch (IOException e) {
            try {
                throw new IllegalAccessException(e.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
        }
    }
}
