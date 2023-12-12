package com.example.kcampusmanager;

import java.text.SimpleDateFormat;
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

    public String getFormattedReservationDate() {
        if (this.reservationTime == null) {
            return ""; // reservationTime이 null인 경우 처리
        }

        SimpleDateFormat sdfMonth = new SimpleDateFormat("M");
        SimpleDateFormat sdfDay = new SimpleDateFormat("d");

        String month = sdfMonth.format(this.reservationTime);
        String day = sdfDay.format(this.reservationTime);

        // "월/일" 형태의 문자열로 반환
        return month + "/" + day;
    }

    public String getReservationStatus() {
        return this.reservationStatus;
    }
}
