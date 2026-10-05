
import java.util.ArrayList;
import java.util.Iterator;

interface FileItem {
    void open();
}

class File implements FileItem {
    String name;

    File (String fname) {
        name = fname;
    }

	@Override
	public void open() {
		System.out.println("F:"+ name);
	}
}

class Directory implements FileItem {
    String name;
    ArrayList<FileItem> items;

    Directory (String fname) {
        name = fname;
        items = new ArrayList<>();
    }

	@Override
	public void open() {
		System.out.println("D:"+ name);
		
        Iterator itr = items.iterator();
        while(itr.hasNext()) {
            FileItem itm = (FileItem) itr.next();
            itm.open();
        }
	}

    public void addItem (FileItem i) {
        items.add(i);
    }
}



public class CompositeDP {
    public static void main (String [] args) {
        Directory root = new Directory("root");
        Directory desktop = new Directory("desktop");
        Directory downloads = new Directory("downloads");


        root.addItem(new File("root1.txt"));
        root.addItem(new File("root2.txt"));
        root.addItem(new File("root3.txt"));
        root.addItem(new File("root4.txt"));

        desktop.addItem(new File("desktop1.txt"));
        desktop.addItem(new File("desktop2.txt"));
        desktop.addItem(new File("desktop3.txt"));

        downloads.addItem(new File("downloads1.txt"));
        downloads.addItem(new File("downloads2.txt"));

        root.addItem(desktop);
        root.addItem(downloads);



        root.open();
    }
}
