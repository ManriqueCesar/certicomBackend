package com.certicom.app.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.certicom.app.model.entity.DetalleVenta;
public interface DetalleVentaRepository extends CrudRepository<DetalleVenta, Long> {

	@Query("SELECT d FROM DetalleVenta d WHERE d.venta.id =:idVenta")
	public ArrayList<DetalleVenta> findByIdVenta(Long idVenta);
	
	@Query("SELECT d FROM DetalleVenta d WHERE d.venta.fecha =:fecha")
	public ArrayList<DetalleVenta> findByFecha(Date fecha);

}
