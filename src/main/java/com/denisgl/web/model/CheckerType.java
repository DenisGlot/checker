package com.denisgl.web.model;

public enum CheckerType {

    REGULAR,
    KING,
    NONE;

    public boolean equalsType(CheckerType other) {
        return equals(other);
    }
}
