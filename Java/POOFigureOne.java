class Point {
    Integer x, y;
    public Point(Integer x, Integer y) {
        this.x=x;
        this.y=y;
    }
    public void affiche() {
        System.out.println(String.format("Point: x=%d,y=%d", this.x, this.y));
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
}

class Carre extends Point{
    Integer cote;
    public Carre(Integer x, Integer y, Integer c){
        super(x,y);
        this.cote=c;
    }
    public void affiche(){
        System.out.println(String.format("Carre: x=%d,y=%d,cote=%d", this.x, this.y,this.cote));
    }
}

class Rectangle extends Carre{
    Integer longueur;
    Integer largeur;
    public Rectangle(Integer x, Integer y, Integer c, Integer lar){
        super(x,y,c);
        this.largeur=lar;

    }
    public void affiche(){
        System.out.println(String.format("Rectangle: x=%d,y=%d,longueur=%d, largeur=%d", this.x, this.y,this.longueur, this.largeur));
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
        Carre k1 = new Carre(18,3,15);
        k1.affiche();
        //affiche Carre : (18,-3) cote=15   

        // Faire un carre:
        Rectangle r1 = new Rectangle(3,19,99,18);
        r1.affiche();
        //affiche Rectangle : (3,19) longueur=99, largeur=18  
    }
}