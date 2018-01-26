package net.bwie.greendao.application;

import android.app.Application;

import net.bwie.greendao.bean.DaoMaster;
import net.bwie.greendao.bean.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * 我们最终要在特定的情景下，比如按钮点击，插入数据，我们需要dao对象，从哪来？DaoSession会话
 * 会话DaoSession是和数据库交互的行为，从哪来？Database数据库
 * 数据库从哪来？用一个给开发者使用的助手帮我们创建的
 * <p>
 * 1、创建数据库助手，可以指定数据库文件名，默认版本号1
 * 2、用数据库助手帮我们弄一个数据库对象
 * 3、数据库中产生一个（全局）会话
 * 4、在会话中可以执行详细的增删改查操作，用dao对象
 */
public class MyApplication extends Application {

    public static final String DB_NAME = "user.db";

    // 单例模式的会话，整个工程只有一个就够了
    private static DaoSession sDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        initGreenDAO();
    }

    private void initGreenDAO() {
//        1、创建数据库助手，可以指定数据库文件名，默认版本号1
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DB_NAME);
//                2、用数据库助手帮我们弄一个数据库对象
        Database db = helper.getWritableDb();
//                3、主干对象根据数据库去创建一个会话
        sDaoSession = new DaoMaster(db).newSession();

    }

    public static DaoSession getDaoSession() {
        return sDaoSession;
    }
}
