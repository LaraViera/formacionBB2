package com.Bitbox.formacionBB2.model;

public enum UserTypeEnum {
    ADMIN(1, "ADMIN"),
    USER(2, "USER");
    Integer id;
    String valor;

    UserTypeEnum(Integer id, String valor ){
        this.id = id;
        this.valor = valor;
    }

    public Integer getId(){
        return id;
    }

    public String getValor() {
        return valor;
    }

    public static UserTypeEnum getFromId(Integer id){
        if (id==null || id == 0){
            return null;
        }
        for(UserTypeEnum e: values()){
            if(e.valor.equals(id)){
                return e;
            }
        }
        return null;
    }

}
