package beans;


public class Jeu {
private Integer id;
private String title;
private Integer fk_pegi;
private Double note;
private String summary;
private Integer fk_editeur;
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
public Integer getFk_pegi() {
	return fk_pegi;
}
public void setFk_pegi(Integer fk_pegi) {
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
public Integer getFk_editeur() {
	return fk_editeur;
}
public void setFk_editeur(Integer fk_editeur) {
	this.fk_editeur = fk_editeur;
}
public Jeu(Integer id, String title, Integer fk_pegi, Double note, String summary, Integer fk_editeur) {
	super();
	this.id = id;
	this.title = title;
	this.fk_pegi = fk_pegi;
	this.note = note;
	this.summary = summary;
	this.fk_editeur = fk_editeur;
}

}
