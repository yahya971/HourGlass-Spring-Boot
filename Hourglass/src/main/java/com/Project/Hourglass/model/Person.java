package com.Project.Hourglass.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String lastname;

    @NotNull
    private String sex;

    @NotNull
    private long age;

    @NotNull
    private String role;

    @Lob
    @NotNull
    private byte[] photo;

    public Person (){

    }

    public Person(long id,String name,String lastname,String sex,long age,String role,byte[] photo){
        this.id=id;
        this.name=name;
        this.lastname=lastname;
        this.sex=sex;
        this.age=age;
        this.role=role;
        this.photo=photo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
