package com.hhtt.blog.util;
import com.github.pagehelper.PageInfo;
import com.hhtt.blog.Constant;

/**
 * @author hhtt
 * @date 2020/5/19 17:01
 * description:分页查询相关工具类
 */
public class PageUtils {
    /**
     * 将分页信息封装到统一的接口
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        pageResult.setFirstPage(pageInfo.isIsFirstPage());
        pageResult.setLastPage(pageInfo.isIsLastPage());
        return pageResult;
    }

    public static PageRequest getPageRequest(Integer startPage,Integer pageSize){
        if(startPage == null || startPage <= 1){
            startPage = 1;
        }
        if(pageSize == null || pageSize <= 0){
            pageSize = Constant.PAGE_DEFAULT_SIZE;
        }
        return new PageRequest(startPage,pageSize);
    }

    public static PageRequest getPageRequest(){

        return new PageRequest(1,Constant.PAGE_DEFAULT_SIZE);
    }

    public static PageRequest getPageRequest(Integer startPage){

        return getPageRequest(startPage,Constant.PAGE_DEFAULT_SIZE);
    }
}
