package com.murphy.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.murphy.service.ImageService;

/**
 */
@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    /**
     * Parse base64 encoded image string into byte array. This array represents the image itself and it can be saved
     * into file system.
     *
     * @param imageInBase64
     *
     * @return
     */
    @Override
    public byte[] parseBase64(String imageInBase64) {
        return Base64.getDecoder().decode(imageInBase64);
    }

    /**
     * Save the image in byte array into file system.
     *
     * @param fileName
     * @param data
     * @throws java.io.IOException
     */
    @Override
    public void saveFile(String fileName, byte[] data) throws IOException {
        File file = new File(fileName);
        try (FileOutputStream stream = new FileOutputStream(file)) {
            stream.write(data);
        } catch (IOException e) {
            throw e;
        }
    }
}