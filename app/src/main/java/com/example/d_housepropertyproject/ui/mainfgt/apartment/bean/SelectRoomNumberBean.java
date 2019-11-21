package com.example.d_housepropertyproject.ui.mainfgt.apartment.bean;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

public class SelectRoomNumberBean implements Serializable {
    /**
     * result : [{"created":"1556602120776","createdby":null,"updated":null,"updatedby":null,"id":"1","isactive":true,"mProjectRoomId":"1123096811838021634","description":"string","project":"测啊","period":"一期","builder":"一栋","unit":"一单元","roomNumber":"test房间","floors":"1","floorarea":0,"usablearea":0,"publicarea":null,"mHouseTypeId":"1115179289693077505","referenceRmbPrice":0,"referenceForeignPrice":0,"status":"2","oriented":"东南","decoration":"毛坯","earnestRmbPrice":0,"earnestForeignPrice":0},{"created":"1556602292899","createdby":null,"updated":null,"updatedby":null,"id":"1123097533975617537","isactive":true,"mProjectRoomId":"1123097533799456770","description":"string","project":"测啊","period":"一期","builder":"一栋","unit":"一单元","roomNumber":"test房间1","floors":"5","floorarea":0,"usablearea":0,"publicarea":null,"mHouseTypeId":"1115179289693077505","referenceRmbPrice":0,"referenceForeignPrice":0,"status":"2","oriented":"东西","decoration":"简单装修","earnestRmbPrice":0,"earnestForeignPrice":0},{"created":"1556602297131","createdby":null,"updated":null,"updatedby":null,"id":"1123097551725912066","isactive":true,"mProjectRoomId":"1123097551717523457","description":"string","project":"测啊","period":"一期","builder":"一栋","unit":"一单元","roomNumber":"test房间2","floors":"2","floorarea":0,"usablearea":0,"publicarea":null,"mHouseTypeId":"1115179289693077505","referenceRmbPrice":0,"referenceForeignPrice":0,"status":"2","oriented":"南北","decoration":"中等装修","earnestRmbPrice":0,"earnestForeignPrice":0},{"created":"1556602339021","createdby":null,"updated":null,"updatedby":null,"id":"1123097727425306626","isactive":true,"mProjectRoomId":"1123097727412723714","description":"string","project":"测啊","period":"一期","builder":"一栋","unit":"一单元","roomNumber":"test房间3","floors":"6","floorarea":0,"usablearea":0,"publicarea":null,"mHouseTypeId":"1115179289693077505","referenceRmbPrice":0,"referenceForeignPrice":0,"status":"2","oriented":"北","decoration":"精装修","earnestRmbPrice":0,"earnestForeignPrice":0},{"created":"1556602341329","createdby":null,"updated":null,"updatedby":null,"id":"1123097737105760257","isactive":true,"mProjectRoomId":"1123097737097371649","description":"string","project":"测啊","period":"一期","builder":"一栋","unit":"一单元","roomNumber":"test房间4","floors":"7","floorarea":0,"usablearea":0,"publicarea":null,"mHouseTypeId":"1115179289693077505","referenceRmbPrice":0,"referenceForeignPrice":0,"status":"2","oriented":"西","decoration":"豪华装修","earnestRmbPrice":0,"earnestForeignPrice":0},{"created":"1556602344346","createdby":null,"updated":null,"updatedby":null,"id":"1123097749759975426","isactive":true,"mProjectRoomId":"1123097749755781121","description":"string","project":"测啊","period":"一期","builder":"一栋","unit":"一单元","roomNumber":"test房间5","floors":"9","floorarea":0,"usablearea":0,"publicarea":null,"mHouseTypeId":"1115179289693077505","referenceRmbPrice":0,"referenceForeignPrice":0,"status":"2","oriented":"南","decoration":"豪华装修","earnestRmbPrice":0,"earnestForeignPrice":0},{"created":"1556602348526","createdby":null,"updated":null,"updatedby":null,"id":"1123097767292166146","isactive":true,"mProjectRoomId":"1123097767262806018","description":"string","project":"测啊","period":"一期","builder":"一栋","unit":"一单元","roomNumber":"test房间6","floors":"7","floorarea":0,"usablearea":0,"publicarea":null,"mHouseTypeId":"1115179289693077505","referenceRmbPrice":0,"referenceForeignPrice":0,"status":"2","oriented":"东","decoration":"简单装修","earnestRmbPrice":0,"earnestForeignPrice":0}]
     * message : 成功
     * code : 20000
     */

    private String message;
    private int code;
    private List<SelectRoomNumberBean.ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<SelectRoomNumberBean.ResultBean> getResult() {
        return result;
    }

    public void setResult(List<SelectRoomNumberBean.ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {
        public boolean isStatus() {
            return isStatus;
        }

        public void setStatus(boolean status) {
            isStatus = status;
        }

        /**
         * created : 1556602120776
         * createdby : null
         * updated : null
         * updatedby : null
         * id : 1
         * isactive : true
         * mProjectRoomId : 1123096811838021634
         * description : string
         * project : 测啊
         * period : 一期
         * builder : 一栋
         * unit : 一单元
         * roomNumber : test房间
         * floors : 1
         * floorarea : 0.0
         * usablearea : 0.0
         * publicarea : null
         * mHouseTypeId : 1115179289693077505
         * referenceRmbPrice : 0.0
         * referenceForeignPrice : 0.0
         * status : 2
         * oriented : 东南
         * decoration : 毛坯
         * earnestRmbPrice : 0.0 定金
         * earnestForeignPrice : 0.0
         */
        private boolean isStatus;

        private String sellId;

        public String getSellId() {
            return sellId;
        }

        public void setSellId(String sellId) {
            this.sellId = sellId;
        }

        private String created;
        private Object createdby;
        private Object updated;
        private Object updatedby;
        private String id;
        private boolean isactive;
        private String mProjectRoomId;
        private String description;
        private String project;
        private String period;
        private String builder;
        private String unit;
        private String roomNumber;
        private String floors;
        private double floorarea;
        private double usablearea;
        private Object publicarea;
        private String mHouseTypeId;
        private double referenceRmbPrice;
        private double referenceForeignPrice;
        private String status;
        private String oriented;
        private String decoration;
        private double earnestRmbPrice;
        private double earnestForeignPrice;

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public Object getCreatedby() {
            return createdby;
        }

        public void setCreatedby(Object createdby) {
            this.createdby = createdby;
        }

        public Object getUpdated() {
            return updated;
        }

        public void setUpdated(Object updated) {
            this.updated = updated;
        }

        public Object getUpdatedby() {
            return updatedby;
        }

        public void setUpdatedby(Object updatedby) {
            this.updatedby = updatedby;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIsactive() {
            return isactive;
        }

        public void setIsactive(boolean isactive) {
            this.isactive = isactive;
        }

        public String getMProjectRoomId() {
            return mProjectRoomId;
        }

        public void setMProjectRoomId(String mProjectRoomId) {
            this.mProjectRoomId = mProjectRoomId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getProject() {
            return project;
        }

        public void setProject(String project) {
            this.project = project;
        }

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public String getBuilder() {
            return builder;
        }

        public void setBuilder(String builder) {
            this.builder = builder;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        public String getFloors() {
            return floors;
        }

        public void setFloors(String floors) {
            this.floors = floors;
        }

        public double getFloorarea() {
            return floorarea;
        }

        public void setFloorarea(double floorarea) {
            this.floorarea = floorarea;
        }

        public double getUsablearea() {
            return usablearea;
        }

        public void setUsablearea(double usablearea) {
            this.usablearea = usablearea;
        }

        public Object getPublicarea() {
            return publicarea;
        }

        public void setPublicarea(Object publicarea) {
            this.publicarea = publicarea;
        }

        public String getMHouseTypeId() {
            return mHouseTypeId;
        }

        public void setMHouseTypeId(String mHouseTypeId) {
            this.mHouseTypeId = mHouseTypeId;
        }

        public int getReferenceRmbPrice() {
            int price=(int)(referenceRmbPrice);
            return price;
        }
        public void setReferenceRmbPrice(double referenceRmbPrice) {
            this.referenceRmbPrice = referenceRmbPrice;
        }

        public double getReferenceForeignPrice() {
            return referenceForeignPrice;
        }

        public void setReferenceForeignPrice(double referenceForeignPrice) {
            this.referenceForeignPrice = referenceForeignPrice;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getOriented() {
            return oriented;
        }

        public void setOriented(String oriented) {
            this.oriented = oriented;
        }

        public String getDecoration() {
            return decoration;
        }

        public void setDecoration(String decoration) {
            this.decoration = decoration;
        }

        public String getEarnestRmbPrice() {
            return getDoubleString(earnestRmbPrice);
        }

        public void setEarnestRmbPrice(double earnestRmbPrice) {
            this.earnestRmbPrice = earnestRmbPrice;
        }

        public double getEarnestForeignPrice() {
            return earnestForeignPrice;
        }

        public void setEarnestForeignPrice(double earnestForeignPrice) {
            this.earnestForeignPrice = earnestForeignPrice;
        }
    }
    /*
     * 如果是小数，保留两位，非小数，保留整数
     * @param number
     */
    public static String getDoubleString(double number) {
        String numberStr;
        if (((int) number * 1000) == (int) (number * 1000)) {
            //如果是一个整数
            numberStr = String.valueOf((int) number);
        } else {
            DecimalFormat df = new DecimalFormat("######0.00");
            numberStr = df.format(number);
        }
        return numberStr;
    }
}
