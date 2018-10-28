package com.spi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.spi.entity.FileMapping;
import com.spi.exception.ErrorResponse;
import com.spi.loader.FacultyFileUploader;
import com.spi.loader.FileLoader;
import com.spi.loader.StudentFileUploader;
import com.spi.repository.FileMappingRepository;
import com.spi.services.StorageService;

@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,
		RequestMethod.POST })
@RestController
@RequestMapping("/api/upload")
public class UploadController {

	@Autowired
	StorageService storageService;

	List<String> files = new ArrayList<String>();

	@Autowired
	private FileMappingRepository fileMappingRepository;

	@Autowired
	private FacultyFileUploader facultyFileUploader;

	@Autowired
	private StudentFileUploader studentFileUploader;

	@PostMapping("/post")
	public ResponseEntity<ErrorResponse> handleFileUpload(@RequestParam("file") MultipartFile file,
			@RequestParam("file_type") String file_type, @RequestParam("file_name") String file_name) {
		String message = "";
		List<String> errList = new ArrayList<String>();
		ErrorResponse error = new ErrorResponse();
		FileLoader loader = null;
		try {

			FileMapping mapper = fileMappingRepository.findByFileName(file_name);
			if (null != mapper) {
				String storedPath = storageService.store(file, mapper.getArchivePath(), mapper.getFileName());
				files.add(file.getOriginalFilename());
				loader = getFileLoader(mapper, storedPath);
				loader.setPath(storedPath);
				loader.setMapper(mapper);
				loader.preLoad();
				loader.validate();
				loader.Load();

				message = "File is uploaded sucessfully" + file_type;
				System.out.println(message);
				if (null != loader && null != loader.getExpList() && loader.getExpList().size() > 0) {
					errList.addAll(loader.getExpList().stream().map(i -> i.getMessage()).collect(Collectors.toList()));
					error.setCode(417);
					error.setMessages(errList);
				} else {
					error.setCode(200);
					errList.add(message);
					error.setMessages(errList);
				}

			}

			return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			e.printStackTrace();
			error.setCode(417);

			errList.add(message);

			error.setMessages(errList);

			return new ResponseEntity<ErrorResponse>(error, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/getallfiles")
	public ResponseEntity<List<String>> getListFiles(Model model) {
		List<String> fileNames = files
				.stream().map(fileName -> MvcUriComponentsBuilder
						.fromMethodName(UploadController.class, "getFile", fileName).build().toString())
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(fileNames);
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@GetMapping("/templates/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getTemplatesFile(@PathVariable String filename) {
		Resource file = storageService.loadTemplateFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	private FileLoader getFileLoader(FileMapping mapper, String storedPath) {

		if (mapper.getLoader().equalsIgnoreCase("FacultyFileLoader")) {
			return facultyFileUploader;
		} else if (mapper.getLoader().equalsIgnoreCase("studentFileUploader")) {
			return studentFileUploader;
		}
		return null;
	}

}