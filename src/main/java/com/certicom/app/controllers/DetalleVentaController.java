package com.certicom.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.certicom.app.services.DetalleVentaService;


@RestController
@RequestMapping("/detalleVenta")
public class DetalleVentaController {

	@Autowired
	private DetalleVentaService detalleService;
	
	@GetMapping("findByIdVenta/{idVenta}")
	public ResponseEntity<?> findByVentaId(@PathVariable Long idVenta) {
		return detalleService.findByVentaId(idVenta);
	}
	
	@GetMapping("findByDate/{fecha}")
	public ResponseEntity<?> findByDate(@PathVariable String fecha) {
		return detalleService.findByDate(fecha);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		return detalleService.getAll();
	}
	
	
}
