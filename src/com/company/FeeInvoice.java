package com.company;

public class FeeInvoice {
    String studentId;
    double fee;
    double installment;
    double remaining;
    String status;
    String dueDate;

    public FeeInvoice(String studentId, double fee, Double installment, Double remaining, String status, String dueDate) {
        this.studentId = studentId;
        this.fee = fee;
        this.installment = installment;
        this.remaining = remaining;
        this.status = status;
        this.dueDate = dueDate;
    }

    public void setInstallment(double installment) {
        this.installment = installment;
    }

    public void setRemaining(double remaining) {
        this.remaining = remaining;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Double getInstallment() {
        return installment;
    }

    public void setInstallment(Double installment) {
        this.installment = installment;
    }

    public Double getRemaining() {
        return remaining;
    }

    public void setRemaining(Double remaining) {
        this.remaining = remaining;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ("FeeInvoice - "
                + "Student ID - " + studentId + " - "
                + "Fee - " + fee + " - "
                + "Installment - " + installment + " - "
                + "Remaining - " + remaining + " - "
                + "Status - " + status + " - "
                + "Due Date - " + dueDate);
    }
}
