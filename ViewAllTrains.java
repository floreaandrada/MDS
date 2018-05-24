package railway;

import java.sql.*;
import javax.swing.*;

/**
 * This class creates a new frame called View All Trains which opens a new window 
 * showing all the trains which exist in the railways train database.
 */
public class ViewAllTrains extends JFrame {

    /** The constructor of the ViewAllTrains class */
    public ViewAllTrains() {
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
     * This method retrieves all the necessary train details from the database and 
     * then it stored them in a matrix and displays the output in a table format.
     */
    public void viewTrains() {

        int n = 0;
        double dist = 0;
        String name = null, dep = null, arr = null, arrtime = null, deptime = null;
        String title[] = new String[]{
            "Train number", "Train name", "Departing Station", "Arriving Station", "Departure time", "Arrival time", "Total distance"
        };

        try {

            Statement st;
            ResultSet rs = null;
            st = con.createStatement();
            rs = st.executeQuery("select * from train");
            int i = 0;

            Object[][] data = new Object[8][8];

            while (rs.next()) {

                n = rs.getInt(1);
                name = rs.getString(2);
                dep = rs.getString(3);
                arr = rs.getString(4);
                arrtime = rs.getTime(5).toString();
                deptime = rs.getTime(6).toString();
                dist = rs.getFloat(7);

                data[i][0] = n;
                data[i][1] = name;
                data[i][2] = dep;
                data[i][3] = arr;
                data[i][4] = arrtime;
                data[i][5] = deptime;
                data[i][6] = dist;

                i += 1;

            }

            jTable1.setModel(new javax.swing.table.DefaultTableModel(data, title));
            //st.close();
            //con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in retrieving data");
        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setEnabled(false);
        jTable1.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Nyala", 1, 36));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LIST OF ALL THE TRAINS RUNNING");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED)));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/railway/imgs/logo2.jpg")));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/railway/imgs/logo2.jpg")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** The main method from where execution of the program begins. */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            ViewAllTrains vt = new ViewAllTrains();

            public void run() {
                vt.setVisible(true);
                vt.connect();
                vt.viewTrains();

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
