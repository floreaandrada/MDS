package railway;

import java.sql.*;
import javax.swing.*;

/**
 *This class creates a new frame called View Seat Availability which opens a new window 
 * showing information on the number of seats left in a specific train as entered by the user.
 */
public class ViewSeatAvailability extends JFrame {

    /** The constructor of the ViewSeatAvailability class */
    public ViewSeatAvailability() {
        initComponents();
    }
    Connection con;

    /** This method connects to the MS ACCESS database using a Type-I JDBC driver. */
    public void connect() {

        try {
            con = MyCon.startConnection();
        } catch (Exception e) {
            System.err.println("Error : " + e);
        }

    }

    /**
     * This method shows information on the number of seats left in a particular class,
     * in a specific train as entered by the user
     */
    public void viewSeatAvailability() {
        int train_num = 0, count = 0;
        String cls = null;
        train_num = Integer.parseInt(jTextField1.getText());
        cls = (String) jComboBox1.getSelectedItem();


        try {
            Statement st;
            ResultSet rs = null;
            st = con.createStatement();
            if (cls.equalsIgnoreCase("ac")) {
                rs = st.executeQuery("select ac_seats from train where train_no=" + train_num);
            } else if (cls.equalsIgnoreCase("general")) {
                rs = st.executeQuery("select gen_seats from train where train_no=" + train_num);
            } else if (cls.equalsIgnoreCase("sleeper")) {
                rs = st.executeQuery("select slpr_seats from train where train_no=" + train_num);
            } else {
                JOptionPane.showMessageDialog(null,"Sorry wrong travelling class provided");
            }

            while (rs.next()) {
                JOptionPane.showMessageDialog(null, "The total number of seats still available are : " + rs.getInt(1));
                count++;
            }

            if (count == 0) {
                JOptionPane.showMessageDialog(null, "Sorry no result obtained");
            }
            
           // st.close();
            //con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in retrieving data");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Nyala", 1, 24));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Accommodation Availability Enquiry ");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Train No:");
        jLabel2.setFocusable(false);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Class:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jComboBox1.setFont(new java.awt.Font("Verdana", 1, 12));
        jComboBox1.setForeground(new java.awt.Color(0, 51, 153));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "AC", "GENERAL", "SLEEPER" }));

        jButton1.setFont(new java.awt.Font("Verdana", 1, 12));
        jButton1.setForeground(new java.awt.Color(0, 51, 153));
        jButton1.setText("Get Availability");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Don't know the train number?          ");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton2.setFont(new java.awt.Font("Verdana", 1, 12));
        jButton2.setForeground(new java.awt.Color(0, 102, 153));
        jButton2.setText("Click here to search");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/railway/imgs/logo2.jpg"))); 

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/railway/imgs/logo2.jpg"))); 

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addGap(33, 33, 33))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jButton1)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addContainerGap(329, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** The events which occur when the Click here to search button is clicked. */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ViewTrainsBetween.main(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    /** The events which occur when the Get Availability button is clicked. */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        connect();
        viewSeatAvailability();
    }//GEN-LAST:event_jButton1ActionPerformed

    /** The main method from where execution of the program begins. */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ViewSeatAvailability().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
