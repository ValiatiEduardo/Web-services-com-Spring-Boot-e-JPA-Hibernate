package com.Spring.Boot.java_web.entitits;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    //auto incremento do id no banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    //implementando associações
    //Sempre instanciar uma coleção
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public User() {

    }

    public User(Long id, String name, String email, String phone, String password) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email= email;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPassword(){
        return phone;
    }

    public void setPassword(){
        this.password = password;
    }
    //esse um para muitos está mapeado do outro lado como client
    @OneToMany(mappedBy = "client")
    //Quando for uma coleção é somente o get
    // o set não é necesário por que não vai ser trovadda a lista
    //só vai ser acrescentado e removido elementos e para isso que o get serve
    public List<Order> getOrders(){
        return orders;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (((id == null)) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if (obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null)
            if (other.id != null)
                return false;
            return true;
    }
}
