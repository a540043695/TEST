package com.qf1514.wateractivity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * 步骤
 * 导入Volley,RecyclerView,Gson等jar包
 * 在布局文件中添加RecylerView控件，然后新建一个java文件，继承Apllication，再去清单文件中的Apllication下面添加name属性
 * 再回到主函数中，利用StringRequest请求到网络数据，再利用ImageRequest拿到解析出来的图片地址，然后通过RecyclerView的adapter方法设置图片。
 * 然后给recyclerView设置适配器。
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private List<Bitmap> list;
    private MyWaterAdapter myWaterAdapter;
    private int j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getJsonData();
    }

    /**
     * 获取网络请求的数据
     */
    private void getJsonData() {
        String url = "http://api.avatardata.cn/Image/Search?key=256718eb996945558a4ff78c6f622fde&keyword=%E7%BE%8E%E5%A5%B3";
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            //请求网络数据成功，开始解析出图片地址
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                MyPic pic = gson.fromJson(response, MyPic.class);
                for (int i = 0; i < pic.getResult().size(); i++) {
                    String imgUrl = pic.getResult().get(i).get(0);
                    downLoadIMG(imgUrl);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MyApplication.requestQueue.add(stringRequest);
    }

    private void downLoadIMG(String imgUrl) {
        ImageRequest imageRequest = new ImageRequest(imgUrl, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                list.add(response);
                myWaterAdapter.notifyItemRemoved(j);
                j++;
            }
        }, 500, 500, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MyApplication.requestQueue.add(imageRequest);
    }

    /**
     * 初始化RecyclerView
     * 并设置适配器
     */
    private void initView() {

        rv = (RecyclerView) findViewById(R.id.rv_main_meinv);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(staggeredGridLayoutManager);



        list = new ArrayList<>();
        myWaterAdapter = new MyWaterAdapter(list, this);
        rv.setAdapter(myWaterAdapter);
    }
}
