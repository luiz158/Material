package org.demoiselle.entity;

public enum Perfil {

    ADMINISTRADOR(3),
    MANAGER(2),
    USER(1);

    private int id;

    Perfil(int valor) {
        id = valor;
    }

    public int getId() {
        return id;
    }

    public static Perfil getPerfil(int id) {
        for (Perfil object : values()) {
            if (object.id == id) {
                return object;
            }
        }
        return null;
    }
}
