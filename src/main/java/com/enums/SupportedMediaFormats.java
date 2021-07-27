package com.enums;

public enum SupportedMediaFormats {
    MPEG_4("mp4", "An MP4 file is a multimedia file commonly used to store a movie or video clip"),
    MPEG_4_A("m4a", "An M4A file is an audio file saved in the MPEG-4 format"),
    MPEG_4_V("m4v", "An M4V file is an MPEG-4 file used to store video downloaded from the Apple iTunes store"),
    MPEG_4_B("m4b", "An M4B file is an audiobook most often used by Apple iTunes and Apple Books"),
    MPEG_4_F_V("f4v", "An F4V file is a video file saved in the video container format used by Adobe Flash"),
    MPEG_4_F_A("f4a", "Audio file created by Adobe Flash, an application used to develop rich Web content"),
    MPEG_4_MOV("mov", "A MOV file is a movie file saved in the QuickTime File Format (QTFF), which is a multimedia container file format"),
    OGG("ogg", "An OGG file is a compressed audio file that uses free, unpatented Ogg Theora Video and Vorbis audio compression"),
    OGG_OGV("ogv", "An OGV file is a video file saved in the Xiph.Org open source Ogg container format"),
    OGG_OGA("oga", "Audio container format that may use one of several encoding schemes, including Ogg FLAC, Ghost, and OggPCM"),
    OGG_OGX("ogx", "Multiplexed media file saved in the Ogg Vorbis container format"),
    WMV("wmv", "A WMV file is a video stored in the Microsoft Advanced Systems Format (ASF) and compressed with Windows Media Video compression"),
    WMA("wma", "A WMA file is an audio file saved in the Advanced Systems Format (ASF) proprietary format developed by Microsoft. It contains Windows Media Audio"),
    ASF("asf", "An ASF file is a media file stored in the Advanced Systems Format (ASF)"),
    WEBM("webm", "A WEBM file is a video saved in the WebM format, an open, royalty-free format designed for sharing video on the web"),
    FLV("flv", "An FLV file is a video file saved in the Adobe Flash Video (FLV) container format"),
    AVI("avi", "An AVI file is a video file saved in the Audio Video Interleave (AVI) multimedia container format created by Microsoft"),
    WAV("wav", "A WAV file is an audio file saved in the WAVE format, a standard digital audio file format utilized for storing waveform data"),
    VOB("vob", "A VOB file is a movie data file from a DVD disc, typically stored in the VIDEO_TS folder at the root of the DVD"),
    MKV("mkv", "An MKV file is a video file saved in the Matroska multimedia container format");

    private String format;
    private String formatDescription;

    SupportedMediaFormats(String format, String formatDescription) {
        this.format = format;
        this.formatDescription = formatDescription;
    }

    public static boolean isSupportedMediaType(String format) {
        for (SupportedMediaFormats supportedMediaFormats: SupportedMediaFormats.values()) {
            if (supportedMediaFormats.getFormat().equalsIgnoreCase(format)) {
                return true;
            }
        }
        return false;
    }

    public String getFormat() {
        return format;
    }

    public String getFormatDescription() {
        return formatDescription;
    }
}
