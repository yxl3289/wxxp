package com.example.snack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.HashMap;
import java.util.Map;


public class Xiangqing extends AppCompatActivity {
    public String[][] array=new String[10][10];//用于保存详情网址
    private Map<String,Object> map; //用于存放

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutxiangqing);
        initdata();
        loadXiangqing();
        setTitle("详情页面");//设置当前页面标题
    }
    /*点击返回按钮返回到分类界面*/
    public void btnback(View view){
        finish(); //关闭详情页面
        /**Intent i=new Intent(Xiangqing.this,MainActivity.class);
         startActivity(i);//启动跳转*/

    }

    //加载对应详情界面数据
    public void loadXiangqing(){
        Intent i=getIntent();
        int index1=i.getExtras().getInt("分类号");
        int index2=i.getExtras().getInt("商品号");
        int image=i.getExtras().getInt("图片");
        String name=i.getExtras().getString("名称");
        String price=i.getExtras().getString("价格");
        map=new HashMap<String,Object>();
        map.put("cartimage",image);
        map.put("cartname",name);
        map.put("cartprice",price);

        WebView web=(WebView)findViewById(R.id.xiangqing);//用web加载详情网址
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(array[index1][index2]);
    }



    /*给二维数组赋值*/
    public void initdata(){
        array[0][0]="http://m.3songshu.com/#/tabs/index/productInfo?productId=100112858";
        array[0][1]="http://m.3songshu.com/mobile/api/share/handle?type=product&id=100112842";
        array[0][2]="https://m.vipbcw.com/data-list/detail-goods?id=3726&spm=MTU0OTI3OQ==";
        array[0][3]="https://m.vipbcw.com/data-list/detail-goods?id=2931&spm=MTU0OTI3OQ==";
        array[0][4]="https://m.vipbcw.com/data-list/detail-goods?id=4157&spm=MTU0OTI3OQ==";
        array[0][5]="https://m.vipbcw.com/data-list/detail-goods?id=4083&spm=MTU0OTI3OQ==";
        array[0][6]="https://m.vipbcw.com/data-list/detail-goods?id=4082&spm=MTU0OTI3OQ==";
        array[0][7]="https://m.vipbcw.com/data-list/detail-goods?id=4080&spm=MTU0OTI3OQ==";

        array[1][0]="http://m.3songshu.com/mobile/api/share/handle?type=product&id=100114928";
        array[1][1]="https://m.vipbcw.com/data-list/detail-goods?id=4222&spm=MTU0OTI3OQ==";
        array[1][2]="https://m.vipbcw.com/data-list/detail-goods?id=3959&spm=MTU0OTI3OQ==";
        array[1][3]="https://m.vipbcw.com/data-list/detail-goods?id=3952&spm=MTU0OTI3OQ==";
        array[1][4]="https://m.vipbcw.com/data-list/detail-goods?id=1418&spm=MTU0OTI3OQ==";

        array[2][0]="https://m.vipbcw.com/data-list/detail-goods?id=4109&spm=MTU0OTI3OQ==";
        array[2][1]="https://m.vipbcw.com/data-list/detail-goods?id=4100&spm=MTU0OTI3OQ==";
        array[2][2]="https://m.vipbcw.com/data-list/detail-goods?id=3969&spm=MTU0OTI3OQ==";
        array[2][3]="https://m.vipbcw.com/data-list/detail-goods?id=3926&spm=MTU0OTI3OQ==";
        array[2][4]="https://m.vipbcw.com/data-list/detail-goods?id=3924&spm=MTU0OTI3OQ==";

        array[3][0]="https://m.vipbcw.com/data-list/detail-goods?id=4103&spm=MTU0OTI3OQ==";
        array[3][1]="https://m.vipbcw.com/data-list/detail-goods?id=4091&spm=MTU0OTI3OQ==";


        array[9][1]="http://m.3songshu.com/mobile/api/share/handle?type=specialPage&id=8002";
        array[9][2]="http://m.3songshu.com/mobile/api/share/handle?type=product&id=100100264";
        array[9][3]="http://m.3songshu.com/mobile/api/share/handle?type=product&id=100100235";
        array[9][4]="https://m.vipbcw.com/data-list/detail-goods?id=4108";
        array[9][5]="https://m.vipbcw.com/data-list/detail-goods?id=4105";
    }



    /*点击加入购物车将物品加入到购物车里面,并跳转到购物车页面*/
    public void btnjia(View view){
        Cartcount.cartdata.add(map); //把数据添加到购物车list集合
        Fragment3.adapter.notifyDataSetChanged();
        finish();//关闭详情页面
        MainActivity.vp.setCurrentItem(2,true);//打开购物车界面

    }


}
