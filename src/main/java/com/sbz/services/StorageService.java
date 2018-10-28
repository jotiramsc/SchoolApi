package com.sbz.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {
 
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("upload-dir");
 
	private final Path templateLocation = Paths.get("template");
	public String store(MultipartFile file, String dirPath, String file_name) {
		try {
			File dir = new File("upload-dir/"+dirPath);
			if(!dir.exists())
				dir.mkdir();	
			
			file_name = file_name+"_"+System.currentTimeMillis()+".csv";
			
			String newPath = dir.getAbsolutePath()+"\\"+file_name;
			
			File checkFile = new File(newPath);
			if(!checkFile.exists())
				checkFile.delete();
			
			Files.copy(file.getInputStream(), this.rootLocation.resolve(dirPath+"\\"+file_name));
			System.out.println(newPath);
			return newPath;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("FAIL!");
		}
	}
 
	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}
 
	public Resource loadTemplateFile(String filename) {
		try {
			Path file = templateLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}
 
	public void init() {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}
}