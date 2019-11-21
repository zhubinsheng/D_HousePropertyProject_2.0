package com.example.d_housepropertyproject.greendao;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;

public class User {
    @Id(autoincrement = true)
    private Long id;//注意id类型是long的包装类Long
    @Unique
    @NotNull
    private String name;
    private int age;


    @Generated(hash = 586692638)
    public User() {
    }

    @Generated(hash = 955858333)
    public User(Long id, @NotNull String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    //省去getter，setter方法
}
