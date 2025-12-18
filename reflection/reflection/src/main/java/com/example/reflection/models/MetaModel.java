package com.example.reflection.models;

import com.example.reflection.models.annotation.Column;
import com.example.reflection.models.annotation.PrimaryKey;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MetaModel<T> {

    private Class<T> tClass;

    public static <T> MetaModel<T> of(Class<T> tClass) {
        return new MetaModel<>(tClass);
    }

    public MetaModel(Class<T> tClass) {
        this.tClass = tClass;
    }

    public PrimaryKeyField getPrimaryKey() {
        Field[] fields = this.tClass.getDeclaredFields();
        for (Field field : fields) {
            PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);
            if (primaryKey != null) {
                PrimaryKeyField primaryKeyField = new PrimaryKeyField(field);
                return primaryKeyField;
            }
        }

        throw new IllegalArgumentException("No primary key found in class " + tClass.getSimpleName());
    }

    public List<ColumnField> getColumnField() {
        Field[] fields = this.tClass.getDeclaredFields();

        List<ColumnField> columnFields = new ArrayList<>();
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                ColumnField columnField = new ColumnField(field);
                columnFields.add(columnField);
            }
        }

        return columnFields;
    }
}
