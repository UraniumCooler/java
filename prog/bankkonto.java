import javax.swing.*;

public class bankkonto {

    public static void main(String[] args) {

      double startbeloppet = Double.parseDouble(JOptionPane.showInputDialog("Ange startbeloppet: "));

      double ränta = Double.parseDouble(JOptionPane.showInputDialog("Vad är räntan?: "));

      int år = Integer.parseInt(JOptionPane.showInputDialog("På hur många år?: "));

      double utdrag = Double.parseDouble(JOptionPane.showInputDialog("Vad är utdraget?: "));

      beloppVidUttag(startbeloppet, ränta, år, utdrag);
    }

    public static double beloppVidUttag (double startbeloppet, double ränta, int år, double utdrag) {
          if (utdrag > startbeloppet*0.01*ränta) { // är uttaget större än räntan? 
            JOptionPane.showMessageDialog(null,"För stort uttag");
            return 0;
        }
        
        else {
          // ett varv per år
          for (int i=1; i <= år; i++) 

          startbeloppet = startbeloppet + startbeloppet * 0.01 * ränta - utdrag;
            //System.out.println("År: " + år + " | " + "Pengar: " + startbeloppet);
            System.out.println(beloppVidUttag(startbeloppet, ränta, år, utdrag));
      }
      return startbeloppet;
   }
}
