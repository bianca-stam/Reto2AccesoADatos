package Reto2;

import java.io.Serializable;

public class Libro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String titulo;
    private String autor;
    private int año;
    private int ventas;
    
    // Para utilizar XStream el constructor debe estar vacío
    public Libro() {}

     public Libro(String titulo, String autor, int año, int ventas) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.ventas = ventas;
    }

    public String getTitulo() {
    	return titulo; 
    }
    
    public String getAutor() { 
    	return autor; 
    }
    
    public int getAño() { 
    	return año; 
    }
    
    public int getVentas() { 
    	return ventas; 
    }
    
    public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public void setVentas(int ventas) {
		this.ventas = ventas;
	}

    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + año + "). Ventas: " + ventas;
    }
}

	
