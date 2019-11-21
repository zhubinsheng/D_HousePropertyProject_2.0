package com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean;

import java.util.List;

public class QualificationDocumentsBean {

    /**
     * result : {"data":null,"systemCode":"app","fileList":{"qualification04":[{"fileId":"-1","path":"http://192.168.2.201:8080/group1/M00/00/00/wKgCyVzGZv2AQbmTAABY0fxDPso004.jpg","name":"营业执照"}]}}
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
         * fileList : {"qualification04":[{"fileId":"-1","path":"http://192.168.2.201:8080/group1/M00/00/00/wKgCyVzGZv2AQbmTAABY0fxDPso004.jpg","name":"营业执照"}]}
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
            private List<Qualification04Bean> qualification04;

            public List<Qualification04Bean> getQualification04() {
                return qualification04;
            }

            public void setQualification04(List<Qualification04Bean> qualification04) {
                this.qualification04 = qualification04;
            }

            public static class Qualification04Bean {
                /**
                 * fileId : -1
                 * path : http://192.168.2.201:8080/group1/M00/00/00/wKgCyVzGZv2AQbmTAABY0fxDPso004.jpg
                 * name : 营业执照
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
