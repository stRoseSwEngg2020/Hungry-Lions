
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author myaduncan
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form LoginAndCreateNewAccount
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);//Puts form in the middle of the screen
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TreasureHuntPanel = new javax.swing.JPanel();
        TreasureHuntGameName = new javax.swing.JLabel();
        CloseLoginForm = new javax.swing.JLabel();
        MinimizeLoginForm = new javax.swing.JLabel();
        LoginBackgroundPanel = new javax.swing.JPanel();
        LoginTextLogo = new javax.swing.JLabel();
        UsernameTextLogo = new javax.swing.JLabel();
        PasswordTextLogo = new javax.swing.JLabel();
        UsernameLoginPageEntry = new javax.swing.JTextField();
        jLoginPagePasswordField1 = new javax.swing.JPasswordField();
        LoginToGame = new javax.swing.JButton();
        CreateNewUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TreasureHuntPanel.setBackground(new java.awt.Color(207, 0, 14));

        TreasureHuntGameName.setFont(new java.awt.Font("DIN Condensed", 0, 18)); // NOI18N
        TreasureHuntGameName.setText("Treasure Hunt");

        CloseLoginForm.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        CloseLoginForm.setText("x");
        CloseLoginForm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CloseLoginForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseLoginFormMouseClicked(evt);
            }
        });

        MinimizeLoginForm.setText("-");
        MinimizeLoginForm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MinimizeLoginForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizeLoginFormMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TreasureHuntPanelLayout = new javax.swing.GroupLayout(TreasureHuntPanel);
        TreasureHuntPanel.setLayout(TreasureHuntPanelLayout);
        TreasureHuntPanelLayout.setHorizontalGroup(
            TreasureHuntPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TreasureHuntPanelLayout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addComponent(TreasureHuntGameName)
                .addGap(122, 122, 122)
                .addComponent(MinimizeLoginForm)
                .addGap(18, 18, 18)
                .addComponent(CloseLoginForm)
                .addGap(17, 17, 17))
        );
        TreasureHuntPanelLayout.setVerticalGroup(
            TreasureHuntPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TreasureHuntPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TreasureHuntPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TreasureHuntGameName)
                    .addComponent(CloseLoginForm)
                    .addComponent(MinimizeLoginForm))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LoginBackgroundPanel.setBackground(new java.awt.Color(0, 169, 207));

        LoginTextLogo.setBackground(new java.awt.Color(255, 255, 255));
        LoginTextLogo.setFont(new java.awt.Font("DIN Condensed", 0, 24)); // NOI18N
        LoginTextLogo.setForeground(new java.awt.Color(255, 255, 255));
        LoginTextLogo.setText("Login");

        UsernameTextLogo.setFont(new java.awt.Font("DIN Condensed", 0, 18)); // NOI18N
        UsernameTextLogo.setForeground(new java.awt.Color(255, 255, 255));
        UsernameTextLogo.setText("Username");

        PasswordTextLogo.setFont(new java.awt.Font("DIN Condensed", 0, 18)); // NOI18N
        PasswordTextLogo.setForeground(new java.awt.Color(255, 255, 255));
        PasswordTextLogo.setText("Password");

        UsernameLoginPageEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameLoginPageEntryActionPerformed(evt);
            }
        });

        LoginToGame.setText("Login");
        LoginToGame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginToGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginToGameActionPerformed(evt);
            }
        });

        CreateNewUser.setText("Create Account");
        CreateNewUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CreateNewUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateNewUserMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout LoginBackgroundPanelLayout = new javax.swing.GroupLayout(LoginBackgroundPanel);
        LoginBackgroundPanel.setLayout(LoginBackgroundPanelLayout);
        LoginBackgroundPanelLayout.setHorizontalGroup(
            LoginBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginBackgroundPanelLayout.createSequentialGroup()
                .addGroup(LoginBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginBackgroundPanelLayout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(LoginTextLogo))
                    .addGroup(LoginBackgroundPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(LoginBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(LoginBackgroundPanelLayout.createSequentialGroup()
                                .addGroup(LoginBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(PasswordTextLogo)
                                    .addComponent(UsernameTextLogo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(LoginBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(UsernameLoginPageEntry)
                                    .addComponent(jLoginPagePasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)))
                            .addGroup(LoginBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LoginToGame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CreateNewUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LoginBackgroundPanelLayout.setVerticalGroup(
            LoginBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginBackgroundPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(LoginTextLogo)
                .addGap(18, 18, 18)
                .addGroup(LoginBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsernameTextLogo)
                    .addComponent(UsernameLoginPageEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(LoginBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordTextLogo)
                    .addComponent(jLoginPagePasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LoginToGame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CreateNewUser)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TreasureHuntPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TreasureHuntPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(LoginBackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsernameLoginPageEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameLoginPageEntryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameLoginPageEntryActionPerformed

    private void CloseLoginFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseLoginFormMouseClicked
        System.exit(0);
    }//GEN-LAST:event_CloseLoginFormMouseClicked

    private void MinimizeLoginFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeLoginFormMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_MinimizeLoginFormMouseClicked

    private void LoginToGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginToGameActionPerformed
        // TODO add your handling code here:
        StartupPage homePage=new  StartupPage();
        homePage.setVisible(true);
        homePage.pack();
        homePage.setLocationRelativeTo(null);
        homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_LoginToGameActionPerformed

    private void CreateNewUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateNewUserMouseClicked
        CreateAccount newUser=new CreateAccount();
        newUser.setVisible(true);
        newUser.pack();
        newUser.setLocationRelativeTo(null);
        newUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_CreateNewUserMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CloseLoginForm;
    private javax.swing.JButton CreateNewUser;
    private javax.swing.JPanel LoginBackgroundPanel;
    private javax.swing.JLabel LoginTextLogo;
    private javax.swing.JButton LoginToGame;
    private javax.swing.JLabel MinimizeLoginForm;
    private javax.swing.JLabel PasswordTextLogo;
    private javax.swing.JLabel TreasureHuntGameName;
    private javax.swing.JPanel TreasureHuntPanel;
    private javax.swing.JTextField UsernameLoginPageEntry;
    private javax.swing.JLabel UsernameTextLogo;
    private javax.swing.JPasswordField jLoginPagePasswordField1;
    // End of variables declaration//GEN-END:variables
}