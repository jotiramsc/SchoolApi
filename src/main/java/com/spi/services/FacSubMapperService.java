package com.spi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spi.entity.FacSubMapper;
import com.spi.repository.FacSubMapperRepository;

@Service
public class FacSubMapperService {

	@Autowired
	private FacSubMapperRepository mapperRepository;

	@GetMapping("/{sem_id}")
	public List<FacSubMapper> getFacSubMappersBySem(@PathVariable int sem_id) {
		return mapperRepository.getByFaculty_id(sem_id);
	}

	public List<FacSubMapper> getFacSubMappers() {
		return mapperRepository.findAll();
	}

	public List<FacSubMapper> addFacSubMappers(List<FacSubMapper> subjectMappers) {

		if (subjectMappers != null && subjectMappers.size() > 0 && subjectMappers.get(0) != null) {
			mapperRepository.deleteByFaculty_id(subjectMappers.get(0).getFaculty().getId());
		}
		return mapperRepository.saveAll(subjectMappers);
	}

	public FacSubMapper updateFacSubMapper(FacSubMapper FacSubMapper) {
		mapperRepository.save(FacSubMapper);
		return mapperRepository.save(FacSubMapper);
	}

	public void deleteFacSubMapper(int id) {
		mapperRepository.deleteById(id);

	}

}
