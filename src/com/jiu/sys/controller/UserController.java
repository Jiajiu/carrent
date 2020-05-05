package com.jiu.sys.controller;

import com.jiu.sys.service.UserService;
import com.jiu.sys.utils.DataGridView;
import com.jiu.sys.utils.ResultObj;
import com.jiu.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理控制器
 * @author Jiu
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 加载用户列表返回DataGridView
     * @param userVo
     * @return
     */
    @RequestMapping("loadAllUser")
    public DataGridView loadAllUser(UserVo userVo){
        return this.userService.queryAllUser(userVo);
    }

    /**
     * 添加用户
     * @param userVo
     * @return
     */
    @RequestMapping("addUser")
    public ResultObj addUser(UserVo userVo){
        try{
            this.userService.addUser(userVo);
            return ResultObj.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.ADD_FAILED;
        }
    }

    /**
     * 修改用户
     * @param userVo
     * @return
     */
    @RequestMapping("updateUser")
    public ResultObj updateUser(UserVo userVo){
        try{
            this.userService.updateUser(userVo);
            return ResultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.UPDATE_FAILED;
        }
    }

    /**
     * 删除用户
     * @param userVo
     * @return
     */
    @RequestMapping("deleteUser")
    public ResultObj deleteUser(UserVo userVo){
        try{
            this.userService.deleteUser(userVo.getUserid());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_FAILED;
        }
    }

    /**
     * 批量删除用户
     * @param userVo
     * @return
     */
    @RequestMapping("deleteBatchUser")
    public ResultObj deleteBatchUser(UserVo userVo){
        try {
            this.userService.deleteBatchUser(userVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_FAILED;
        }
    }

    /**
     * 重置用户密码
     * @param userVo
     * @return
     */
    @RequestMapping("resetUserPwd")
    public ResultObj resetUserPwd(UserVo userVo){
        try{
            this.userService.resetUsrPwd(userVo.getUserid());
            return ResultObj.RESET_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.RESET_FAILED;
        }
    }

    /**
     * 加载用户管理的分配角色的数据
     * @param userVo
     * @return
     */
    @RequestMapping("initUserRole")
    public DataGridView initUserRole(UserVo userVo){
        return this.userService.queryUserRole(userVo.getUserid());
    }

    /**
     * 保存用户和角色间的关系
     * @param userVo
     * @return
     */
    @RequestMapping("saveUserRole")
    public ResultObj saveUserRole(UserVo userVo){
        try{
            this.userService.saveUserRole(userVo);
            return ResultObj.DISPATCH_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DISPATCH_FAILED;
        }
    }

    /**
     * 根据用户名修改密码
     * @param uname
     * @param pwd
     * @return
     */
    @RequestMapping("changePwd")
    public ResultObj changePwd(String uname,String pwd){
        try{
            this.userService.changePwd(uname,pwd);
            return ResultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.UPDATE_FAILED;
        }
    }
}
