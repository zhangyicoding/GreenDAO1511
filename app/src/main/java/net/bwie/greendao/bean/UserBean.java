package net.bwie.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

// 表注解
@Entity(nameInDb = "t_user")// 表名
public class UserBean {

    // 主键注解
    @Id(autoincrement = true)// 坑！greenDAO3设置自增不好使，我们仍需要手动设置
    // 我们用时间戳值作为主键
    private long _id;

    private String account;// 账号
    private String password;// 密码

    @Transient// 该注解修饰的变量不会作为表中的列名
    private int adasdasdasd;// 随便写的，这个东西不需要作为数据库中的类名

    @Generated(hash = 784948562)
    public UserBean(long _id, String account, String password) {
        this._id = _id;
        this.account = account;
        this.password = password;
    }

    @Generated(hash = 1203313951)
    public UserBean() {
    }

    public long get_id() {
        return this._id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
