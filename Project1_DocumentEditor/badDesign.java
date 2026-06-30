import java.util.*;

class DocumentEditor {
    private List<String> documents = new ArrayList<>();
    String renderedDocument = "";

    public void addText(String text) {
        documents.add(text);
    }

    public void addImage(String imagePath) {
        documents.add(imagePath);
    }

    public String renderDocument() {
        if (renderedDocument.isEmpty()) {
            String result = "";
            for (String doc : documents) {
                if (doc.length() > 4 && (doc.substring(doc.length() - 4) == ".jpg")
                        || (doc.substring(doc.length() - 4) == ".png")) {
                    result += doc + "\n";
                }
            }
            renderedDocument = result;
        }
        return renderedDocument;
    }

    public void saveDocument() {
        System.out.println("Document saved ");
    }
}

public class badDesign {
    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor();
        editor.addText("This is a sample document.");
        editor.addImage("image1.jpg");
        editor.addImage("image2.png");
        String renderedDoc = editor.renderDocument();
        System.out.println(renderedDoc);
        editor.saveDocument();
    }
}