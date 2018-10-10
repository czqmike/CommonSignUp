package cn.edu.hbue.util;

import java.io.OutputStream;

import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;
import java.util.*;

import cn.edu.hbue.model.*;
/**
 * 基于POI的javaee导出Excel工具类
 * 
 * @author wjmisaboy@gmail.com
 * @modifier czqmike
 * @see POI
 * @url https://www.jb51.net/article/81053.htm
 */
public class ExportExcelUtil {
 /**
  * 
  * @param response
  *   请求
  * @param fileName
  *   文件名 如："学生表"
  * @param excelHeader 表头数组，其中CommonItems的表头顺序必须为学号， 姓名， 专业， 班级，入学年份
  * @param reports 包含Report的ArrayList
  * @return 返回一个HSSFWorkbook
  * @throws Exception
  */
 public static <T> HSSFWorkbook export(HttpServletResponse response, String fileName, String[] excelHeader,
   ArrayList<Report> reports) throws Exception {
//   Collection<T> dataList) throws Exception {
  // 设置请求
  response.setContentType("application/application/vnd.ms-excel");
  response.setHeader("Content-disposition",
    "attachment;filename=" + URLEncoder.encode(fileName + ".xls", "UTF-8"));
  // 创建一个Workbook，对应一个Excel文件
  HSSFWorkbook wb = new HSSFWorkbook();
  // 设置标题样式
  HSSFCellStyle titleStyle = wb.createCellStyle();
  // 设置单元格边框样式
  titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框 细边线
  titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框 细边线
  titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框 细边线
  titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框 细边线
  // 设置单元格对齐方式
  titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
  titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 垂直居中
  // 设置字体样式
  Font titleFont = wb.createFont();
  titleFont.setFontHeightInPoints((short) 15); // 字体高度
  titleFont.setFontName("黑体"); // 字体样式
  titleStyle.setFont(titleFont);
  // 在Workbook中添加一个sheet,对应Excel文件中的sheet
  HSSFSheet sheet = wb.createSheet(fileName);
  // 在sheet中添加标题行
  HSSFRow row = sheet.createRow((int) 0);// 行数从0开始
  HSSFCell sequenceCell = row.createCell(0);// cell列 从0开始 第一列添加序号
  sequenceCell.setCellValue("序号");
  sequenceCell.setCellStyle(titleStyle);
  sheet.autoSizeColumn(0);// 自动设置宽度
  // 为标题行赋值
  for (int i = 0; i < excelHeader.length; i++) {
   HSSFCell titleCell = row.createCell(i + 1);// 0号位被序号占用，所以需+1
   titleCell.setCellValue(excelHeader[i]);
   titleCell.setCellStyle(titleStyle);
   sheet.autoSizeColumn(i + 1);// 0号位被序号占用，所以需+1
  }
  // 数据样式 因为标题和数据样式不同 需要分开设置 不然会覆盖
  HSSFCellStyle dataStyle = wb.createCellStyle();
  // 设置数据边框
  dataStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
  dataStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
  dataStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
  dataStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
  // 设置居中样式
  dataStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
  dataStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 垂直居中
  // 设置数据字体
  Font dataFont = wb.createFont();
  dataFont.setFontHeightInPoints((short) 12); // 字体高度
  dataFont.setFontName("宋体"); // 字体
  dataStyle.setFont(dataFont);
  // 遍历集合数据，产生数据行
  for (int i = 0; i < reports.size(); ++i) {
	  row = sheet.createRow(i + 1);	// 第0行为表头 
	  HSSFCell sequenceCellValue = row.createCell(0);// 序号值永远是第0列
      sequenceCellValue.setCellValue(i);
	  sequenceCellValue.setCellStyle(dataStyle);
	  sheet.autoSizeColumn(0);
	   
	  CommonItems cItem = reports.get(i).getCommonItem();
	  ArrayList<AddonItem> aItem = reports.get(i).getAddonItem();
	   
	  for (int j = 1; j <= cItem.getPropertyNumber() + aItem.size(); ++j) {
	      HSSFCell dataCell = row.createCell(j);
	      String data = "";
		  dataCell.setCellStyle(dataStyle);
		  sheet.autoSizeColumn(j);
		  // 设置CommonItems
	      if (j <= cItem.getPropertyNumber()) { 
		    switch (j) {
	         case 1:
	        	 data = cItem.getStudent_no(); break;
	         case 2:
	        	 data = cItem.getName(); break;
	         case 3:
	        	 data = cItem.getMajor(); break;
	         case 4:
	        	 data = cItem.getClass_(); break;
	         case 5:
	        	 data = cItem.getReport_year(); break;
	         }
		  // 设置AddonItem
	      } else {
	    	  data =  aItem.get(j - cItem.getPropertyNumber() - 1).getAddon_value();
	      }
		  dataCell.setCellValue(data);// 为当前列赋值
	  }
  }

  OutputStream outputStream = response.getOutputStream();// 打开流
  wb.write(outputStream);// HSSFWorkbook写入流
//  wb.close();// HSSFWorkbook关闭
  outputStream.flush();// 刷新流
  outputStream.close();// 关闭流
  return wb;
 }
 // XSSFCellStyle.ALIGN_CENTER 居中对齐
 // XSSFCellStyle.ALIGN_LEFT 左对齐
 // XSSFCellStyle.ALIGN_RIGHT 右对齐
 // XSSFCellStyle.VERTICAL_TOP 上对齐
 // XSSFCellStyle.VERTICAL_CENTER 中对齐
 // XSSFCellStyle.VERTICAL_BOTTOM 下对齐

 // CellStyle.BORDER_DOUBLE 双边线
 // CellStyle.BORDER_THIN 细边线
 // CellStyle.BORDER_MEDIUM 中等边线
 // CellStyle.BORDER_DASHED 虚线边线
 // CellStyle.BORDER_HAIR 小圆点虚线边线
 // CellStyle.BORDER_THICK 粗边线
}
