package  datastructure.filesystem;

import java.util.Date;

public class File extends Entry {

    String content;

    public File(Directory parent, String name, Date modifyDate, Date createDate) {
        super(parent, name, modifyDate, createDate);
        type = Type.File;
    }

    @Override
    public int size() {
        return content.length();

    }

    public int setContent(String content) {
        this.content = content;
        return 1;
    }

    public String getContent() {
        return content;
    }
}
