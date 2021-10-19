package com.fanalca.empleados.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fanalca.empleados.models.SubArea;
import com.fanalca.empleados.repository.SubAreaRepository;

@Service
public class SubAreaService implements SubAreaRepository{
	
	@Autowired
	private SubAreaRepository subAreaRepository;	

	@Override
	public List<SubArea> findAll() {
		// TODO Auto-generated method stub
		return subAreaRepository.findAll();
	}
	
	public List<SubArea> findAllByArea(Long id) {
		List<SubArea> subAreasRespuesta = new ArrayList<>();
		List<SubArea> subAreas = subAreaRepository.findAll();
		for(int i = 0; i < subAreas.size(); i++) {
			if((subAreas.get(i)).getArea().getId() == id) {
				subAreasRespuesta.add(subAreas.get(i));
			}
		}
		return subAreasRespuesta;
	}
	
	public <S extends SubArea> S update(Integer id, S entity) {
		// TODO Auto-generated method stub
		entity.setId(id);		
		return subAreaRepository.save(entity);
	}

	@Override
	public List<SubArea> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubArea> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SubArea> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends SubArea> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SubArea> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<SubArea> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SubArea getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubArea getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SubArea> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SubArea> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SubArea> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SubArea> S save(S entity) {
		// TODO Auto-generated method stub
		return subAreaRepository.save(entity);
	}

	@Override
	public Optional<SubArea> findById(Integer id) {
		// TODO Auto-generated method stub
		return subAreaRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		subAreaRepository.deleteById(id);
	}

	@Override
	public void delete(SubArea entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends SubArea> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends SubArea> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SubArea> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SubArea> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends SubArea> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
