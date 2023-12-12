package com.example.kcampusmanager;

import java.util.Date;

public class LedgerItem {
    int ledgerNumber;
    int studentNumber;
    String classroomName;
    Date reservationTime;
    String reservationStatus;
    String reservationReason;

    public LedgerItem(int breakdownNumber, int studentNumber, String classroomName, Date reservationTime, String reservationStatus, String reservationReason) {
        this.ledgerNumber = breakdownNumber;
        this.studentNumber = studentNumber;
        this.classroomName = classroomName;
        this.reservationTime = reservationTime;
        this.reservationStatus = reservationStatus;
        this.reservationReason = reservationReason;
    }

    public int getLedgerNumber() {
        return this.ledgerNumber;
    }
    public int getStudentNumber() {
        return this.studentNumber;
    }
    public String getClassroomName() {
        return this.classroomName;
    }
    public Date getReservationTime() {
        return this.reservationTime;
    }
    public String getReservationStatus() {
        return this.reservationStatus;
    }
}
