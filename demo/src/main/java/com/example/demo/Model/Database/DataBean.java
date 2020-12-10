package com.example.demo.Model.Database;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

/**
 * Created by Edgar Liu
 */
import org.mariadb.jdbc.Driver;
public class DataBean {
    DataSource dataSource;
    public DataBean(){
        dataSource=new BasicDataSource();

         String URL ="jdbc:mysql://voghost-server.mysql.rds.aliyuncs.com:3306/business_management?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
         String URL1 ="jdbc:mariadb://127.0.0.1:3306/javatest?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";

         String userName1="user_bm";
         String password1="Lf@1141776830";

        String userName2="phpTest";
        String password2="phptest";

        ((BasicDataSource)dataSource).setDriverClassName("org.mariadb.jdbc.Driver");
        ((BasicDataSource)dataSource).setUrl(URL1);
        ((BasicDataSource)dataSource).setUsername(userName2);
        ((BasicDataSource)dataSource).setPassword(password2);

    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
