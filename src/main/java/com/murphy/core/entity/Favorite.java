package com.murphy.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Favorite {

    private String name;
    private String[] imagesInBase64;
}

