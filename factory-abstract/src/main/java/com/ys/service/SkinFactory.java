package com.ys.service;

/**
 * 界面批复工厂接口：抽象工厂
 *
 * @author nick
 * @create 2019-03-30 11:29
 */
public interface SkinFactory {
    public Button createButton();

    public TextField createTextField();

    public ComboBox createComboBox();
}
