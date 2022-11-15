
abstract interface Figure{
    abstract public void move(int x, int y);
    abstract public Integer surface();
}
class PointTwo {
    Integer x, y;
    public PointTwo(Integer x, Integer y) {
        this.x=x;
        this.y=y;
    }
    public void affiche() {
        System.out.println(String.format("PointTwo: x=%d,y=%d", this.x, this.y));
    }
    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

}

class CercleTwo implements Figure{
    PointTwo centre;
    Integer rayon;
    public CercleTwo(Integer x, Integer y, Integer r){
        this.centre=new PointTwo(x,y);
        this.rayon=r;
    }
    public void affiche(){
        System.out.println(String.format("CercleTwo: x=%d,y=%d,rayon=%d", this.centre.x, this.centre.y,this.rayon));
    }
    public Integer surface(){
        int i = (int)(this.rayon * this.rayon * 3.14);
        System.out.println(i);
        return i;
    }
    public void move(int dx, int dy){
        this.centre.move(dx,dy);
    }
}

class RectangleOne {
    PointTwo pointHautGauche;
    PointTwo pointBasDroite;
    public RectangleOne(Integer x, Integer y, Integer lon, Integer lar){
        this.pointHautGauche=new PointTwo(x,y);
        this.pointBasDroite=new PointTwo(x+lon,y+lar);

    }
    public void affiche(){
        System.out.println(String.format("RectangleOne: x=%d,y=%d,lon=%d,lar=%d", this.pointHautGauche.x, this.pointHautGauche.y,Math.abs(this.pointBasDroite.x-this.pointHautGauche.x),Math.abs(this.pointBasDroite.x-this.pointHautGauche.x)));
    }
    public Integer surface(){
        return Math.abs(this.pointBasDroite.x-this.pointHautGauche.x) * Math.abs(this.pointBasDroite.x-this.pointHautGauche.x);
    }
    public void move(int dx, int dy){
        this.pointHautGauche.move(dx,dy);
        this.pointBasDroite.move(dx,dy);
    }
}

class CarreOne extends RectangleOne{
    Integer cote;
    public CarreOne(Integer x, Integer y, Integer c){
        super(x,y,c,c);
        this.cote=c;
    }
    public void affiche(){
        System.out.println(String.format("CarreOne: x=%d,y=%d,cote=%d", this.pointHautGauche.x, this.pointHautGauche.y,this.cote));
    }
}


class POOFigureTwo {

    public static void main(String[] args) {
        
        // faire un point:
        PointTwo p1 = new PointTwo(5,6);
        p1.affiche(); 
        
        // Faire un cercle:
        CercleTwo c1 = new CercleTwo(11,61,45);
        c1.affiche();
        
        // Faire un carre:
        CarreOne k1 = new CarreOne(18,-3,15);
        k1.affiche(); 

        // Faire un carre:
        RectangleOne r1 = new RectangleOne(3,19,99,18);
        r1.affiche();

        //afficher surface du rectangle
        System.out.println(String.format("surface rectangle %d", r1.surface()));
        //afficher surface du cercle
        //System.out.println(String.format("surface cercle %d", c1.surface())); // problem with converting double to integer.
        //afficher surface du rectangle
        System.out.println(String.format("surface carre %d", k1.surface()));

        //Chaque dessin peut bouger et affiche la surface
        //bouger le rectangle
        r1.move(2,5);
        r1.affiche();
    }
}