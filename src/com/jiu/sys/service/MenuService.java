package com.jiu.sys.service;

import com.jiu.sys.domain.Menu;
import com.jiu.sys.utils.DataGridView;
import com.jiu.sys.vo.MenuVo;

import java.util.List;

/**
 * 菜单管理的服务窗口
 * @author Jiu
 */
public interface MenuService {

    /**
     * 查询所有菜单返回
     * List<Menu>
     */
    public List<Menu> queryAllMenuForList(MenuVo menuVo);

    /**
     * 根据用户Id查询用户可用菜单
     */
    public List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer userId);

    /**
     * 查询所有菜单
     * @param menuVo
     * @return
     */
    public DataGridView queryAllMenu(MenuVo menuVo);

    /**
     * 添加菜单
     * @param menuVo
     */
    public void addMenu(MenuVo menuVo);

    /**
     * 修改菜单
     * @param menuVo
     */
    public void updateMenu(MenuVo menuVo);

    /**
     * 根据pid查询菜单数量
     * @param pid
     * @return
     */
    public Integer queryMenuByPid(Integer pid);

    /**
     * 根据id删除菜单
     * @param menuVo
     */
    public void deleteMenu(MenuVo menuVo);


}
