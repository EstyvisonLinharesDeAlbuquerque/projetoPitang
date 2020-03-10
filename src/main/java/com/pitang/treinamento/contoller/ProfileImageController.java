package com.pitang.treinamento.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ProfileImageController {

	// Save the uploaded file to this folder
	private static String UPLOADED_FOLDER = "C:\\Users\\Gedenilson\\Desktop\\Planos de fundo\\Ahri_0.jpg";

	@GetMapping("/")
	public String index() {
		return "upload";
	}

	@PostMapping("/upload") // //new annotation since 4.3
	public ResponseEntity<?> singleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		try {

			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>("Upload feito com sucesso!",HttpStatus.OK);
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}
}