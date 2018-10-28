package com.spi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spi.entity.ClassSubMapper;
import com.spi.repository.ClassSubMapperRepository;

@Service
public class ClassSubMapperService {

	@Autowired
	private ClassSubMapperRepository mapperRepository;

	public List<ClassSubMapper> getClassSubMappersByClass(int sem_id) {
		return mapperRepository.getByCourseClassId(sem_id);
	}

	public List<ClassSubMapper> getClassSubMappers() {
		return mapperRepository.findAll();
	}

	public List<ClassSubMapper> addClassSubMappers(List<ClassSubMapper> subjectMappers) {

		if (subjectMappers != null && subjectMappers.size() > 0 && subjectMappers.get(0) != null) {
			mapperRepository.deleteByCourseClassId(subjectMappers.get(0).getCourseClass().getId());
		}
		return mapperRepository.saveAll(subjectMappers);
	}

	public ClassSubMapper updateClassSubMapper(ClassSubMapper ClassSubMapper) {
		return mapperRepository.save(ClassSubMapper);
	}

	public void deleteClassSubMapper(int id) {
		mapperRepository.deleteById(id);

	}

}
