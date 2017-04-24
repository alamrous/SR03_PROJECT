package beans;


public class Jeu {
private Integer id;
private String title;
private Pegi fk_pegi;
private Double note;
private String summary;
private Editeur fk_editeur;
public Jeu() {
	
	super();
	// TODO Auto-generated constructor stub
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Pegi getFk_pegi() {
	return fk_pegi;
}
public void setFk_pegi(Pegi fk_pegi) {
	this.fk_pegi = fk_pegi;
}
public Double getNote() {
	return note;
}
public void setNote(Double note) {
	this.note = note;
}
public String getSummary() {
	return summary;
}
public void setSummary(String summary) {
	this.summary = summary;
}
public Editeur getFk_editeur() {
	return fk_editeur;
}
public void setFk_editeur(Editeur fk_editeur) {
	this.fk_editeur = fk_editeur;
}
public Jeu(Integer id, String title, Pegi fk_pegi, Double note, String summary, Editeur fk_editeur) {
	super();
	this.id = id;
	this.title = title;
	this.fk_pegi = fk_pegi;
	this.note = note;
	this.summary = summary;
	this.fk_editeur = fk_editeur;
}

}
