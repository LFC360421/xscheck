package com.xscheck.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.*;

public class ExcelUtil {
//    private String[]  excelHeaders={"学号","姓名","性别","联系电话","专业班级"};

//    导出excle
    public void exportExcel(HttpServletResponse response,String fileName,String[] excelHeaders, List<String[]> data)
            throws IOException {
        //实例化HSSFWorkbook,声明一个工作簿
        HSSFWorkbook  hssfWorkbook=new HSSFWorkbook();
        //创建一个Excel表单，参数为sheet的名字
        HSSFSheet sheet=hssfWorkbook.createSheet(fileName);
        //创建表头
        HSSFRow  header=sheet.createRow(0);
        for(int i=0;i<excelHeaders.length;i++){
            header.createCell(i).setCellValue(excelHeaders[i]);
        }
       //给表格添加数据
        for(int i=0;i<data.size();i++){
            HSSFRow row=sheet.createRow(i+1);
            for(int j=0;j<data.get(i).length;j++) {
                row.createCell(j).setCellValue(data.get(i)[j]);
            }
        }
        //清空response
        response.reset();
        //设置response的Header
        response.addHeader("Content-Disposition","attachment;filename="+fileName);
        OutputStream os=new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/vnd.ms-excel;charset=gb2312");
        //将Excel写入到输出流中
        hssfWorkbook.write(os);
        os.flush();
        os.close();

    }

//Excel导入
    public List<Object[]>  importExcel(MultipartFile file) throws IOException {
        List<Object[]> list=new ArrayList<>();
//        InputStream inputStream=new FileInputStream(filePath);
        HSSFWorkbook hssfWorkbook=new HSSFWorkbook(file.getInputStream());
        //默认第一个sheet
        HSSFSheet sheet=hssfWorkbook.getSheetAt(0);
        //获取sheet的行数
        int rows=sheet.getPhysicalNumberOfRows();
        for(int i=0;i<rows;i++){
            //过滤表头行
            if(i==0){
                continue;
            }
            //获取当前行数据
            HSSFRow row=sheet.getRow(i);
            Object[] objects=new Object[row.getPhysicalNumberOfCells()];
            int cellNum=0;
            for(Cell cell : row){
                if (cell.getCellTypeEnum().equals(NUMERIC)) {
                    objects[cellNum] = (int) cell.getNumericCellValue();
                }
                if (cell.getCellTypeEnum().equals(STRING)) {
                    objects[cellNum] = cell.getStringCellValue();
                }
                if (cell.getCellTypeEnum().equals(BOOLEAN)) {
                    objects[cellNum] = cell.getBooleanCellValue();
                }
                if (cell.getCellTypeEnum().equals(ERROR)) {
                    objects[cellNum] = cell.getErrorCellValue();
                }
                cellNum++;
            }
            list.add(objects);
        }
        return  list;
    }
// excel导入
    public List<Object[]>  importExcel2(MultipartFile file) throws IOException, InvalidFormatException {
        List<Object[]> list=new ArrayList<>();
//        InputStream inputStream=new FileInputStream(filePath);
        Workbook hssfWorkbook= WorkbookFactory.create(file.getInputStream());
        //默认第一个sheet
        Sheet sheet=hssfWorkbook.getSheetAt(0);
        //获取sheet的行数
        int rows=sheet.getPhysicalNumberOfRows();
        for(int i=0;i<rows;i++){
            //过滤表头行
            if(i==0){
                continue;
            }
            //获取当前行数据
            Row row=sheet.getRow(i);
            Object[] objects=new Object[row.getPhysicalNumberOfCells()];
            int cellNum=0;
            for(Cell cell : row){
                if (cell.getCellTypeEnum().equals(NUMERIC)) {
                    objects[cellNum] = (int) cell.getNumericCellValue();
                }
                if (cell.getCellTypeEnum().equals(STRING)) {
                    objects[cellNum] = cell.getStringCellValue();
                }
                if (cell.getCellTypeEnum().equals(BOOLEAN)) {
                    objects[cellNum] = cell.getBooleanCellValue();
                }
                if (cell.getCellTypeEnum().equals(ERROR)) {
                    objects[cellNum] = cell.getErrorCellValue();
                }
                cellNum++;
            }
            list.add(objects);
        }
        return  list;
    }
}
