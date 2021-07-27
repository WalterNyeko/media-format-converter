package com.commands;

import com.helpers.Constants;
import java.util.List;

public class Conversion {

    public static List<String> addQualityEnforcementCommands(
            List<String> existingCommands, String outputFormat) {
        if (outputFormat.startsWith(Constants.O)) {
            existingCommands.add(Constants.VIDEO_STREAM_CODEC);
            existingCommands.add(Constants.LIBTHEORA);
            existingCommands.add(Constants.VIDEO_QUALITY);
            existingCommands.add(Constants.SEVEN);
            existingCommands.add(Constants.AUDIO_STREAM_CODEC);
            existingCommands.add(Constants.LIBVORBIS);
            existingCommands.add(Constants.AUDIO_QUALITY);
            existingCommands.add(Constants.FOUR);
        }else {
            existingCommands.add(Constants.STRICT);
            existingCommands.add(Constants.EXPERIMENTAL);
            existingCommands.add(Constants.MAINTAIN_VIDEO_QUALITY);
            existingCommands.add(Constants.ZERO);
        }
        return existingCommands;
    }
}
