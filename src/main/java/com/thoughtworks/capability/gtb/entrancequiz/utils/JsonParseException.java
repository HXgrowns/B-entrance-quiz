package com.thoughtworks.capability.gtb.entrancequiz.utils;

import java.io.IOException;

public class JsonParseException extends RuntimeException {

    public JsonParseException(IOException ex) {
        super(ex);
    }
}

