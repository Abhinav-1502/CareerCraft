package Models;

public class JobDocument {
	private int documentId;
	private String documentName;
	private String fileName;
	
	public JobDocument() {
		// Gen random DocumentID number;
	}
	public int getDocumentID() {
		return this.documentId;
	}
	
	public String getDocumentName() {
	    return documentName;
	}

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public String toString() {
        return
               "Document Name: " + documentName + "\n" +
               "File Name: " + fileName;
    }
}
