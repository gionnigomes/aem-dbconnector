package com.adobe.learning.core.models;

import com.google.gson.annotations.Expose;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class)
public class UserModel {

    @Expose
    private String nome;
    @Expose
    private Integer idade;

    private String cargo;
    private String studio;
    private String dc;
    private static List<UserModel> usuario = new ArrayList<UserModel>();

    static {
        insertUsers();
    }

    private List<UserModel> usuarios = new ArrayList<UserModel>();

    public UserModel() {

    }

    public UserModel(String nome, String cargo, Integer idade, String studio, String dc) {
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

    public List<UserModel> getUsers() {
        return usuario;
    }

    public void setUsuarios(ArrayList<UserModel> usuarios) {
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

    public void addUser(UserModel user){
        usuario.add(user);
    }

    public static void insertUsers() {

        usuario.add(new UserModel("Gionni", "AEM Backend Developer", 18, "Adobe", "Pernambico"));
        usuario.add(new UserModel("Renan", "AEM Backend Developer", 45, "Adobe", "Rio Grande do Sul"));
        usuario.add(new UserModel("Cassiano", "AEM Frontend Developer", 23, "Adobe", "Rio Grande do Sul"));
        usuario.add(new UserModel("Alberto", "AEM Frontend Developer", 22, "Adobe", "Rio Grande do Sul"));
        usuario.add(new UserModel("Gabriel", "AEM Frontend Developer", 87, "Adobe", "Rio Grande do Sul"));
        usuario.add(new UserModel("Matheus", "AEM Frontend Developer", 35, "Adobe", "Rio Grande do Sul"));
        usuario.add(new UserModel("Joao", "AEM Frontend Developer", 35, "Adobe", "Rio Grande do Sul"));
        usuario.add(new UserModel("Eduardo", "AEM Frontend Developer", 35, "Adobe", "Rio Grande do Sul"));
        usuario.add(new UserModel("Luan", "AEM Frontend Developer", 35, "Adobe", "Rio Grande do Sul"));

        usuario.addAll(usuario);

    }


    @Override public String toString() {
        return "User: \n" + "Nome: " + this.getNome() + "\n" + "Cargo: " + this.getCargo() + "\n"
                +"Idade:" +  this.getIdade() + "\n" + "Studio:" + this.studio + "\n" + "DC:" + this.dc + "\n----------------\n" ;
    }
}
