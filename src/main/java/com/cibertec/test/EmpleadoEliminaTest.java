package com.cibertec.test;

import com.cibertec.dao.EmpleadoDao;
import com.cibertec.dao.impl.EmpleadoDaoImpl;


public class EmpleadoEliminaTest {

	public static void main(String[] args) {

		EmpleadoDao dao = new EmpleadoDaoImpl();
		
		String mensaje = dao.eliminarEmpleado(7);
		System.out.println(mensaje);
	}
}
