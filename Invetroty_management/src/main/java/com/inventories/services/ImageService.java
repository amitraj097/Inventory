package com.inventories.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inventories.entities.Image;
import com.inventories.exceptions.ResourceNotFoundException;
import com.inventories.repositories.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;

	public Image saveImage(MultipartFile file) throws IOException {

		Image image = new Image();
		image.setData(file.getBytes());
		return imageRepository.save(image);
	}

	public Image getImage(Long id) {

		return imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Image not found"));
	}
}
