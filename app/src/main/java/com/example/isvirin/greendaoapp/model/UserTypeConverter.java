package com.example.isvirin.greendaoapp.model;

import org.greenrobot.greendao.converter.PropertyConverter;

public class UserTypeConverter implements PropertyConverter<UserType, String> {
    @Override
    public UserType convertToEntityProperty(String databaseValue) {
        return  UserType.valueOf(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(UserType entityProperty) {
        return entityProperty.name();
    }
}
