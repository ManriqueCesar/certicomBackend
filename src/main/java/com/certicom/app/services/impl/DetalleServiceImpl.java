package com.certicom.app.services.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.certicom.app.model.entity.DetalleVenta;
import com.certicom.app.model.entity.Venta;
import com.certicom.app.repository.DetalleVentaRepository;
import com.certicom.app.services.DetalleVentaService;

@Service
public class DetalleServiceImpl implements DetalleVentaService {

	private final Logger LOGGER = Logger.getLogger(DetalleVentaService.class.getName());

	@Autowired
	DetalleVentaRepository detalleVentaRepo;

	@Override
	public ResponseEntity<?> findByVentaId(Long idVenta) {
		try {
			ArrayList<DetalleVenta> detalle = detalleVentaRepo.findByIdVenta(idVenta);

			if (detalle.isEmpty()) {
				HashMap<String, Object> response = new HashMap<>();
				response.put("mensaje", "No se encontraron resultados");

				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

			} else {
				HashMap<String, Object> response = new HashMap<>();
				response.put("mensaje", "Se realizó la consulta correctamente");
				response.put("response", detalle);

				return ResponseEntity.status(HttpStatus.OK).body(response);
			}

		} catch (Exception e) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("mensaje", "Ocurrió un error inesperado");
			LOGGER.log(Level.SEVERE, e.getMessage(), e);

			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(response);

		}

	}

	@Override
	public ResponseEntity<?> getAll() {
		try {
			ArrayList<DetalleVenta> lstDetalle  = (ArrayList<DetalleVenta>) detalleVentaRepo.findAll();

			if (lstDetalle.isEmpty()) {
				HashMap<String, Object> response = new HashMap<>();
				response.put("mensaje", "No se encontraron resultados");
				
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

			} else {
				HashMap<String, Object> response = new HashMap<>();
				response.put("mensaje", "Se realizó la consulta correctamente");
				response.put("response", lstDetalle);

				return ResponseEntity.status(HttpStatus.OK).body(response);
			}

		} catch (Exception e) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("mensaje", "Ocurrió un error inesperado");
			LOGGER.log(Level.SEVERE, e.getMessage(), e);

			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(response);

		}
	}

	@Override
	public ResponseEntity<?> findByDate(String fecha) {
		try {
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date langDate = sdf.parse(fecha);
		    java.sql.Date sqlDate = new java.sql.Date(langDate.getTime());
			ArrayList<DetalleVenta> lstDetalle  = (ArrayList<DetalleVenta>) detalleVentaRepo.findByFecha(sqlDate);

			if (lstDetalle.isEmpty()) {
				HashMap<String, Object> response = new HashMap<>();
				response.put("mensaje", "No se encontraron resultados");
				response.put("response", null);
				return ResponseEntity.status(HttpStatus.OK).body(response);

			} else {
				HashMap<String, Object> response = new HashMap<>();
				response.put("mensaje", "Se realizó la consulta correctamente");
				response.put("response", lstDetalle);

				return ResponseEntity.status(HttpStatus.OK).body(response);
			}

		} catch (Exception e) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("mensaje", "Ocurrió un error inesperado");
			LOGGER.log(Level.SEVERE, e.getMessage(), e);

			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(response);

		}
	}
		
}
