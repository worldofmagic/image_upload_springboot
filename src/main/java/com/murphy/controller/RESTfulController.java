package com.murphy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.murphy.core.entity.Favorite;
import com.murphy.service.ImageService;

@RestController
@Slf4j
public class RESTfulController
{

	@Autowired
	private ImageService imageService;




	@RequestMapping(value = "/favorite", method = RequestMethod.POST)
	public Object favorite(@RequestBody Favorite favorite,
			HttpServletResponse response)
	{
		String name = favorite.getName();
		String[] imagesInBase64 = favorite.getImagesInBase64();
		int count = 0;
		for (int i = 0; i < imagesInBase64.length; i++)
		{
			try
			{	
				byte[] image = imageService.parseBase64(imagesInBase64[i]);
				imageService.saveFile(String.format("%s%s.jpg", name, i + 1),
						image);
				count++;
			} catch (IOException ex)
			{
				log.error("Unable to save file", ex);
			}
		}
		return String.format("%d image(s) saved", count);
	}
}