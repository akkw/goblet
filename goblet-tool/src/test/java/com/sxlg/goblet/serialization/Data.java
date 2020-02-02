package com.sxlg.goblet.serialization;

class Data {
        private String id;
        private String suborderNo;
        private String organUnitType;
        private String action;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSuborderNo() {
            return suborderNo;
        }

        public void setSuborderNo(String suborderNo) {
            this.suborderNo = suborderNo;
        }

        public String getOrganUnitType() {
            return organUnitType;
        }

        public void setOrganUnitType(String organUnitType) {
            this.organUnitType = organUnitType;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id='" + id + '\'' +
                    ", suborderNo='" + suborderNo + '\'' +
                    ", organUnitType='" + organUnitType + '\'' +
                    ", action='" + action + '\'' +
                    '}';
        }
    }