package org.trishul;

public class NetBank {
    private String userName;
    private String password;

    public NetBank(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getPassword(){
        return this.password;
    }
}
