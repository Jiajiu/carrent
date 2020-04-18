package com.jiu.sys.task;

import com.jiu.sys.constant.SysConstant;
import com.jiu.sys.utils.AppFileUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@EnableScheduling //开启定时任务
public class RecycleTempFileTask {

    /**
     * 每天晚上12点执行
     */
    @Scheduled(cron="0 0 0 * * ? ")
    public void recycleTempFile(){
        File file =new File(AppFileUtils.PATH);
        deleteFile(file);
    }

    /**
     * 删除图片
     * @param file
     */
    private void deleteFile(File file) {
        if(file!=null){
            File [] listFiles=file.listFiles();
            if(listFiles!=null&&listFiles.length>0){
                for (File f:listFiles){
                    if(f.isFile()){
                        if(f.getName().endsWith(SysConstant.FILE_UPLOAD_TEMP)){
                            f.delete();
                        }
                    }else{
                        //如果是文件夹，再递归删除
                        deleteFile(f);
                    }
                }
            }
        }
    }
}
