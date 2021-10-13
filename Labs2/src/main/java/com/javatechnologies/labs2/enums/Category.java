package com.javatechnologies.labs2.enums;

public enum Category {
    VOLVO("volvo"),
    TESLA("tesla"),
    BMW("bmw"),
    MERCEDES("mercedes"),
    SUBARU("subaru");

    private String type;
    Category(String type) {
        this.type = type;
    }

    public String getCategory() {
        return this.type;
    }

    public Category toCategory(String str) {
        for(Category category:Category.values()) {
            if(category.type.equalsIgnoreCase(str)) {
                return category;
            }
        }
        return null;
    }

}
