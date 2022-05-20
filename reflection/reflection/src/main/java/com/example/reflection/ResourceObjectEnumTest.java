package com.example.reflection;

public class ResourceObjectEnumTest {
    public static void main(String[] args) {
        ResourceObjectType type = (ResourceObjectType.getResourceObjectType("securitygrouprule"));
        System.out.println(type.name() + " and ordinal is " + type.ordinal());
    }
}
