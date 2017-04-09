package com.murphy.service;

import java.io.IOException;

/**
 * Provides image related functionalities.
 */
public interface ImageService {

    public byte[] parseBase64(String imageInBase64);

    public void saveFile(String fileName, byte[] data) throws IOException;
}