class Test {

    public static String HourglassLine(int i_line, int largeur) {
      String Line = "";
        for (int j = 0; j < i_line; j++) {
          Line += " ";
        }
        for (int j = i_line; j < largeur - i_line; j++) {
          Line += "*";
        }
        for (int j = largeur - i_line; j < largeur; j++) {
          Line += " ";
        }
        return Line;
    }
  
    public static String Hourglass(int hauteur) {
      String output = "";
      int largeur = hauteur*2-1;
      for (int i = 0; i < hauteur; i++) {
        output += HourglassLine(i, largeur) + "\n";
      }
      for (int i = hauteur-2; i >= 0; i--) {
        output += HourglassLine(i, largeur) + "\n";
      }
      return output;
    }
  
    public static String FatHourglass(int hauteur) {
      String output = "";
      int largeur = hauteur*2;
      for (int i = 0; i < hauteur; i++) {
        output += HourglassLine(i, largeur) + "\n";
      }
      for (int i = hauteur-2; i >= 0; i--) {
        output += HourglassLine(i, largeur) + "\n";
      }
      return output;
    }
    public static void main(String[] args) {
      System.out.println(FatHourglass(2));
    }
  }
  