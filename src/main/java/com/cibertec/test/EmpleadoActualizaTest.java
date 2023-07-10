package com.cibertec.test;

import com.cibertec.dao.EmpleadoDao;
import com.cibertec.dao.impl.EmpleadoDaoImpl;
import com.cibertec.model.Empleado;


public class EmpleadoActualizaTest {

	public static void main(String[] args) {
		
		EmpleadoDao dao = new EmpleadoDaoImpl();
		
		Empleado empleado = dao.buscarEmpleado(3);
		System.out.println(empleado);
		
		empleado.setNombre("Agata");
		String mensaje = dao.actualizarEmpleado(empleado);
		System.out.println(mensaje);
		System.out.println(empleado);
	}
}







