package com.cibertec.dao.impl;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.cibertec.dao.EmpleadoDao;
import com.cibertec.model.Empleado;

public class EmpleadoDaoImpl implements EmpleadoDao{
	
	private static final String REGISTRO_OK = "Se registró correctamente";
	private static final String REGISTRO_ERROR = "No se registró correctamente";
	
	private static final String ACTUALIZA_OK = "Se actualizó correctamente";
	private static final String ACTUALIZA_ERROR = "No se actualizó correctamente";
	
	private static final String ELIMINA_OK = "Se eliminó correctamente";
	private static final String ELIMINA_ERROR = "No se elimnó correctamente";
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("EMPLEADOCRUD");
	EntityManager manager = factory.createEntityManager();
	

	public String registrarEmpleado(Empleado empleado) {
		String mensaje = REGISTRO_ERROR;		
		if(!Objects.isNull(empleado)) {
			manager.getTransaction().begin();
			manager.persist(empleado);
			manager.getTransaction().commit();
			mensaje = REGISTRO_OK;
			manager.close();
		}
		return mensaje;
		
	}
	
	public Empleado buscarEmpleado(int idEmpleado) {
		return buscarEmpleadoId(idEmpleado);
	}
	private Empleado buscarEmpleadoId(int idEmpleado) {
		return manager.find(Empleado.class,idEmpleado);
	}
	
	
	public List<Empleado> listarEmpleado() {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Empleado> criteriaQuery = criteriaBuilder.createQuery(Empleado.class);
		Root<Empleado> registro = criteriaQuery.from(Empleado.class);
		CriteriaQuery<Empleado> todos = criteriaQuery.select(registro);
		TypedQuery<Empleado> lista = manager.createQuery(todos);
		return lista.getResultList();
	}
	
	public String actualizarEmpleado(Empleado Empleado) {
		String mensaje = ACTUALIZA_ERROR;
		Empleado objeto = buscarEmpleadoId(Empleado.getIdEmpleado());
		if(!Objects.isNull(objeto)) {
			manager.getTransaction().begin();
			objeto.setNombre(Empleado.getNombre());
			objeto.setApellidos(Empleado.getApellidos());
			objeto.setDni(Empleado.getDni());
			manager.getTransaction().commit();
			manager.close();
			mensaje= ACTUALIZA_OK;
		}
		return mensaje;
	}
	
	public String eliminarEmpleado(int idEmpleado) {
		String mensaje = ELIMINA_ERROR;
		Empleado objeto = buscarEmpleadoId(idEmpleado);
		if(!Objects.isNull(objeto)) {
			manager.getTransaction().begin();
			manager.remove(objeto);
			manager.getTransaction().commit();
			manager.close();
			mensaje = ELIMINA_OK;
		}
		
		return mensaje;
	}
	
}
