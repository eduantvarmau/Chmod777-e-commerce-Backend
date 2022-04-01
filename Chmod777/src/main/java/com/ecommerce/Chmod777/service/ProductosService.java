package com.ecommerce.Chmod777.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;


import com.ecommerce.Chmod777.model.Producto;

@Service
public class ProductosService {
	public final ArrayList<Producto> lista = new ArrayList<Producto>();
	public ProductosService() {
		lista.add(new Producto("Psicoterapia individual",800,"terapia-individual.jpg","En Dánika encontrarás un espacio terapéutico, que impulsará tu crecimiento  y redescubrimiento personal.","servicios"));
		lista.add(new Producto("Psicoterapia de pareja",800,"TerapiaPArejas.jpg","Las dificultades en la pareja son una etapa en toda relación. En Dánika la terapia es una oportunidad de escucha y entendimiento a través de un acompañamiento profesional con un enfoque de terapia.","servicios"));
		lista.add(new Producto("Psicoterapia de adolescentes",800,"terapiaAdolecentes.jpg","En Dánika se brinda un espacio para entender la adolescencia como una etapa de crucial para el desarrollo del paciente como de sus familiares.","servicios"));
		lista.add(new Producto("Psicoterapia grupal",800,"Psicoterapia grupal.jpg","La psicoterapia grupal esta basada en el trabajo  individual a  través de la experiencia  grupal, en Dánika se brinda un acompañamiento profesional para la guía y el autodescubrimiento de todos.","servicios"));
		lista.add(new Producto("Psicoterapia grupal para mamás",800,"terapiaMadres.jpg","Es un espacio para el descubrimiento de la maternidad, sus implicaciones, vivencias, aprendizajes y dificultades a través de un acompañamiento cercano y profesional.","servicios"));
		lista.add(new Producto("Taller reflexivo madres",1000,"tellerMamas.jpg","En Dánika ofrecemos un espacio para abordar preguntas, miedos, preocupaciones sobre temas relacionados a la concepción, crianza y otros temas relacionados con la experiencia de ser madres.","talleres"));
		lista.add(new Producto("Taller parejas",1000,"tallerParejas.jpg","Los talleres tienen como objetivo brindar herramientas a las parejas para la vinculación positiva: conocerse mejor, comprenderse, apoyarse desde un enfoque terapeútico.","talleres"));
		lista.add(new Producto("Taller crianza positiva",1000,"TallercrianzaPositiva.jpg","Conversatorios y conferencias para madres y padres sobre crianza, educación, maternidad y paternidad. Talleres de información para una maternidad y paternidad más feliz.  Organizamos talleres extraordinarios sobre otros temas de interés como adolescencia, celos entre hermanos.","talleres"));
		lista.add(new Producto("Taller adicciones",1000,"TallerAdicciones.jpg","El consumo de sustancias inicia en edades tempranas. En Dánika ofrecemos talleres psicoeducativos sobre adicciones, sus consecuencias y tratamientos ya que el trabajo preventivo es uno de nuestros objetivos principales.","talleres"));
		lista.add(new Producto("Taller psicoeducativo",1000,"tallerPsicoeducativo.jpg","Son talleres dirigidos a grupos, instituciones educativa y organizaciones. En Dánika nos preocupamos por ofrecer temáticas actualizadas y que se ajustan a las necesidades del cliente.","talleres"));
	}
	
	public ArrayList<Producto> getProductos() {
		return lista;
	}//getProducto

	public Producto getProducto(Long prodId) {
		Producto tmpProd = null;
		for (Producto producto : lista) {
			if (producto.getId()==prodId) {
				tmpProd = producto;
				break;
			}//if ==prodId
		}//foreach
		return tmpProd; 
	}//getproducto

	public Producto addProducto(Producto producto) {
		lista.add(producto);
		return producto;
	}//addPtoducto
	
	//metodo para borrar en el servicio
    public Producto deleteProducto(Long prodId) {
        Producto tmpProd = null;
        for (Producto producto : lista) {
            if (producto.getId()==prodId) {
                tmpProd = lista.remove(lista.indexOf(producto));
                break;
            }//if == prodId
        }//foreach
        return tmpProd;
    }
	
}//class ProductosService
