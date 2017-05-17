package base.clanner.meizhuo.base.entity;

/**
 * Created by Clanner on 2017/5/17.
 */

public class DesignAdvice {
    /**
     * id : 1
     * title : 标题
     * cover : 内容
     * link : http://mp.weixin.qq.com/s?__biz=MzA4NDk4MjU4Mw==&mid=505054824&idx=2&sn=861185f0c2343aaddc1aee416ff82e3a&chksm=0430c8303347412639e47e98facb7bb78661ec94c8f4e69ce537ff31142fd9c81a8563aad78d#rd
     * content : 内容
     * time : 1492517847000
     */

    private int id;
    private String title;
    private String cover;
    private String link;
    private String content;
    private long time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
