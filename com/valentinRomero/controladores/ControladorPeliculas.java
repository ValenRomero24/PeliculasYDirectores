package com.valentinRomero.controladores;

import java.util.HashMap;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPeliculas {
	private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();

	public ControladorPeliculas() {
		listaPeliculas.put("Winnie the Pooh", "Don Hall");	
		listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
		listaPeliculas.put("Tarzán", "Kevin Lima");		
		listaPeliculas.put("Mulán", "Barry Cook");
		listaPeliculas.put("Oliver", "Kevin Lima");	
		listaPeliculas.put("Big Hero 6", "Don Hall");
	}
	
	@GetMapping("/peliculas")
	public String obtenerTodasLasPeliculas() {
		String lista= "";
		
		Set<String> claves = listaPeliculas.keySet();
		for (String clave: claves) {
			lista += "<li>"+clave+"</li>";
		}
		return "<ul>"+lista+"</ul>";
	}
	
	@GetMapping("/peliculas/{nombrePelicula}")
	public String obtenerPeliculaPorNombre(@PathVariable("nombrePelicula") String nombrePelicula) {
		String aux = listaPeliculas.get(nombrePelicula);
		if (aux != null) {
			return "Pelicula: "+ nombrePelicula +" Director: "+ aux;
		}
		else return "La película no se encuentra en nuestra lista.";
	}
	
	@GetMapping("peliculas/director/{nombreDirector}")
	public String obtenerPeliculasPorDirector(@PathVariable String nombreDirector) {
		if (listaPeliculas.containsValue(nombreDirector)) {
			String lista = "";
			Set<String> claves = listaPeliculas.keySet();
			for (String clave: claves) {
				if (listaPeliculas.get(clave).equals(nombreDirector)) {
					lista += "<li>" + clave +"</li>";
				}
			}
			return "<ul>"+ lista + "</ul>";
		}
		else return "No contamos con películas con ese director en nuestra lista.";
	}
}
