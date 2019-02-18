package com.bw.luwenjie0218.model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 努力
 * @Date: 2019/2/18 09:05:${卢文杰}
 * @Description:
 */
public class NewsBean {

//    "code": 200,
//            "data":
//            "head_url": "http://h.hiphotos.baidu.com/zhidao/pic/item/9d82d158ccbf6c81e718270eb93eb13533fa402c.jpg",
//            "name": "思凡"
    private int code;
    private ArrayList<DataBean> data;
    private String head_url;
    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    public String getHead_url() {
        return head_url;
    }

    public void setHead_url(String head_url) {
        this.head_url = head_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class DataBean{
        /*"content": "习近平举行仪式欢迎加蓬总统访华",
            "id": 10000,
            "image_url": "http://pic32.nipic.com/20130817/9745430_101836881000_2.jpg",
            "title": "今日头条",
            "type": 1*/
        private String content;
        private int id;
        private String image_url;
        private String title;
        private int type;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

}
