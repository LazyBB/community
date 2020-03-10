package com.bbdemo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO<T> {
    private List<T> data;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;

    private Integer currentPage;
    private List<Integer> pages=new ArrayList<>();;
    private Integer totalpage;

    public void setpagination(Integer totalpage, Integer page) {
        currentPage=page;
        this.totalpage=totalpage;

        pages.add(page);
        for (int i=1;i<4;i++){
            if (page-i>0) {
                pages.add(0,page-i);
            }
            if (page+i<totalpage+1){
                pages.add(page+i);
            }
        }

        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }

        if (page == totalpage) {
            showNext = false;
        } else {
            showNext = true;
        }

        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        if (pages.contains(totalpage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
