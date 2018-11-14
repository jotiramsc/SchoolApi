package com.spi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spi.model.audit.UserDateAudit;

@Entity
@Table(name = "FILE_MAPPING")
public class FileMapping extends UserDateAudit{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5182430157381038918L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String fileName;

	@Column
	private String fileType;	

	@Column
	private String archivePath;
	
	@Column
	private String loader;
	
	@Column(length = 2500)
	private String headers;

	
	
	public FileMapping() {
		super();
		// TODO Auto-generated constructor stub
	}



	public FileMapping(String fileName, String fileType, String archivePath, String loader, String headers) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.archivePath = archivePath;
		this.loader = loader;
		this.headers = headers;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public String getFileType() {
		return fileType;
	}



	public void setFileType(String fileType) {
		this.fileType = fileType;
	}



	public String getArchivePath() {
		return archivePath;
	}



	public void setArchivePath(String archivePath) {
		this.archivePath = archivePath;
	}



	public String getLoader() {
		return loader;
	}



	public void setLoader(String loader) {
		this.loader = loader;
	}



	public String getHeaders() {
		return headers;
	}



	public void setHeaders(String headers) {
		this.headers = headers;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((archivePath == null) ? 0 : archivePath.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result + ((headers == null) ? 0 : headers.hashCode());
		result = prime * result + id;
		result = prime * result + ((loader == null) ? 0 : loader.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileMapping other = (FileMapping) obj;
		if (archivePath == null) {
			if (other.archivePath != null)
				return false;
		} else if (!archivePath.equals(other.archivePath))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (fileType == null) {
			if (other.fileType != null)
				return false;
		} else if (!fileType.equals(other.fileType))
			return false;
		if (headers == null) {
			if (other.headers != null)
				return false;
		} else if (!headers.equals(other.headers))
			return false;
		if (id != other.id)
			return false;
		if (loader == null) {
			if (other.loader != null)
				return false;
		} else if (!loader.equals(other.loader))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "FileMapping [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", archivePath="
				+ archivePath + ", loader=" + loader + ", headers=" + headers + "]";
	}

	

	
	
	

}