package com.example.d_housepropertyproject.ui.mainfgt.home.act.bean;

import java.util.List;

public class PreferentialInformationBean {

    /**
     * result : {"data":null,"systemCode":"app","fileList":{"qualification06":[{"fileId":"1125315443955916801","path":"http://192.168.2.201:8080/group1/M00/00/01/wKgCyVzP70qANpAqAABN9pahGxg047.jpg","name":"hd.jpg"},{"fileId":"1125316700967854082","path":"http://192.168.2.201:8080/group1/M00/00/01/wKgCyVzP8HaAdEdpABB9zZkjSrI607.jpg","name":"one2.jpg"},{"fileId":"1125320126506262530","path":"http://192.168.2.201:8080/group1/M00/00/01/wKgCyVzP86eAX09LAAgrE8QP5RY174.png","name":"优惠信息001.png"},{"fileId":"1125320792616263682","path":"http://192.168.2.201:8080/group1/M00/00/01/wKgCyVzP9EWAEJRxAAgrE8QP5RY780.png","name":"优惠信息001.png"}]}}
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
         * fileList : {"qualification06":[{"fileId":"1125315443955916801","path":"http://192.168.2.201:8080/group1/M00/00/01/wKgCyVzP70qANpAqAABN9pahGxg047.jpg","name":"hd.jpg"},{"fileId":"1125316700967854082","path":"http://192.168.2.201:8080/group1/M00/00/01/wKgCyVzP8HaAdEdpABB9zZkjSrI607.jpg","name":"one2.jpg"},{"fileId":"1125320126506262530","path":"http://192.168.2.201:8080/group1/M00/00/01/wKgCyVzP86eAX09LAAgrE8QP5RY174.png","name":"优惠信息001.png"},{"fileId":"1125320792616263682","path":"http://192.168.2.201:8080/group1/M00/00/01/wKgCyVzP9EWAEJRxAAgrE8QP5RY780.png","name":"优惠信息001.png"}]}
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
            private List<Qualification06Bean> qualification06;

            public List<Qualification06Bean> getQualification06() {
                return qualification06;
            }

            public void setQualification06(List<Qualification06Bean> qualification06) {
                this.qualification06 = qualification06;
            }

            public static class Qualification06Bean {
                /**
                 * fileId : 1125315443955916801
                 * path : http://192.168.2.201:8080/group1/M00/00/01/wKgCyVzP70qANpAqAABN9pahGxg047.jpg
                 * name : hd.jpg
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
