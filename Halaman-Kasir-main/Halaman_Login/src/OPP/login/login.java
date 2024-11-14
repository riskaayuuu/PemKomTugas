/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OPP.login;

/**
 *
 * @author Akmal Kurniawan
 */
public class login {
    private String username;
    private String pw;
    
    public login(String username,String pw){
        this.username = username;
        this.pw = pw;
        
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPW(){
        return pw;
    }
    public void setPW(String pw){
        this.pw = pw;
    }
}
