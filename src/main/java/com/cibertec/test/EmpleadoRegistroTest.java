package com.cibertec.test;

import com.cibertec.dao.EmpleadoDao;
import com.cibertec.dao.impl.EmpleadoDaoImpl;
import com.cibertec.model.Empleado;

public class EmpleadoRegistroTest {

	public static void main(String[] args) {
		EmpleadoDao dao = new EmpleadoDaoImpl();
		
		Empleado empleado = new Empleado();
		empleado.setNombre("Aurelio");;
		empleado.setApellidos("Terrones");
		empleado.setDni("76543212");
		String mensaje = dao.registrarEmpleado(empleado);
		System.out.println(mensaje);
	}
}



