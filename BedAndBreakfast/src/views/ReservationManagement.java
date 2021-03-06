/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import DBCommands.*;
import classes.*;
import java.text.*;
import java.util.*;


/**
 *
 * @author Aaron
 */
public class ReservationManagement extends javax.swing.JFrame {
        Reservation rs;
        ReservationDAO rc;
        private Date date1, date2;
        String guestArray[][];

    /**
     * Creates new form ReservationSearchModule
     */
    public ReservationManagement() {
        initComponents();
        rs = new Reservation();
        rc = new ReservationDAO();
        refreshRooms();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelReservationManagement = new javax.swing.JPanel();
        jLabelReservationManagement = new javax.swing.JLabel();
        jPanelReservationInformation = new javax.swing.JPanel();
        jLabelCheckInDate = new javax.swing.JLabel();
        jLabeLCheckOutDate = new javax.swing.JLabel();
        jLabelRmNo = new javax.swing.JLabel();
        jLabelResvNo = new javax.swing.JLabel();
        jComboBoxRoomNumber = new javax.swing.JComboBox<>();
        jCalendarComboBoxCheckInDate = new de.wannawork.jcalendar.JCalendarComboBox();
        jCalendarComboBoxCheckOutDate = new de.wannawork.jcalendar.JCalendarComboBox();
        jLabelReservationNumber = new javax.swing.JLabel();
        jTextFieldReservationNumber = new javax.swing.JTextField();
        jLabelStatus = new javax.swing.JLabel();
        jComboBoxReservationStatus = new javax.swing.JComboBox<>();
        jTextFieldGuestNumber = new javax.swing.JTextField();
        jLabelGuestNumber = new javax.swing.JLabel();
        jTextFieldFirstName = new javax.swing.JTextField();
        jTextFieldLastName = new javax.swing.JTextField();
        jLabelLastName = new javax.swing.JLabel();
        jLabelFirstName = new javax.swing.JLabel();
        jButtonCheckIn = new javax.swing.JButton();
        jButtonCheckOut = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jButtonSearch = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReservationList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelReservationManagement.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelReservationManagement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelReservationManagement.setText("Reservation Management ");

        jPanelReservationInformation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelCheckInDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCheckInDate.setText("Check-In-Date");

        jLabeLCheckOutDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeLCheckOutDate.setText("Check-Out-Date");

        jLabelRmNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRmNo.setText("Room Number");

        jLabelResvNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelResvNo.setText("Reservation Search Fields");

        jComboBoxRoomNumber.setEditable(true);
        jComboBoxRoomNumber.setToolTipText("");

        jLabelReservationNumber.setText("Reservation Number");

        jTextFieldReservationNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldReservationNumberActionPerformed(evt);
            }
        });

        jLabelStatus.setText("Status");

        jComboBoxReservationStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reserved", "Checked In", "Checked Out", "Cancel", "No Show" }));

        jTextFieldGuestNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGuestNumberActionPerformed(evt);
            }
        });

        jLabelGuestNumber.setText("Guest Number");

        jLabelLastName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelLastName.setText("Last");

        jLabelFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFirstName.setText("First");

        javax.swing.GroupLayout jPanelReservationInformationLayout = new javax.swing.GroupLayout(jPanelReservationInformation);
        jPanelReservationInformation.setLayout(jPanelReservationInformationLayout);
        jPanelReservationInformationLayout.setHorizontalGroup(
            jPanelReservationInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReservationInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelReservationInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelResvNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelReservationInformationLayout.createSequentialGroup()
                        .addGroup(jPanelReservationInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelReservationInformationLayout.createSequentialGroup()
                                .addGroup(jPanelReservationInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelReservationInformationLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabelCheckInDate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabeLCheckOutDate, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelReservationInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCalendarComboBoxCheckOutDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCalendarComboBoxCheckInDate, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                            .addGroup(jPanelReservationInformationLayout.createSequentialGroup()
                                .addComponent(jLabelLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTextFieldLastName))
                            .addGroup(jPanelReservationInformationLayout.createSequentialGroup()
                                .addComponent(jLabelFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldFirstName)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelReservationInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRmNo)
                            .addComponent(jLabelStatus)
                            .addComponent(jLabelReservationNumber)
                            .addComponent(jLabelGuestNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(jPanelReservationInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxRoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxReservationStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldReservationNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldGuestNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(107, 107, 107)))
                .addContainerGap())
        );
        jPanelReservationInformationLayout.setVerticalGroup(
            jPanelReservationInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelReservationInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelResvNo)
                .addGap(18, 18, 18)
                .addGroup(jPanelReservationInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelReservationInformationLayout.createSequentialGroup()
                        .addGroup(jPanelReservationInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelReservationInformationLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabelCheckInDate))
                            .addComponent(jCalendarComboBoxCheckInDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelReservationInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCalendarComboBoxCheckOutDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabeLCheckOutDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelReservationInformationLayout.createSequentialGroup()
                        .addGroup(jPanelReservationInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxRoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRmNo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelReservationInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStatus)
                            .addComponent(jComboBoxReservationStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelReservationInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLastName)
                    .addComponent(jLabelReservationNumber)
                    .addComponent(jTextFieldReservationNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelReservationInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFirstName)
                    .addComponent(jLabelGuestNumber)
                    .addComponent(jTextFieldGuestNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonCheckIn.setText("Check In");
        jButtonCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckInActionPerformed(evt);
            }
        });

        jButtonCheckOut.setText("Check Out");
        jButtonCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckOutActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTableReservationList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Res Number", "Last Name", "First Name", "Check In Date", "Check Out Date", "Status", "Room Number"
            }
        ));
        jScrollPane1.setViewportView(jTableReservationList);

        javax.swing.GroupLayout jPanelReservationManagementLayout = new javax.swing.GroupLayout(jPanelReservationManagement);
        jPanelReservationManagement.setLayout(jPanelReservationManagementLayout);
        jPanelReservationManagementLayout.setHorizontalGroup(
            jPanelReservationManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelReservationManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelReservationManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelReservationManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelReservationInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(jPanelReservationManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelReservationManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelReservationManagementLayout.setVerticalGroup(
            jPanelReservationManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReservationManagementLayout.createSequentialGroup()
                .addComponent(jLabelReservationManagement)
                .addGroup(jPanelReservationManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelReservationManagementLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelReservationInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelReservationManagementLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButtonSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonClear)))
                .addGroup(jPanelReservationManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelReservationManagementLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButtonCheckIn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCheckOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExit)
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addGroup(jPanelReservationManagementLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelReservationManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelReservationManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelReservationManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldGuestNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGuestNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGuestNumberActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckInActionPerformed
        // TODO add your handling code here:
        int rowNumber;
        String resNumber;
        rowNumber=jTableReservationList.getSelectedRow();
        resNumber=jTableReservationList.getValueAt(rowNumber, 0).toString();
        rs.setResNo(resNumber);
        rc.checkInReservation(rs);
        jTableReservationList.setValueAt("Checked In", rowNumber, 5);
        repaint();
        revalidate();
    }//GEN-LAST:event_jButtonCheckInActionPerformed

    private void jTextFieldReservationNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldReservationNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldReservationNumberActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:

        getNewDate();
        date1 = jCalendarComboBoxCheckInDate.getDate();
        date2 = jCalendarComboBoxCheckOutDate.getDate();
        DateFormat dataBaseFormat=new SimpleDateFormat("dd-MMM-yy");
        String inDate=dataBaseFormat.format(date1);
        String outDate=dataBaseFormat.format(date2);

        Reservation res = new Reservation();
        Guest gst = new Guest();
        res.setCheckIn(inDate);
        res.setCheckOut(outDate);


        String guest_no = jTextFieldGuestNumber.getText();
        if (guest_no==null) {
            guest_no="";
        }
        res.setGuestNumber(guest_no);

        String resNo = jTextFieldReservationNumber.getText();
        if (resNo == null){
            resNo="";
        }
        res.setResNo(resNo);

        String rmNo;
        Object rmObject = jComboBoxRoomNumber.getSelectedItem();
        if (rmObject == null){
            rmNo="";
        } else {
            rmNo = String.valueOf(rmObject);
        }
        res.setRoomNumber(rmNo);

        //this may still be broke right here
        String status;
        status = "" + jComboBoxReservationStatus.getSelectedIndex();
        res.setStatus(status);
        
        String lastName = jTextFieldLastName.getText();
        if (lastName == null){
            lastName = "";
        }
        gst.setLastName(lastName);

        String firstName = jTextFieldFirstName.getText();
        if (firstName == null) {
            firstName = "";
        }
        gst.setFirstName(firstName);
        
        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Res Number", "Last Name", "First Name", "Check In Date", "Check Out Date", "Status", "Room Number"
            });
        guestArray=rc.searchReservation(res, gst);
        int reservationsReturned = guestArray.length;
        if (reservationsReturned <=0){
            tableModel.setRowCount(25);
        }else {
            tableModel.setRowCount(guestArray.length);
        }
        jTableReservationList.setModel(tableModel);
//        jTableReservationList.validate();
//        jScrollPane1.setViewportView(jTableReservationList);
        for(int i=0; i<guestArray.length; i++){
            for(int column=0; column<7;column++){
               jTableReservationList.setValueAt(guestArray[i][column], i, column);
            }

        }
    }//GEN-LAST:event_jButtonSearchActionPerformed
    private void refreshRooms(){
        RoomDAO rmDAO = new RoomDAO();
        Room[] rooms = rmDAO.getRooms();
        String[] roomsString = new String[rooms.length];
        for (int i=0; i <rooms.length; i++){
            roomsString[i] = rooms[i].getRmNO();
        }
        jComboBoxRoomNumber.removeAllItems();
        for (Room j : rooms){
            jComboBoxRoomNumber.addItem(j.getRmNO());
        }
    }
    
    private void jButtonCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckOutActionPerformed
        // TODO add your handling code here:
        int rowNumber;
        String resNumber;
        rowNumber=jTableReservationList.getSelectedRow();
        resNumber=jTableReservationList.getValueAt(rowNumber, 0).toString();
        rs.setResNo(resNumber);
        rc.checkOutReservation(rs);
        jTableReservationList.setValueAt("Checked Out", rowNumber, 5);
        repaint();
        revalidate();
    }//GEN-LAST:event_jButtonCheckOutActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        int rowNumber;
        String resNumber;
        rowNumber=jTableReservationList.getSelectedRow();
        resNumber=jTableReservationList.getValueAt(rowNumber, 0).toString();
        rs.setResNo(resNumber);
        rc.cancelReservation(rs);
        jTableReservationList.setValueAt("Cancelled", rowNumber, 5);
        repaint();
        revalidate();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed

    }//GEN-LAST:event_jButtonClearActionPerformed

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
            java.util.logging.Logger.getLogger(ReservationManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservationManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservationManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservationManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservationManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonCheckIn;
    private javax.swing.JButton jButtonCheckOut;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonSearch;
    private de.wannawork.jcalendar.JCalendarComboBox jCalendarComboBoxCheckInDate;
    private de.wannawork.jcalendar.JCalendarComboBox jCalendarComboBoxCheckOutDate;
    private javax.swing.JComboBox<String> jComboBoxReservationStatus;
    private javax.swing.JComboBox<String> jComboBoxRoomNumber;
    private javax.swing.JLabel jLabeLCheckOutDate;
    private javax.swing.JLabel jLabelCheckInDate;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelGuestNumber;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelReservationManagement;
    private javax.swing.JLabel jLabelReservationNumber;
    private javax.swing.JLabel jLabelResvNo;
    private javax.swing.JLabel jLabelRmNo;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelReservationInformation;
    private javax.swing.JPanel jPanelReservationManagement;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableReservationList;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldGuestNumber;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldReservationNumber;
    // End of variables declaration//GEN-END:variables
    //create dates for checkin and checkout
    private void getNewDate(){
    //Formating Date to mmm-dd-yyyy
     DateFormat format1=SimpleDateFormat.getDateInstance();

    //Try Catch for Date Comparision
        try{
            //Setting Check In and Checkout Dates
            date1 = format1.parse(format1.format(jCalendarComboBoxCheckInDate.getCalendar()
                    .getTime()));
            date2 = format1.parse(format1.format(jCalendarComboBoxCheckOutDate.getCalendar()
                    .getTime()));
        }
        catch(ParseException ex){
            //Temp Error Message
            ex.printStackTrace();
        }
    }//end getNewDate()
}
