class Point {
    Integer x, y;
    public Point(Integer x, Integer y) {
        this.x=x;
        this.y=y;
    }
    public void affiche() {
        System.out.println(String.format("Point: x=%d,y=%d", this.x, this.y));
    }
    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

}

class Cercle extends Point{
    Integer rayon;
    public Cercle(Integer x, Integer y, Integer r){
        super(x,y);
        this.rayon=r;
    }
    public void affiche(){
        System.out.println(String.format("Cercle: x=%d,y=%d,rayon=%d", this.x, this.y,this.rayon));
    }
    public Double surface(){
        return this.rayon * this.rayon * 3.14;
    }
}

class Rectangle extends Point{
    Integer longueur;
    Integer largeur;
    public Rectangle(Integer x, Integer y, Integer lon, Integer lar){
        super(x,y);
        this.longueur=lon;
        this.largeur=lar;

    }
    public void affiche(){
        System.out.println(String.format("Rectangle: x=%d,y=%d,longueur=%d, largeur=%d", this.x, this.y,this.longueur, this.largeur));
    }
    public Integer surface(){
        return this.longueur*this.largeur;
    }
}

class Carre extends Rectangle{
    Integer cote;
    public Carre(Integer x, Integer y, Integer c){
        super(x,y,c,c);
        this.cote=c;
    }
    public void affiche(){
        System.out.println(String.format("Carre: x=%d,y=%d,cote=%d", this.x, this.y,this.cote));
    }
}


class POOFigureOne {

    public static void main(String[] args) {
        
        // faire un point:
        Point p1 = new Point(5,6);
        p1.affiche(); 
        
        // Faire un cercle:
        Cercle c1 = new Cercle(11,61,45);
        c1.affiche();
        
        // Faire un carre:
        Carre k1 = new Carre(18,-3,15);
        k1.affiche(); 

        // Faire un carre:
        Rectangle r1 = new Rectangle(3,19,99,18);
        r1.affiche();

        // Deplacer le rectangle:
        r1.move(10,-5);
        r1.affiche();
        // affiche Rectangle 13,14,99,18

        //afficher surface du rectangle
        System.out.println(String.format("surface rectangle %d", r1.surface()));
        //afficher surface du cercle
        System.out.println(String.format("surface cercle %8.2f", c1.surface()));
        //afficher surface du rectangle
        System.out.println(String.format("surface carre %d", k1.surface()));
    }
}