/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producentmulti;

/**
 *
 * @author ANDRZEJ
 */
public class Product {
    private String name;
    private int id;

    public Product(String name, int id)
    {
        this.name = name;
        this.id = id;
    }
    public String getMsg()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }
    public void setMsg( String name)
    {
        this.name = name;
    }
    public void setId( int id )
    {
        this.id = id;
    }
}
