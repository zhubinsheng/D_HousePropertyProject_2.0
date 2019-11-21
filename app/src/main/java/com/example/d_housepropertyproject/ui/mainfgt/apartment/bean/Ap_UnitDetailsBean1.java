package com.example.d_housepropertyproject.ui.mainfgt.apartment.bean;

import java.io.Serializable;
import java.util.List;

public class Ap_UnitDetailsBean1 implements Serializable {

    /**
     * result : {"data":{"created":"1554714008015","createdby":null,"updated":null,"updatedby":null,"id":"1115177493125873666","name":"1室1厅单卫大阳台","code":"A1","imgurl":"http://116.62.242.76:8080/group1/M00/00/01/rBA9Jlyu5FuAKESQAAF57srmNcs234.jpg","description":"全明设计，采光充足。分区明显，布局合理。嵌入衣柜，关注生活。宽敞公卫，旅居概念。按摩浴缸，高端享受。观光躺椅，家庭SPA。阔景阳台，凭栏远眺。","mProjectId":"1115183033255329793","mProjectPeriodId":null,"carpetArea":37.39,"balconyArea":6.3,"lanArea":1.08,"referenceRmbPrice":"未知","referenceForeignPrice":null},"systemCode":"app","fileList":{"house01":[{"fileId":"1115177496112218113","path":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZeACbTFAAgUDM2mcnA063.png"},{"fileId":"1115177499102756866","path":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZeALbo5AApa2KzeMaU528.png"}],"house02":[{"fileId":"1115177501971660802","path":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZiAUJNDAAZ8lgEPwdU988.png"},{"fileId":"1115177504668598273","path":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZmAST8uAAd70AusR88972.png"},{"fileId":"1115177507457810433","path":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZmAIIJOAAV2wNlsfQY287.png"}],"house04":[{"fileId":"1115177510293159937","path":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZqAMQNhAAblmHWHUb4036.png"}],"house05":[{"fileId":"1115177513057206273","path":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZuALmFQAAfsj4C2gs8710.png"}]}}
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

    public static class ResultBean implements Serializable {
        /**
         * data : {"created":"1554714008015","createdby":null,"updated":null,"updatedby":null,"id":"1115177493125873666","name":"1室1厅单卫大阳台","code":"A1","imgurl":"http://116.62.242.76:8080/group1/M00/00/01/rBA9Jlyu5FuAKESQAAF57srmNcs234.jpg","description":"全明设计，采光充足。分区明显，布局合理。嵌入衣柜，关注生活。宽敞公卫，旅居概念。按摩浴缸，高端享受。观光躺椅，家庭SPA。阔景阳台，凭栏远眺。","mProjectId":"1115183033255329793","mProjectPeriodId":null,"carpetArea":37.39,总面积"balconyArea":6.3,阳台区"lanArea":1.08,土地面积"referenceRmbPrice":"未知","referenceForeignPrice":null}
         * systemCode : app
         * fileList : {"house01":[{"fileId":"1115177496112218113","path":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZeACbTFAAgUDM2mcnA063.png"},{"fileId":"1115177499102756866","path":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZeALbo5AApa2KzeMaU528.png"}],"house02":[{"fileId":"1115177501971660802","path":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZiAUJNDAAZ8lgEPwdU988.png"},{"fileId":"1115177504668598273","path":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZmAST8uAAd70AusR88972.png"},{"fileId":"1115177507457810433","path":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZmAIIJOAAV2wNlsfQY287.png"}],"house04":[{"fileId":"1115177510293159937","path":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZqAMQNhAAblmHWHUb4036.png"}],"house05":[{"fileId":"1115177513057206273","path":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZuALmFQAAfsj4C2gs8710.png"}]}
         */

        private DataBean data;
        private String systemCode;
        private FileListBean fileList;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
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

        public static class DataBean implements Serializable  {
            /**
             * created : 1554714008015
             * createdby : null
             * updated : null
             * updatedby : null
             * id : 1115177493125873666
             * name : 1室1厅单卫大阳台
             * code : A1
             * imgurl : http://116.62.242.76:8080/group1/M00/00/01/rBA9Jlyu5FuAKESQAAF57srmNcs234.jpg
             * description : 全明设计，采光充足。分区明显，布局合理。嵌入衣柜，关注生活。宽敞公卫，旅居概念。按摩浴缸，高端享受。观光躺椅，家庭SPA。阔景阳台，凭栏远眺。
             * mProjectId : 1115183033255329793
             * mProjectPeriodId : null
             * carpetArea : 37.39
             * balconyArea : 6.3
             * lanArea : 1.08
             * referenceRmbPrice : 未知
             * referenceForeignPrice : null
             */

            private String created;
            private Object createdby;
            private Object updated;
            private Object updatedby;
            private String id;
            private String name;
            private String code;
            private String imgurl;
            private String description;
            private String mProjectId;
            private Object mProjectPeriodId;
            private double carpetArea;
            private double balconyArea;
            private double lanArea;
            private String referenceRmbPrice;
            private Object referenceForeignPrice;

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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getImgurl() {
                return imgurl;
            }

            public void setImgurl(String imgurl) {
                this.imgurl = imgurl;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getMProjectId() {
                return mProjectId;
            }

            public void setMProjectId(String mProjectId) {
                this.mProjectId = mProjectId;
            }

            public Object getMProjectPeriodId() {
                return mProjectPeriodId;
            }

            public void setMProjectPeriodId(Object mProjectPeriodId) {
                this.mProjectPeriodId = mProjectPeriodId;
            }

            public double getCarpetArea() {
                return carpetArea;
            }

            public void setCarpetArea(double carpetArea) {
                this.carpetArea = carpetArea;
            }

            public double getBalconyArea() {
                return balconyArea;
            }

            public void setBalconyArea(double balconyArea) {
                this.balconyArea = balconyArea;
            }

            public double getLanArea() {
                return lanArea;
            }

            public void setLanArea(double lanArea) {
                this.lanArea = lanArea;
            }

            public String getReferenceRmbPrice() {
                return referenceRmbPrice;
            }

            public void setReferenceRmbPrice(String referenceRmbPrice) {
                this.referenceRmbPrice = referenceRmbPrice;
            }

            public Object getReferenceForeignPrice() {
                return referenceForeignPrice;
            }

            public void setReferenceForeignPrice(Object referenceForeignPrice) {
                this.referenceForeignPrice = referenceForeignPrice;
            }
        }

        public static class FileListBean implements Serializable {
            private List<House01Bean> house01;
            private List<House02Bean> house02;
            private List<House03Bean> house03;

            public List<House03Bean> getHouse03() {
                return house03;
            }

            public void setHouse03(List<House03Bean> house03) {
                this.house03 = house03;
            }

            private List<House04Bean> house04;
            private List<House05Bean> house05;

            public List<House01Bean> getHouse01() {
                return house01;
            }

            public void setHouse01(List<House01Bean> house01) {
                this.house01 = house01;
            }

            public List<House02Bean> getHouse02() {
                return house02;
            }

            public void setHouse02(List<House02Bean> house02) {
                this.house02 = house02;
            }

            public List<House04Bean> getHouse04() {
                return house04;
            }

            public void setHouse04(List<House04Bean> house04) {
                this.house04 = house04;
            }

            public List<House05Bean> getHouse05() {
                return house05;
            }

            public void setHouse05(List<House05Bean> house05) {
                this.house05 = house05;
            }

            public static class House01Bean implements Serializable  {
                /**
                 * fileId : 1115177496112218113
                 * path : http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZeACbTFAAgUDM2mcnA063.png
                 */

                private String fileId;
                private String path;

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
            }

            public static class House02Bean implements Serializable {
                /**
                 * fileId : 1115177501971660802
                 * path : http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZiAUJNDAAZ8lgEPwdU988.png
                 */

                private String fileId;
                private String path;

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
            }

            public static class House04Bean implements Serializable {
                /**
                 * fileId : 1115177510293159937
                 * path : http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZqAMQNhAAblmHWHUb4036.png
                 */

                private String fileId;
                private String path;

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
            }
            public static class House03Bean implements Serializable {
                /**
                 * fileId : 1115177513057206273
                 * path : http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZuALmFQAAfsj4C2gs8710.png
                 */

                private String fileId;
                private String path;

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
            }
            public static class House05Bean implements Serializable {
                /**
                 * fileId : 1115177513057206273
                 * path : http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrDZuALmFQAAfsj4C2gs8710.png
                 */

                private String fileId;
                private String path;

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
            }
        }
    }
}
