package com.fanalca.empleados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fanalca.empleados.models.TipoDocumento;
import com.fanalca.empleados.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoService implements TipoDocumentoRepository{

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	@Override
	public List<TipoDocumento> findAll() {
		// TODO Auto-generated method stub
		return tipoDocumentoRepository.findAll();
	}

	@Override
	public List<TipoDocumento> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public <S extends TipoDocumento> S update(Integer id, S entity) {
		// TODO Auto-generated method stub
		entity.setId(id);		
		return tipoDocumentoRepository.save(entity);
	}

	@Override
	public List<TipoDocumento> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends TipoDocumento> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends TipoDocumento> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends TipoDocumento> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<TipoDocumento> entities) {
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
	public TipoDocumento getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoDocumento getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends TipoDocumento> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends TipoDocumento> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<TipoDocumento> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends TipoDocumento> S save(S entity) {
		// TODO Auto-generated method stub
		return tipoDocumentoRepository.save(entity);
	}

	@Override
	public Optional<TipoDocumento> findById(Integer id) {
		// TODO Auto-generated method stub
		return tipoDocumentoRepository.findById(id);
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
		tipoDocumentoRepository.deleteById(id);
	}

	@Override
	public void delete(TipoDocumento entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends TipoDocumento> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends TipoDocumento> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends TipoDocumento> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends TipoDocumento> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends TipoDocumento> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
