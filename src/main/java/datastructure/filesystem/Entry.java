package main.java.datastructure.filesystem;

import java.util.Date;

public abstract class Entry {
     public enum Type{
         File,Directory
    }

    Directory parent;
    String name;
    Date modifyDate;
    Date createDate;
    Type type;


    public Entry(Directory parent, String name, Date modifyDate, Date createDate) {
        this.parent = parent;
        this.name = name;
        this.modifyDate = modifyDate;
        this.createDate = createDate;
    }
    public String getPath(){
        if(parent==null)
            return "";
        else
            return parent.getPath()+"/"+name;
    }
    public abstract int size();
}
