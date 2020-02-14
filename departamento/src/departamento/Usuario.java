package departamento;

public class Usuario {

	private String nombre;
	private String contraseña;
	private boolean encriptada;
	
	
	public Usuario() {
		this.nombre = "" ;
		this.contraseña = "" ;
		this.encriptada = false;
	}

	public Usuario(String nombre, String contraseña) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.encriptada = false;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public boolean isEncriptada() {
		return encriptada;
	}

	public void setEncriptada(boolean encriptada) {
		this.encriptada = encriptada;
	}
	
	public void encriptar() {
		int pos = 3;
		char c;
		String encrip = "";
		for (int i = 0; i < getContraseña().length(); i++) {
			c = (char)(getContraseña().charAt(i) + 3);
			encrip += c;
		}
		setContraseña(encrip);
		setEncriptada(true);
	}
	
	public void desencriptar() {
		int pos = 3;
		char c;
		String encrip = "";
		for (int i = 0; i < getContraseña().length(); i++) {
			c = (char)(getContraseña().charAt(i) - 3);
			encrip += c;
		}
		setContraseña(encrip);
		setEncriptada(false);
	}
	
	public void imprimirUsuario() {
		System.out.println(getNombre());
		
		
	}
	
	
}