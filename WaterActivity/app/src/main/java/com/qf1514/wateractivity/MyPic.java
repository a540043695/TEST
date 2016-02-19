package com.qf1514.wateractivity;

import java.util.List;

/**
 * Created by Administrator on 2016/1/19.
 */
public class MyPic {

    /**
     * result : [["http://www.bz55.com/uploads/allimg/100722/09245610T-4.jpg","美女模特宽屏壁纸(5)-55壁纸网"],["http://img15.yixiu8.com:8080/picture/140124/pic3/15.jpg","纤细身材美女高清丝袜图片(2)"],["http://pic4.bbzhi.com/mingxingbizhi/gaoqingqingliangmeinvsheyingbizhi/gaoqingqingliangmeinvsheyingbizhi_492993_10.jpg","壁纸1440×900高清清凉美女摄影 "],["http://image.tianjimedia.com/uploadImages/2013/070/KYH2Q1WV83C9.jpg","查看原图"],["http://img.uumnt.com/uploads/allimg/150618/1-15061Q64536.jpg","美女 写真 146 大 胸 美女 6 内衣 "],["http://img.419mm.com/meinv/minisuka.tv/hikari/p_hikari-a2_05_015.jpg","一夜情美女图片 &gt;&gt; 日本美女 "],["http://www.578mm.com/uploads/20140420/115.jpg","美胸美女护士制服终极诱惑 "],["http://pic1.win4000.com/pic/b/a3/fb13404919.jpg","美女 内衣美女诱惑写真_美女 "],["http://img01.6188.net/pic/allimg/2015-05-05/3-1505051A513-50.jpg","标签: 私房写真 妖娆美女"],["http://img8.9158.com/200903/24/14/45/200903244493425.gif","动态精华美女图片（原创分享 "]]
     * error_code : 0
     * reason : Succes
     */

    private int error_code;
    private String reason;
    private List<List<String>> result;

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setResult(List<List<String>> result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public String getReason() {
        return reason;
    }

    public List<List<String>> getResult() {
        return result;
    }
}
