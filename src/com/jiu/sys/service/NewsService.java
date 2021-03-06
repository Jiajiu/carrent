package com.jiu.sys.service;

import com.jiu.sys.domain.News;
import com.jiu.sys.utils.DataGridView;
import com.jiu.sys.vo.NewsVo;

public interface NewsService {

    /**
     * 查询所有公告
     * @param newsVo
     * @return
     */
    public DataGridView queryAllNews(NewsVo newsVo);

    /**
     * 添加公告
     * @param newsVo
     */
    public void addNews(NewsVo newsVo);

    /**
     * 修改公告
     * @param newsVo
     */
    public void updateNews(NewsVo newsVo);

    /**
     * 根据id删除公告
     * @param newsid
     */
    public void deleteNews(Integer newsid);

    /**
     * 批量删除公告
     * @param ids
     */
    public void deleteBatchNews(Integer [] ids);

    /**
     * 根据id查询一个公告
     * @param id
     * @return
     */
    public News queryNewById(Integer id);
}
