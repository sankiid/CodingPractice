package com.design.tinyurl;

/**
 * Created by sandeep on 16/2/17.
 */
public class EncoderContext {
    private Encoder encoder;

    public EncoderContext(Encoder encoder) {
        this.encoder = encoder;
    }

    public String encode(String key) {
       return encoder.encode(key);
    }
}
