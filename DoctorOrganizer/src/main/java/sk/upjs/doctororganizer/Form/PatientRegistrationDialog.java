/*
 * Copyright (C) 2016 acer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package sk.upjs.doctororganizer.Form;

import java.awt.Color;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import sk.upjs.doctororganizer.Entities.Patient;
import sk.upjs.doctororganizer.Factory.DaoFactory;
import sk.upjs.doctororganizer.PasswordHash;

public class PatientRegistrationDialog extends javax.swing.JDialog {

    java.awt.Frame parentFrame;
    private List<JTextField> textFieldList = new ArrayList<>();
    private final String badFormCompletionInfoText = "Polia môžu obsahovať minimálne 1, maximálne 40 znakov";

    public PatientRegistrationDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parentFrame = parent;
        initComponents();
        this.setLocationRelativeTo(parent);
        textFieldList.add(emailTextField);
        textFieldList.add(jPasswordField1);
        textFieldList.add(jPasswordField2);
        textFieldList.add(nameTextField);
        textFieldList.add(surnameTextField);
        textFieldList.add(idNumberTextField);
        textFieldList.add(adressTextField);
        textFieldList.add(mobilTextField);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        typePanel = new javax.swing.JPanel();
        doctorRadioButton = new javax.swing.JRadioButton();
        pacientRadioButton = new javax.swing.JRadioButton();
        loginDetailsPanel = new javax.swing.JPanel();
        emailLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        passConfirmLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        personalDetailsPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        surnameTextField = new javax.swing.JTextField();
        idNumberLabel = new javax.swing.JLabel();
        idNumberTextField = new javax.swing.JTextField();
        insuredAtLabel = new javax.swing.JLabel();
        insuredAtComboBox = new javax.swing.JComboBox<>();
        dateLabel = new javax.swing.JLabel();
        dayComboBox = new javax.swing.JComboBox<>();
        monthComboBox = new javax.swing.JComboBox<>();
        yearComboBox = new javax.swing.JComboBox<>();
        adressLabel = new javax.swing.JLabel();
        adressTextField = new javax.swing.JTextField();
        mobilLabel = new javax.swing.JLabel();
        mobilTextField = new javax.swing.JTextField();
        infoLabel = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        registerButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DoctorOrganizer 1.0");

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Registrácia pacienta");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        typePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Výber typu konta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        doctorRadioButton.setText("Lekár");
        doctorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorRadioButtonActionPerformed(evt);
            }
        });

        pacientRadioButton.setSelected(true);
        pacientRadioButton.setText("Pacient");

        javax.swing.GroupLayout typePanelLayout = new javax.swing.GroupLayout(typePanel);
        typePanel.setLayout(typePanelLayout);
        typePanelLayout.setHorizontalGroup(
            typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(doctorRadioButton)
                .addGap(18, 18, 18)
                .addComponent(pacientRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        typePanelLayout.setVerticalGroup(
            typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(doctorRadioButton)
                .addComponent(pacientRadioButton))
        );

        loginDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Registračné údaje"));

        emailLabel.setText("E-mail:");

        passLabel.setText("Heslo:");

        passConfirmLabel.setText("Potvrdenie hesla:");

        javax.swing.GroupLayout loginDetailsPanelLayout = new javax.swing.GroupLayout(loginDetailsPanel);
        loginDetailsPanel.setLayout(loginDetailsPanelLayout);
        loginDetailsPanelLayout.setHorizontalGroup(
            loginDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginDetailsPanelLayout.createSequentialGroup()
                        .addComponent(passConfirmLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jPasswordField2))
                    .addGroup(loginDetailsPanelLayout.createSequentialGroup()
                        .addGroup(loginDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailLabel)
                            .addComponent(passLabel))
                        .addGap(18, 18, 18)
                        .addGroup(loginDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailTextField)
                            .addComponent(jPasswordField1))))
                .addContainerGap())
        );
        loginDetailsPanelLayout.setVerticalGroup(
            loginDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passConfirmLabel)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        personalDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Osobné údaje"));

        nameLabel.setText("Meno:");

        surnameLabel.setText("Priezvisko:");

        idNumberLabel.setText("Rodné číslo (bez lomky):");

        insuredAtLabel.setText("Poisťovňa:");

        insuredAtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Všeobecná zdravotná poisťovňa", "DÔVERA", "Union", " ", " ", " " }));

        dateLabel.setText("Dátum narodenia:");

        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Január", "Február", "Marec", "Apríl", "Máj", "Jún", "Júl", "August", "September", "Október", "November", "December" }));

        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", " " }));

        adressLabel.setText("Bydlisko:");

        mobilLabel.setText("Mobil:");

        javax.swing.GroupLayout personalDetailsPanelLayout = new javax.swing.GroupLayout(personalDetailsPanel);
        personalDetailsPanel.setLayout(personalDetailsPanelLayout);
        personalDetailsPanelLayout.setHorizontalGroup(
            personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                        .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(surnameLabel)
                            .addComponent(nameLabel))
                        .addGap(25, 25, 25)
                        .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(surnameTextField)
                            .addComponent(nameTextField)))
                    .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                        .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idNumberLabel)
                            .addComponent(insuredAtLabel))
                        .addGap(18, 18, 18)
                        .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idNumberTextField)
                            .addComponent(insuredAtComboBox, 0, 194, Short.MAX_VALUE)))
                    .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                        .addComponent(dateLabel)
                        .addGap(18, 18, 18)
                        .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                        .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mobilLabel)
                            .addComponent(adressLabel))
                        .addGap(18, 18, 18)
                        .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adressTextField)
                            .addComponent(mobilTextField))))
                .addContainerGap())
        );
        personalDetailsPanelLayout.setVerticalGroup(
            personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameLabel)
                    .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idNumberLabel)
                    .addComponent(idNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insuredAtLabel)
                    .addComponent(insuredAtComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adressLabel)
                    .addComponent(adressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(mobilLabel))
                    .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mobilTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        registerButton.setText("Registrácia");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Zrušiť");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(typePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginDetailsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(personalDetailsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(personalDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void doctorRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorRadioButtonActionPerformed
        DoctorRegistrationDialog drd = new DoctorRegistrationDialog(parentFrame, true);
        this.dispose();
        drd.setVisible(true);
    }//GEN-LAST:event_doctorRadioButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        boolean go = true;
        for (JTextField textField : textFieldList) {
            if (textField.getText().length() < 1 || textField.getText().length() > 40) {
                textField.setBackground(Color.red);
                go = false;
            } else {
                textField.setBackground(Color.white);
            }
        }
        if (!go) {
            infoLabel.setText(badFormCompletionInfoText);
            return;
        }
        
        if (!(new String(jPasswordField1.getPassword())).equals(new String(jPasswordField2.getPassword()))) {
            infoLabel.setText("Heslá nie sú rovnaké!");
            return;
        }
        Patient patient = new Patient();
        patient.setName(nameTextField.getText());
        patient.setSurname(surnameTextField.getText());
        patient.setAdress(adressTextField.getText());
        String monthString = "";
        switch (monthComboBox.getSelectedItem().toString()) {
            case "Január":  monthString = "Januára";
                     break;
            case "Február":  monthString = "Februára";
                     break;
            case "Marec":  monthString = "Marca";
                     break;
            case "Apríl":  monthString = "Apríla";
                     break;
            case "Máj":  monthString = "Májá";
                     break;
            case "Jún":  monthString = "Júna";
                     break;
            case "Júl":  monthString = "Júla";
                     break;
            case "August":  monthString = "Augusta";
                     break;
            case "September":  monthString = "Septembra";
                     break;
            case "Október": monthString = "Octóbra";
                     break;
            case "November": monthString = "Novembra";
                     break;
            case "December": monthString = "Decembra";
                     break;
        }        
        patient.setDate_of_birth(dayComboBox.getSelectedItem().toString() 
                + "." + monthString 
                + " " + yearComboBox.getSelectedItem().toString());        
        patient.setId_number(new BigInteger(idNumberTextField.getText()));
        patient.setInsured_at(insuredAtComboBox.getSelectedItem().toString());
        patient.setPhone_number(mobilTextField.getText());
        patient.setEmail(emailTextField.getText());       
        try {
            patient.setPassword(PasswordHash.hash(new String(jPasswordField1.getPassword())));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DoctorRegistrationDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        DaoFactory.INSTANCE.getPatientDao().add(patient);
        infoLabel.setText("Registrácia bola úspešná, stlačte zavrieť");
        registerButton.setEnabled(false);
        cancelButton.setText("Zavrieť");
    }//GEN-LAST:event_registerButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PatientRegistrationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientRegistrationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientRegistrationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientRegistrationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adressLabel;
    private javax.swing.JTextField adressTextField;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JComboBox<String> dayComboBox;
    private javax.swing.JRadioButton doctorRadioButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel idNumberLabel;
    private javax.swing.JTextField idNumberTextField;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JComboBox<String> insuredAtComboBox;
    private javax.swing.JLabel insuredAtLabel;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPanel loginDetailsPanel;
    private javax.swing.JLabel mobilLabel;
    private javax.swing.JTextField mobilTextField;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JRadioButton pacientRadioButton;
    private javax.swing.JLabel passConfirmLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPanel personalDetailsPanel;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameTextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel typePanel;
    private javax.swing.JComboBox<String> yearComboBox;
    // End of variables declaration//GEN-END:variables
}
