package com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean;

import java.util.List;

public class QualificatonBean {

    /**
     * result : {"data":null,"systemCode":"app","fileList":{"qualification05":[{"fileId":"-2","path":"http://192.168.2.201:8080/group1/M00/00/00/wKgCyVzGZg2AeuKKAAJ4v2XXHAk522.jpg","name":"ICP证书"}]}}
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
         * fileList : {"qualification05":[{"fileId":"-2","path":"http://192.168.2.201:8080/group1/M00/00/00/wKgCyVzGZg2AeuKKAAJ4v2XXHAk522.jpg","name":"ICP证书"}]}
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
            private List<Qualification05Bean> qualification05;

            public List<Qualification05Bean> getQualification05() {
                return qualification05;
            }

            public void setQualification05(List<Qualification05Bean> qualification05) {
                this.qualification05 = qualification05;
            }

            public static class Qualification05Bean {
                /**
                 * fileId : -2
                 * path : http://192.168.2.201:8080/group1/M00/00/00/wKgCyVzGZg2AeuKKAAJ4v2XXHAk522.jpg
                 * name : ICP证书
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
