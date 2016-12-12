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
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTextField;
import sk.upjs.doctororganizer.Entities.DoctorOffice;
import sk.upjs.doctororganizer.Entities.Hours;
import sk.upjs.doctororganizer.Factory.DaoFactory;

public class OfficeEditDialog extends javax.swing.JDialog {

    private final DoctorOffice office;
    private List<JTextField> textFieldList = new LinkedList<JTextField>();
    private final String badFormCompletionInfoText = "Polia môžu obsahovať minimálne 1, maximálne 40 znakov";


    public OfficeEditDialog(Frame parent, boolean modal, DoctorOffice office) {
        super(parent, modal);
        this.office = office;
        initComponents();
        this.setLocationRelativeTo(parent);
        Hours hours = new Hours();
        List<String> hoursListFrom = hours.getAllHoursList();
        for (String time : hoursListFrom) {
            fromComboBox.addItem(time);
            toComboBox.addItem(time);
        }
        townTextField.setText(office.getCity());
        streetTextField.setText(office.getStreet());
        descriptionNumberTextField.setText(Integer.toString(office.getHouse_number()));
        hospitalTextField.setText(office.getHospital());
        specializationTextField.setText(office.getSpecialization());
        phoneTextField.setText(office.getPhone_number());
        String from = office.getOpening_hours().substring(0, 5);
        String to = office.getOpening_hours().substring(6, 11);
        for (int i = 0; i < fromComboBox.getItemCount(); i++) {
            if (from.equals(fromComboBox.getItemAt(i))) {
                fromComboBox.setSelectedIndex(i);
            } else {
                if (to.equals(toComboBox.getItemAt(i))) {
                    toComboBox.setSelectedIndex(i);
                }
            }
        }
        textFieldList.add(phoneTextField);
        textFieldList.add(townTextField);
        textFieldList.add(descriptionNumberTextField);
        textFieldList.add(hospitalTextField);
        textFieldList.add(specializationTextField);
        textFieldList.add(streetTextField);
    }

    @SuppressWarnings(value = "unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        officeDetailPanel = new javax.swing.JPanel();
        placeLabel = new javax.swing.JLabel();
        streetLabel = new javax.swing.JLabel();
        numberLabel = new javax.swing.JLabel();
        hospitalLabel = new javax.swing.JLabel();
        specializationLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        fromLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        townTextField = new javax.swing.JTextField();
        streetTextField = new javax.swing.JTextField();
        descriptionNumberTextField = new javax.swing.JTextField();
        hospitalTextField = new javax.swing.JTextField();
        specializationTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        fromComboBox = new javax.swing.JComboBox<>();
        toComboBox = new javax.swing.JComboBox<>();
        buttonPanel = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        infoPanel = new javax.swing.JPanel();
        infoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DoctorOrganizer 1.0");
        setResizable(false);

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Zmena údajov ordinácie");

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
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        officeDetailPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Detaily ordinácie"));

        placeLabel.setText("Mesto / Obec:");

        streetLabel.setText("Ulica:");

        numberLabel.setText("Popisné číslo:");

        hospitalLabel.setText("Nemocnica:");

        specializationLabel.setText("Špecializácia ordinácie:");

        phoneLabel.setText("Telefónné číslo:");

        timeLabel.setText("Otváracia doba:");

        fromLabel.setText("od:");

        toLabel.setText("do:");

        javax.swing.GroupLayout officeDetailPanelLayout = new javax.swing.GroupLayout(officeDetailPanel);
        officeDetailPanel.setLayout(officeDetailPanelLayout);
        officeDetailPanelLayout.setHorizontalGroup(
            officeDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(officeDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(officeDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, officeDetailPanelLayout.createSequentialGroup()
                        .addComponent(placeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(townTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(streetLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(streetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(officeDetailPanelLayout.createSequentialGroup()
                        .addComponent(numberLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descriptionNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hospitalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hospitalTextField))
                    .addGroup(officeDetailPanelLayout.createSequentialGroup()
                        .addGroup(officeDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(specializationLabel)
                            .addComponent(phoneLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(officeDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneTextField)
                            .addComponent(specializationTextField)))
                    .addGroup(officeDetailPanelLayout.createSequentialGroup()
                        .addComponent(timeLabel)
                        .addGap(21, 21, 21)
                        .addComponent(fromLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(toLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(toComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        officeDetailPanelLayout.setVerticalGroup(
            officeDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(officeDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(officeDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placeLabel)
                    .addComponent(townTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streetLabel)
                    .addComponent(streetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(officeDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberLabel)
                    .addComponent(descriptionNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hospitalLabel)
                    .addComponent(hospitalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(officeDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(specializationLabel)
                    .addComponent(specializationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(officeDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(officeDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeLabel)
                    .addComponent(fromLabel)
                    .addComponent(fromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toLabel)
                    .addComponent(toComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        saveButton.setText("Uložiť zmeny");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Zrušiť");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        infoLabel.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(officeDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(officeDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
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
        
        try {
            DoctorOffice editedOffice = new DoctorOffice();
            editedOffice.setId(office.getId());
            editedOffice.setCity(townTextField.getText());
            editedOffice.setStreet(streetTextField.getText());
            editedOffice.setHouse_number(Integer.parseInt(descriptionNumberTextField.getText()));
            editedOffice.setHospital(hospitalTextField.getText());
            editedOffice.setOpening_hours(fromComboBox.getSelectedItem() + "-" + toComboBox.getSelectedItem());
            editedOffice.setSpecialization(specializationTextField.getText());
            editedOffice.setPhone_number(phoneTextField.getText());
            editedOffice.setId_doctor(office.getId_doctor());
            DaoFactory.INSTANCE.getDoctorOfficeDao().upgrade(editedOffice);
            infoLabel.setText("Zmena údajov bola úspešná, stlačte zavrieť");
            cancelButton.setText("Zavrieť");
            saveButton.setEnabled(false);
        } catch (NumberFormatException ex) {
            descriptionNumberTextField.setBackground(Color.red);
            infoLabel.setText("Popisné číslo musí byť číslo");
        }
    }//GEN-LAST:event_saveButtonActionPerformed


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
            java.util.logging.Logger.getLogger(OfficeEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OfficeEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OfficeEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OfficeEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField descriptionNumberTextField;
    private javax.swing.JComboBox<String> fromComboBox;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JLabel hospitalLabel;
    private javax.swing.JTextField hospitalTextField;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JPanel officeDetailPanel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JLabel placeLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel specializationLabel;
    private javax.swing.JTextField specializationTextField;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JTextField streetTextField;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JComboBox<String> toComboBox;
    private javax.swing.JLabel toLabel;
    private javax.swing.JTextField townTextField;
    // End of variables declaration//GEN-END:variables
}
