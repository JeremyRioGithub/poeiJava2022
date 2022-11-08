
abstract interface Figure{
    abstract public void move(int x, int y);
    abstract public Integer surface();
}
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

class Cercle implements Figure{
    Point centre;
    Integer rayon;
    public Cercle(Integer x, Integer y, Integer r){
        this.centre=new Point(x,y);
        this.rayon=r;
    }
    public void affiche(){
        System.out.println(String.format("Cercle: x=%d,y=%d,rayon=%d", this.centre.x, this.centre.y,this.rayon));
    }
    public Integer surface(){
        Integer i = (int)(this.rayon * this.rayon * 3.14);
        System.out.println(i);
        return i;
    }
    public void move(int dx, int dy){
        this.centre.move(dx,dy);
    }
}

class Rectangle {
    Point pointHautGauche;
    Point pointBasDroite;
    public Rectangle(Integer x, Integer y, Integer lon, Integer lar){
        this.pointHautGauche=new Point(x,y);
        this.pointBasDroite=new Point(x+lon,y+lar);

    }
    public void affiche(){
        System.out.println(String.format("Rectangle: x=%d,y=%d,lon=%d,lar=%d", this.pointHautGauche.x, this.pointHautGauche.y,Math.abs(this.pointBasDroite.x-this.pointHautGauche.x),Math.abs(this.pointBasDroite.x-this.pointHautGauche.x)));
    }
    public Integer surface(){
        return Math.abs(this.pointBasDroite.x-this.pointHautGauche.x) * Math.abs(this.pointBasDroite.x-this.pointHautGauche.x);
    }
    public void move(int dx, int dy){
        this.pointHautGauche.move(dx,dy);
        this.pointBasDroite.move(dx,dy);
    }
}

class Carre extends Rectangle{
    Integer cote;
    public Carre(Integer x, Integer y, Integer c){
        super(x,y,c,c);
        this.cote=c;
    }
    public void affiche(){
        System.out.println(String.format("Carre: x=%d,y=%d,cote=%d", this.pointHautGauche.x, this.pointHautGauche.y,this.cote));
    }
}


class POOFigureTwo {

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

        //afficher surface du rectangle
        System.out.println(String.format("surface rectangle %d", r1.surface()));
        //afficher surface du cercle
        System.out.println(String.format("surface cercle %d", c1.surface()));
        //afficher surface du rectangle
        System.out.println(String.format("surface carre %d", k1.surface()));

        //Chaque dessin peut bouger et affiche la surface
        //bouger le rectangle
        r1.move(2,5);
        r1.affiche();
    }
}