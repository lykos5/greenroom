package com.lykos.fundamental.jmx;

/**
 * Created by Lykos on 16/3/8.
 */
public class Message {
    private String name,title,desc;

    public Message(String name,String title,String desc){
        this.name = name;
        this.title = title;
        this.desc = desc;
    }

    public Message(){
        this.name = "lykos";
        this.title = "jmx message bean";
        this.desc = "this show jmx message";
    }

    public void echo(){
        System.out.println("my name is '"+name+"' \n this title is '"+title+"' it shows '"+desc+"'");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
