package model;

import java.util.List;

public class Cliente {
    Integer id;
    String nome;
    String apelido;
    String rg;  
    String nasc;

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getApelido() {
        return apelido;
    }

    public String getNasc() {
        return nasc;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }    

    public void add(List<Cliente> clientes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
