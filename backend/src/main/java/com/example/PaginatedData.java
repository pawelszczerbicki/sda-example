package com.example;

import java.util.List;

public class PaginatedData<T> {

    private int size;

    private List<T> data;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
