package com.jiu.stat.utils;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public class ExportHSSFCellStyle {

    /**
     * 创建基础样式
     * 水平和垂直居中
     * @param workbook
     * @return
     */
    public static HSSFCellStyle createBaseStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style=workbook.createCellStyle();
        //设置水平居中
        style.setAlignment(HorizontalAlignment.CENTER);
        //设置垂直居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    /**
     * 创建数据表格的头的样式
     * @param workbook
     * @return
     */
    public static HSSFCellStyle createSubTitleStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style=createBaseStyle(workbook);
        //设置字体
        HSSFFont font=workbook.createFont();
        font.setBold(true);//是否加粗
        font.setItalic(true);//是否斜体
        font.setFontHeightInPoints((short) 20);//设置字体大小
        font.setColor(HSSFColor.HSSFColorPredefined.DARK_YELLOW.getIndex());//设置颜色
        font.setFontName("黑体");//设置字体
        style.setFont(font);
        return style;
    }

    /**
     * 创建表格小标题样式
     * @param workbook
     * @return
     */
    public static HSSFCellStyle createTableTitleStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style=createBaseStyle(workbook);
        //设置字体
        HSSFFont font=workbook.createFont();
        font.setBold(true);//是否加粗
       // font.setItalic(true);//是否斜体
        font.setFontHeightInPoints((short)20);//设置字体大小
        font.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        font.setFontName("黑体");//设置字体
        style.setFont(font);
        return style;
    }

    /**
     * 创建标题样式
     * @param workbook
     * @return
     */
    public static HSSFCellStyle createTitleStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style=createBaseStyle(workbook);
       //设置字体样式
        HSSFFont font=workbook.createFont();
        font.setBold(true);//是否加粗
        font.setFontHeightInPoints((short)35);//设置字体大小
        font.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
        font.setFontName("华文行楷");//设置字体
        style.setFont(font);
        return style;
    }
}
