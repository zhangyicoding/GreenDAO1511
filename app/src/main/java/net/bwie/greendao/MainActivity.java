package net.bwie.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.bwie.greendao.adapter.UserAdapter;
import net.bwie.greendao.application.MyApplication;
import net.bwie.greendao.bean.UserBean;
import net.bwie.greendao.bean.UserBeanDao;

import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected EditText mAccountEt;
    protected EditText mPasswordEt;
    protected Button mInsertBtn;
    protected Button mDeleteBtn;
    protected Button mUpdateBtn;
    protected Button mQueryBtn;
    protected RecyclerView mRecyclerView;

    private UserBeanDao mDao;
    private UserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();

        // 获取操作数据库的dao对象
        mDao = MyApplication.getDaoSession().getUserBeanDao();
    }

    private void initView() {
        mAccountEt = (EditText) findViewById(R.id.account_et);
        mPasswordEt = (EditText) findViewById(R.id.password_et);
        mInsertBtn = (Button) findViewById(R.id.insert_btn);
        mInsertBtn.setOnClickListener(MainActivity.this);
        mDeleteBtn = (Button) findViewById(R.id.delete_btn);
        mDeleteBtn.setOnClickListener(MainActivity.this);
        mUpdateBtn = (Button) findViewById(R.id.update_btn);
        mUpdateBtn.setOnClickListener(MainActivity.this);
        mQueryBtn = (Button) findViewById(R.id.query_btn);
        mQueryBtn.setOnClickListener(MainActivity.this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new UserAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        String account = mAccountEt.getText().toString();
        String password = mPasswordEt.getText().toString();

        if (view.getId() == R.id.insert_btn) {
            insertData(account, password);
        } else if (view.getId() == R.id.delete_btn) {

        } else if (view.getId() == R.id.update_btn) {

        } else if (view.getId() == R.id.query_btn) {
            queryData();
        }
    }

    // 插入数据
    private void insertData(String account, String password) {
        UserBean insertUser = new UserBean();
        insertUser.set_id(System.currentTimeMillis());
        insertUser.setAccount(account);
        insertUser.setPassword(password);
        // 执行插入数据
        mDao.insert(insertUser);
        Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
    }

    // 查询全部数据
    private void queryData() {
        // 1、构建一个查询对象，专门用于执行查询操作
        QueryBuilder<UserBean> builder = mDao.queryBuilder();
        // 构建的过程中如果需要查询条件，则顺便一起配置
        Query<UserBean> query = builder.build();
        // 2、使用查询对象执行查询操作
        List<UserBean> users = query.list();// 代表查询多个数据并自动封装到List中

        mAdapter.setDatas(users);
    }


}
