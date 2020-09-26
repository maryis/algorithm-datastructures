package  datastructure.filesystem;

import java.util.Date;

public class InMemFS {

    Directory root;

    public InMemFS() {

        root=new Directory(null,"root", new Date(),new Date());
    }

    public int addEntry(Entry entry,String path){//dfs
        String[] paths=path.split("/");
        Entry curr=root;
        int i=0;
        for(i=0;i<paths.length-1;i++){
            if(!paths[i].equals(curr.name))
                return -1;//wrong path
            if(curr.type== Entry.Type.File)
                return -1;//wrong path

            for(Entry entry1:((Directory) curr).children){
                if(entry1.name.equals(paths[i+1])){
                    curr=entry1;
                    continue;
                }
            }
        }
        if(curr.type== Entry.Type.Directory &&paths[i].equals(curr.name)){
            ((Directory) curr).add(entry);
        }
        else return -1;

        return 1;
    }
}
