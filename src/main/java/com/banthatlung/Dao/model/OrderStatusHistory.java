package com.banthatlung.Dao.model;

import java.time.LocalDateTime;

public class OrderStatusHistory {
    private int id;
    private int orderId;
    private int oldStatus;
    private int newStatus;
    private LocalDateTime changeTime;
    private String changedBy;
    private String note;

    public OrderStatusHistory() {}

    public OrderStatusHistory(int orderId, int oldStatus, int newStatus, LocalDateTime changeTime, String changedBy, String note) {
        this.orderId = orderId;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.changeTime = changeTime;
        this.changedBy = changedBy;
        this.note = note;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getOldStatus() { return oldStatus; }
    public void setOldStatus(int oldStatus) { this.oldStatus = oldStatus; }

    public int getNewStatus() { return newStatus; }
    public void setNewStatus(int newStatus) { this.newStatus = newStatus; }

    public LocalDateTime getChangeTime() { return changeTime; }
    public void setChangeTime(LocalDateTime changeTime) { this.changeTime = changeTime; }

    public String getChangedBy() { return changedBy; }
    public void setChangedBy(String changedBy) { this.changedBy = changedBy; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}