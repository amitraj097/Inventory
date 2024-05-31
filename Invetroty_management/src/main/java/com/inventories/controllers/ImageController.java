package com.inventories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inventories.entities.Image;
import com.inventories.services.ImageService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api")
public class ImageController {

	@Autowired
	private ImageService imageService;

	@PostMapping("/uploadImage")
	public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {

		try {
			Image image= imageService.saveImage(file);
			return ResponseEntity.ok("Image Upload successfully");
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
		}
	}
	
	@GetMapping("/getImage/{id}")
	public ResponseEntity<byte[]> getImage (@PathVariable Long id) {
		
		Image image = imageService.getImage(id);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(image.getData());
	}
}
