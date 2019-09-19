package com.exercicio.exercicio1;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/obterNomePessoa")
    public String helloPeople(@RequestParam(name = "id") Long id) {
        List<Pessoa> lista = Pessoa.obterPessoas();
        for (Pessoa p: lista) {
        	if (p.getId() == id.intValue()) {
        		return p.getNome();
        	}
        }
        return "Pessoa não encontrada";
    }

}
