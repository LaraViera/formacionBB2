package com.Bitbox.formacionBB2.model;

public enum RoleEnum {

    ROLE_USER,
    ROLE_ADMIN
   /* ADMIN(1, "ROLE_ADMIN"),
    USER(2, "ROLE_USER");
    Integer id;
    String valor;

    RoleEnum(Integer id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public Integer getId(){
        return id;
    }

    public String getValor() {
        return valor;
    }

    public static RoleEnum getFromId(Integer id) {
        if (id==null || id == 0){
            return null;
        }
        for (RoleEnum e : values()) {
            if(e.valor.equals(id)){
                return e;
            }
        }
        return null;
    }
*/

}
