package com.example.d_housepropertyproject.ui.mainfgt.bean;

import java.util.List;

public class HomeBannerBean {

    /**
     * result : {"data":null,"systemCode":"app","fileList":{"qualification07":[{"fileId":"1131010520274968577","path":"http://116.62.242.76:8080/group1/M00/00/03/rBA9Jlzkpz2AF1p7ACG9FEByNBg906.png","name":"one3.png"},{"fileId":"1131011199450226690","path":"http://116.62.242.76:8080/group1/M00/00/03/rBA9Jlzkp9-AMnlIAAB-UMHfXzU363.png","name":"one6.png"}]}}
     * message : 成功
     * code : 20000
     */

    private ResultBean result;
    private String message;
    private int code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * data : null
         * systemCode : app
         * fileList : {"qualification07":[{"fileId":"1131010520274968577","path":"http://116.62.242.76:8080/group1/M00/00/03/rBA9Jlzkpz2AF1p7ACG9FEByNBg906.png","name":"one3.png"},{"fileId":"1131011199450226690","path":"http://116.62.242.76:8080/group1/M00/00/03/rBA9Jlzkp9-AMnlIAAB-UMHfXzU363.png","name":"one6.png"}]}
         */

        private Object data;
        private String systemCode;
        private FileListBean fileList;

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public String getSystemCode() {
            return systemCode;
        }

        public void setSystemCode(String systemCode) {
            this.systemCode = systemCode;
        }

        public FileListBean getFileList() {
            return fileList;
        }

        public void setFileList(FileListBean fileList) {
            this.fileList = fileList;
        }

        public static class FileListBean {
            private List<Qualification07Bean> qualification07;

            public List<Qualification07Bean> getQualification07() {
                return qualification07;
            }

            public void setQualification07(List<Qualification07Bean> qualification07) {
                this.qualification07 = qualification07;
            }

            public static class Qualification07Bean {
                /**
                 * fileId : 1131010520274968577
                 * path : http://116.62.242.76:8080/group1/M00/00/03/rBA9Jlzkpz2AF1p7ACG9FEByNBg906.png
                 * name : one3.png
                 */

                private String fileId;
                private String path;
                private String name;

                public String getFileId() {
                    return fileId;
                }

                public void setFileId(String fileId) {
                    this.fileId = fileId;
                }

                public String getPath() {
                    return path;
                }

                public void setPath(String path) {
                    this.path = path;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }
}
