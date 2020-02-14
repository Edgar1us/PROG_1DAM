package departamento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Departamento {

	private String nombre;
	private int max_user;
	private ArrayList<Usuario> usuarios;
	
	public Departamento() {
		this.nombre = "";
		this.max_user = 10;
		this.usuarios = new ArrayList<Usuario>();
	}

	public Departamento(String nombre, int m) {
		this.nombre = nombre;
		this.max_user = m;
		this.usuarios = new ArrayList<Usuario>();
	}

	public String getNombre() {
		return nombre;
	}
	

	public int getMax_user() {
		return max_user;
	}

	public void setMax_user(int max_user) {
		this.max_user = max_user;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void añadirUsuario() {
		
		if (numeroUsuarios() < getMax_user()) {
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("Nombre de usuario: ");
			String nombre = teclado.nextLine();
			
			System.out.println("Contraseña: ");
			String pass = teclado.nextLine();
			
			Usuario user = new Usuario(nombre,pass);
			
			usuarios.add(user);
		}
		else {
			System.out.println("No se pueden añadir mas usuarios");
		}
		
	}
	
	public void modificarUsuario() {
		
		if (numeroUsuarios() != 0) {
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("Nombre de usuario: ");
			String nombre = teclado.nextLine();
			
			for (Usuario u : usuarios) {
				if(u.getNombre().equals(nombre)){
					System.out.println("Nombre: ");
					nombre = teclado.nextLine();
					System.out.println("Contraseña: ");
					String pass = teclado.nextLine();
					u.setContraseña(nombre);
					u.setContraseña(pass);
					u.setEncriptada(false);
				}
			}		
	
		}
		else {
			System.out.println("No hay usuarios");
		}
		
	}
	public void eliminarUsuarios() {
		if (numeroUsuarios() != 0) {
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("Nombre de usuario: ");
			String nombre = teclado.nextLine();
			
			Iterator it = usuarios.iterator();
			while (it.hasNext()) {
				Usuario u = (Usuario)it.next();
				if (u.getNombre().equals(nombre)) {
					it.remove();
					System.out.println("Borrado con exito");
				}
				
			}
			
		}
		else {
			System.out.println("No se pueden añadir mas usuarios");
		}
	}
	public int numeroUsuarios() {
		return usuarios.size();
	}
	
	public void visualizarDatos() {
		System.out.println("Departamento: " + getNombre());
		System.out.println("Maximo de usuarios: " + getMax_user());
		System.out.println("Numero de usuarios: " + numeroUsuarios());
		System.out.println("Usuarios: " );
		for (Usuario u : usuarios) {
				usuarios.remove(u);
		}
	}
	
	public void visualizarUsuariosEnc() {
		
		System.out.println("Departamento: " + getNombre());
		System.out.println("Usuarios con contraseñas encriptadas: " );
		for (Usuario u : usuarios) {
			
			if (u.isEncriptada()) {
				u.imprimirUsuario();
			}
			
		}
	}
	
	public void visualizarUsuariosSinEnc() {
		
		System.out.println("Departamento: " + getNombre());

		System.out.println("Usuarios con contraseñas sin encriptar: " );
		for (Usuario u : usuarios) {
			
			if (!u.isEncriptada()) {
				u.imprimirUsuario();
			}
			
		}
	}
	public void encriptarContraseña() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Nombre de usuario: ");
		String nombre = teclado.nextLine();
		
		for (Usuario u : usuarios) {
			
			if (u.getNombre().equals(nombre)) {
				u.encriptar();
			}
			
		}
	}
	public void desencriptarContraseña() {
		for (Usuario u : usuarios) {
			
			if (u.getNombre().equals(nombre)) {
				u.desencriptar();
			}
			
		}
	}
	
	
}
