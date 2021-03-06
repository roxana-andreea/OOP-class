package grafic;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import liceu.*;
/**
 *
 * @author Roxana Cazacu
 * @grupa 324CC
 */
public class ElevGrafic extends javax.swing.JFrame {

    /** Creates new form Elev */
    public ElevGrafic(Utilizator utilizator) {
    	this.elevCurent = (Elev) utilizator;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        nume = new javax.swing.JLabel();
        prenume = new javax.swing.JLabel();
        cnp = new javax.swing.JLabel();
        data = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        situatia = new javax.swing.JTextArea();
        utilizator = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nume.setText("Nume: " + elevCurent.getNume());

        prenume.setText("Prenume: " + elevCurent.getPrenume());

        cnp.setText("C.N.P.: " + elevCurent.getCnp());

        data.setText("Data nasterii: " + elevCurent.getDataNasterii());

        jLabel5.setText("Situatia scolara");

        
        List<Clasa> clase = Centralizator.getInstance().getClase();
        Iterator<Clasa> iterator = clase.iterator();
        Clasa clasa;
        
        
        int nr = 5;
        String text = "";
        
        while (iterator.hasNext()) {
        	clasa = iterator.next();
        	if (clasa.getElevi().contains(elevCurent)) {
        		Map<Materie, SituatieMaterieBaza> note = clasa.getCatalog().getNote().get(elevCurent);
        		nr = note.size();
        		Iterator<Materie> iteratorMat = note.keySet().iterator();
        		Materie mat;
        		SituatieMaterieBaza sitMat;
        		
        		while (iteratorMat.hasNext()) {
        			mat = iteratorMat.next();
        			sitMat = note.get(mat);
        			text += mat.toString() + sitMat.toString() + "\n";
        		}
        	}
        }
        

        System.out.println(text + "dada");
        situatia.setText(text);
        situatia.setColumns(30);
        situatia.setRows(nr);
        jScrollPane1.setViewportView(situatia);

        utilizator.setText("User: " + elevCurent.getUsername());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cnp)
                            .addComponent(data)
                            .addComponent(prenume)
                            .addComponent(nume)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(192, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(423, Short.MAX_VALUE)
                .addComponent(utilizator)
                .addGap(142, 142, 142))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(utilizator)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nume)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(prenume)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cnp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(data)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        
        this.getContentPane().setBackground(Color.BLUE);
        pack();
        setVisible(true);
    }// </editor-fold>

    private javax.swing.JLabel cnp;
    private javax.swing.JLabel data;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nume;
    private javax.swing.JLabel prenume;
    private javax.swing.JTextArea situatia;
    private javax.swing.JLabel utilizator;
    private Elev elevCurent;
    // End of variables declaration
}
