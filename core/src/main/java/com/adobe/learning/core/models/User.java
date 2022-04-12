package com.adobe.learning.core.models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String nome;
    private String cargo;
    private Integer idade;
    private String studio;
    private String dc;
    private static List<User> usuario = new ArrayList<User>();

    static {
        insertUsers();
    }

    private List<User> usuarios = new ArrayList<User>();

    public User() {

    }

    public User(String nome, String cargo, Integer idade, String studio, String dc) {
        super();
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.studio = studio;
        this.dc = dc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public List<User> getUsers() {
        return usuario;
    }

    public void setUsuarios(ArrayList<User> usuarios) {
        this.usuarios = usuarios;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public void addUser(User user){
        usuario.add(user);
    }

    public static void insertUsers() {
        usuario.clear();
        usuario.add(new User("Gionni", "AEM Backend Developer", 18, "Adobe", "Recife"));
        usuario.add(new User("Renan", "AEM Backend Developer", 45, "Adobe", "Recife"));
        usuario.add(new User("Cassiano", "AEM Frontend Developer", 23, "Adobe", "Recife"));
        usuario.add(new User("Alberto", "AEM Frontend Developer", 22, "Adobe", "Recife"));
        usuario.add(new User("Gabriel", "AEM Frontend Developer", 87, "Adobe", "Recife"));
        usuario.add(new User("Matheus", "AEM Frontend Developer", 35, "Adobe", "Recife"));
        usuario.add(new User("Joao", "AEM Frontend Developer", 35, "Adobe", "Recife"));
        usuario.add(new User("Eduardo", "AEM Frontend Developer", 35, "Adobe", "Recife"));
        usuario.add(new User("Luan", "AEM Frontend Developer", 35, "Adobe", "Recife"));

        usuario.addAll(usuario);

    }


    @Override public String toString() {
        return "User: \n" + "Nome: " + this.getNome() + "\n" + "Cargo: " + this.getCargo() + "\n"
                +"Idade:" +  this.getIdade() + "\n" + "Studio:" + this.studio + "\n" + "DC:" + this.dc + "\n----------------\n" ;
    }
}
