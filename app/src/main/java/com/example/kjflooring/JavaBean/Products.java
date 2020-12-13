package com.example.kjflooring.JavaBean;

/**
 *
 */
public class Products {
    private String type;
    private String name;
    private String definition;
    private int recycle_image;
    private double price;

    public Products(){

    }

    /**
     *
     * @param type
     * @param name
     * @param definition
     * @param recycle_image
     * @param price
     */
    public Products(String type,String name, String definition, int recycle_image, double price) {
        this.type=type;
        this.name = name;
        this.definition = definition;
        this.recycle_image=recycle_image;
        this.price=price;
    }

    /**
     *
     * @param type
     * @param name
     * @param price
     */
    public Products(String type,String name, double price){
        this.type=type;
        this.name=name;
        this.price=price;
    }

    /**
     *
     * @param name
     * @param definition
     * @param recycle_image
     */
    public Products(String name, String definition, int recycle_image){
        this.name = name;
        this.definition = definition;
        this.recycle_image=recycle_image;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public double getPrice(){return price;}

    /**
     *
     * @param price
     */
    public void setPrice(double price){this.price = price;}

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDefinition() {
        return definition;
    }

    /**
     *
     * @param definition
     */
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    /**
     *
     * @return
     */
    public int getRecycle_image() {
        return recycle_image;
    }

    /**
     *
     * @param recycle_image
     */
    public void setRecycle_image(int recycle_image) {
        this.recycle_image = recycle_image;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return "Name: " +name+" | $"+price+" | "+type;
    }
}
