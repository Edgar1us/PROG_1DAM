package departamento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Aplicacion {

	public static void main(String[] args) {
	int opc = 0 ;
	Scanner teclado = new Scanner (System.in);
	
	ArrayList<Departamento> depart = new ArrayList<Departamento>(); 

	do {
			menu1();
			opc = Integer.parseInt(teclado.nextLine());
			switch (opc) {
			case 1:
				crearDepartamento(depart);
				break;

			case 2:
				borrarDepartemento(depart);
				break;
				
			case 3:
				gestionarDepartamento(depart);
				break;
				
			case 4:
				verDepartamento(depart);
				break;
				
			case 5:
				System.out.println("Adios");
				break;
				
			
			default:
				System.out.println("Opcion no valida.......");
			}
		} while (opc != 5);
	
	
		
	}
	
	public static void menu1() {
		System.out.println("1.-Crear departamento");
		System.out.println("2.-Borrar departamento");
		System.out.println("3.-Gestionar departamento");
		System.out.println("4.-Ver departamento");
		System.out.println("5.-Salir");
		System.out.println("Elige una opcion: ");
	}
	
	public static void menu2() {
		System.out.println("1.-Añadir usuario");
		System.out.println("2.-Eliminar usuario");
		System.out.println("3.-Modificar usuario");
		System.out.println("4.-Encriptar contraseña");
		System.out.println("5.-Desencriptar contraseña");
		System.out.println("6.-Visualizar datos del departamento");
		System.out.println("7.-Visualizar usuarios (encrip)");
		System.out.println("8.-Visualizar usuarios (desenc)");
		System.out.println("9.-Salir");
		System.out.println("Elige una opcion: ");
	
	}
	public static void crearDepartamento(ArrayList<Departamento> lista_dep) {
		Scanner teclado = new Scanner(System.in);
		
		try {
			boolean existe ;
			String nombre;
			do {
				existe = false;
				System.out.println("Introduce el nombre del departamento");
				nombre = teclado.nextLine();
				for (Departamento d : lista_dep) {
					if (d.getNombre().equals(nombre)) {
						System.out.println("El departamento ya existe");
						existe = true;
					}
				}
			} while (existe);
			
			System.out.println("Introduce el max de usuarios: ");
			int max = Integer.parseInt(teclado.nextLine());
			Departamento d = new Departamento(nombre,max);
			lista_dep.add(d);
		} catch (Exception e) {
			System.out.println("ERROR...");
		}
	}
	
	public static void verDepartamento(ArrayList<Departamento> lista_dep) {
		System.out.println("Departementos: ");
		for (Departamento d : lista_dep) {
			System.out.println(d.getNombre());
		}
	}
	
	public static void borrarDepartemento(ArrayList<Departamento> lista_dep) {
		
			if (!lista_dep.isEmpty()) {
				Scanner teclado = new Scanner(System.in);
				
				System.out.println("Nombre de departamento: ");
				String nombre = teclado.nextLine();
				
				Iterator it = lista_dep.iterator();
				while (it.hasNext()) {
					Departamento d = (Departamento)it.next();
					if (d.getNombre().equals(nombre)) {
						it.remove();
						System.out.println("Borrado con exito");
					}
					
				}
				
			}
			else {
				System.out.println("No hay departamentos");
			}
		}
	
	
	public static void gestionarDepartamento(ArrayList<Departamento> lista_dep) {
		
		if (!lista_dep.isEmpty()) {
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("Nombre de departamento: ");
			String nombre = teclado.nextLine();
			
			Iterator it = lista_dep.iterator();
			while (it.hasNext()) {
				Departamento d = (Departamento)it.next();
				if (d.getNombre().equals(nombre)) {
					int opc = 0;
					
					do {
						menu2();
						opc = Integer.parseInt(teclado.nextLine());
						switch (opc) {
						case 1:
							d.añadirUsuario();
							break;

						case 2:
							d.eliminarUsuarios();
							break;
							
						case 3:
							d.modificarUsuario();
							break;
							
						case 4:
							d.encriptarContraseña();
							break;
							
						case 5:
							d.desencriptarContraseña();
							break;
							
						case 6:
							d.visualizarDatos();
							break;
							
						case 7:
							d.visualizarUsuariosEnc();
							break;
							
						case 8:
							d.visualizarUsuariosSinEnc();
							break;
							
						case 9:
							System.out.println("Adios");
							break;
					
						default:
							System.out.println("Opcion no valida.......");
						}
					} while (opc != 9);
				}
			}
				
			}
		else {
			System.out.println("No hay departamentos");
		}	
		}
	

}