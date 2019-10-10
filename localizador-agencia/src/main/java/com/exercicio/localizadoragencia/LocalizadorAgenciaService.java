package com.exercicio.localizadoragencia;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LocalizadorAgenciaService {

    public ArrayList<String> localizaAgencia(String cidade) {
    	if (cidade.contentEquals("BH")) {
    		ArrayList<String> lista = new ArrayList<String>();
    		lista.add("1234");
    		lista.add("2345");
    		return lista;
    	} else {
    		ArrayList<String> lista = new ArrayList<String>();
    		lista.add("Não encontrou");
    		return lista;
    	}
    }

}