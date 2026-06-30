import java.util.*;

interface DocumentElement {
    String render();
}

class TextElement implements DocumentElement {
    String text;

    public TextElement(String text) {
        this.text = text;
    }

    public String render() {
        return text;
    }
}

class ImageElement implements DocumentElement {
    String image;

    public ImageElement(String image) {
        this.image = image;
    }

    public String render() {
        return image;
    }
}

class Document {
    List<DocumentElement> list = new ArrayList<>();

    public void addElement(DocumentElement ele) {
        list.add(ele);
    }

    public void getElements() {
        for (DocumentElement doc : list) {
            System.out.println(doc);
        }
    }

    public String render() {
        StringBuilder str = new StringBuilder();
        for (DocumentElement doc : list) {
            str.append(doc.render());
        }
        return str.toString();
    }
}

class DocumentEditor {
    Document document;
    Storage storage;
    String renderedDocument = "";

    public DocumentEditor(Document document, Storage storage) {
        this.document = document;
        this.storage = storage;
    }

    public void addText(String text) {
        document.addElement(new TextElement(text));
        System.out.println("Text Added " + text);
    }

    public void addImg(String image) {
        document.addElement(new ImageElement(image));
        System.out.println("Image Added " + image);
    }

    public String render() {
        if (renderedDocument.isEmpty()) {
            renderedDocument = document.render();
        }
        return renderedDocument;
    }

    public void save() {
        storage.save(renderedDocument);
    }
}

interface Storage {
    void save(String str);
}

class FileStorage implements Storage {
    public void save(String file) {
        System.out.println("File Saved");
    }
}

class DBStorage implements Storage {
    public void save(String image) {
        System.out.println("Saved to DB!!");
    }
}

public class Main {
    public static void main(String[] args) {
        Document doc = new Document();
        Storage st = new FileStorage();
        DocumentEditor editor = new DocumentEditor(doc, st);

        editor.addText("Hey !!! Venkat");
        editor.addImg("Picture.png");
        editor.render();
        editor.save();
    }
}
