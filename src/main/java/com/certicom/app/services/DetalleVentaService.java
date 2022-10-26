package com.certicom.app.services;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DetalleVentaService {
	
	public ResponseEntity<?> findByVentaId (Long idVenta);

	public ResponseEntity<?> getAll();

	public ResponseEntity<?> findByDate(String fecha); 

}
