package it.dstech.codicefiscale;

public class Persona {

    private String nome;

    private String cognome;

    private int giorno;

    private int mese;

    private int anno;

    private String comune;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getGiorno() {
        return giorno;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    public int getMese() {
        return mese;
    }

    public void setMese(int mese) {
        this.mese = mese;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }
}
