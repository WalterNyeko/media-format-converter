package com.domain;

public class FFMpeg {
    private String ffmpegPath;

    public FFMpeg() {
    }

    public FFMpeg(String ffmpegPath) {
        this.ffmpegPath = ffmpegPath;
    }

    public String getFfmpegPath() {
        return ffmpegPath;
    }

    public void setFfmpegPath(String ffmpegPath) {
        this.ffmpegPath = ffmpegPath;
    }
}
