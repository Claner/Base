package base.clanner.meizhuo.base.entity;

/**
 * Created by Clanner on 2017/5/17.
 */

public class User {
    /**
     * userId : 1
     * username : Clanner
     * sex : m
     * description : 哈哈哈啊
     * avatar : 1-4d638e20716ec2088a00034c.jpg
     */



    private int userId;
    private String username;
    private String sex;
    private String description;
    private String avatar;
    private String skill;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
