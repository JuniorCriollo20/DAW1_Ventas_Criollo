package com.cibertec.test;

import com.cibertec.dao.EmpleadoDao;
import com.cibertec.dao.impl.EmpleadoDaoImpl;
import com.cibertec.model.Empleado;



public class EmpleadoListarPorIdTest {

	public static void main(String[] args) {

		EmpleadoDao dao = new EmpleadoDaoImpl();
		Empleado empleado = dao.buscarEmpleado(1);
		System.out.println(empleado);
	}
}


