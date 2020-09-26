package  datastructure.filesystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Directory extends Entry{

    List<Entry> children;

    public Directory(Directory parent, String name, Date modifyDate, Date createDate) {
        super(parent, name, modifyDate, createDate);
        children=new ArrayList<>();
        type=Type.Directory;
    }

    public void add(Entry entry) {
        if(parent==null)
            return;

        entry.parent=this;
        children.add(entry);
    }

    public void del(Entry entry) {
        if(parent==null)
            return;

        children.remove(entry);
    }

    @Override
    public int size() {
        return children.size();
    }
}
