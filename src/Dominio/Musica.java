package dominio;


public class Musica {
    private String titulo;
    private String cantor;
    private int estilo;
    private int min;
    private int seg;

    public Musica() {
    }

    
    public Musica(String t, String c, int e, int m, int s) {
        titulo = t;
        cantor = c;
        estilo = e;
        min = m;
        seg = s;
    }
        
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setCantor(String cantor) {
        this.cantor = cantor;
    }
    public String getCantor() {
        return cantor;
    }
    public void setEstilo(int estilo) {
        this.estilo = estilo;
    }
    public int getEstilo() {
        return estilo;
    }
    public void setMin(int min) {
        this.min = min;
    }
    public int getMin() {
        return min;
    }
    public void setSeg(int seg) {
        this.seg = seg;
    }
    public int getSeg() {
        return seg;
    }
    public int getDuracaoTotal() {
        return (min*60)+seg;
    }
	
}
