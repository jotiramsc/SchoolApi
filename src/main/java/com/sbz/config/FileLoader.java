package com.sbz.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.sbz.entity.FileMapping;
import com.sbz.exception.SBZException;

public abstract class FileLoader {

	FileMapping mapper = null;
	List<String> headers = new ArrayList<String>();
	List<String> fileHeaders = new ArrayList<String>();
	String path = null;
	List<HashMap<String, String>> dataList = null;

	List<SBZException> expList = new ArrayList<SBZException>();

	public FileLoader() {
		super();
		expList = new ArrayList<SBZException>();
		// TODO Auto-generated constructor stub
	}

	public void setExpList(List<SBZException> expList) {
		this.expList = expList;
	}

	public FileMapping getMapper() {
		return mapper;
	}

	public void setMapper(FileMapping mapper) {
		this.mapper = mapper;
	}

	public List<String> getHeaders() {
		return headers;
	}

	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}

	public List<String> getFileHeaders() {
		return fileHeaders;
	}

	public void setFileHeaders(List<String> fileHeaders) {
		this.fileHeaders = fileHeaders;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<HashMap<String, String>> getDataList() {
		return dataList;
	}

	public void setDataList(List<HashMap<String, String>> dataList) {
		this.dataList = dataList;
	}

	public List<SBZException> getExpList() {
		return expList;
	}

	public FileLoader(FileMapping mapper, String storedPath) {
		super();
		this.mapper = mapper;
		this.path = storedPath;
		dataList = new ArrayList<HashMap<String, String>>();
		expList = new ArrayList<SBZException>();
	}

	public List<String> readFileHeaders() {
		List<String> header = new ArrayList<>();
		Path pathToFile = Paths.get(path);

		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();

			while (line != null) {

				String[] attributes = line.split(",");
				Collections.addAll(header, attributes);

				break;
				// line = br.readLine();

			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return header;
	}

	public void readFileData() {

		Path pathToFile = Paths.get(path);

		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			HashMap<String, String> hm = null;
			this.dataList = new ArrayList<HashMap<String, String>>();
			String dataLine = br.readLine();
			while (dataLine != null) {

				hm = new HashMap<String, String>();
				String[] attributes = dataLine.split(",");

				for (int i = 0; i < attributes.length; i++) {

					hm.put(this.headers.get(i), attributes[i]);

				}
				dataList.add(hm);

				dataLine = br.readLine();

			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public List<String> getHeader() {
		String[] headerArray = this.mapper.getHeaders().split(",");
		List<String> headers = new ArrayList<String>();
		Collections.addAll(headers, headerArray);
		return headers;
	}

	public boolean validateHeader() throws SBZException {

		if (null == fileHeaders) {
			throw new SBZException("File does not having header's");
		}

		if (headers.size() != fileHeaders.size()) {
			throw new SBZException("File headers are not matching");
		}

		for (Iterator iterator = headers.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if (!fileHeaders.stream().anyMatch(t -> t.equalsIgnoreCase(string))) {
				throw new SBZException("No matching header found for '" + string + "' in file");
			}

		}
		for (int i = 0; i < headers.size(); i++) {

			if (!headers.get(i).equalsIgnoreCase(fileHeaders.get(i))) {
				throw new SBZException("Sequence of '" + headers.get(i) + "' does not match in file");

			}
		}

		return true;

	}

	public abstract void validate() throws SBZException;

	public abstract void preLoad();

	public abstract void Load();

	public abstract void postLoad();

}
