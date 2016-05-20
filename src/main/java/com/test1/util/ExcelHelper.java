package com.test1.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

// Reusable Excel Helper Class to work with and read/write from excel files
// Base class for all other helper class that use excel

public class ExcelHelper 
{
	private String filePath; //file path of the excel file
	private FileInputStream fis; // file input stream to read data based on excel file
	private Workbook workbook; // excel workbook variable to work with excel feil
	
	// excel helper constructor which takes file path and initializes member variables
	public ExcelHelper(String filePath)
	{
		this.filePath = filePath;
		try
		{
			fis = new FileInputStream(filePath);
			// create an apache POI workbook object for the excel file path provided
			
			workbook = WorkbookFactory.create(fis);
			
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String getFilePath()
	{
		return filePath;
	}
	
	//Get total number of rows for a given excel sheet
	public int getRowCount(String sheetName)
	{
		try
		{
			return workbook.getSheet(sheetName).getPhysicalNumberOfRows();
		}
		catch(NullPointerException e)
		{
			return 0;
		}
			
	}
	
	public int getCellCount(String sheetName, int rowNumber)
	{
		try
		{
			return workbook.getSheet(sheetName).getRow(rowNumber-1).getPhysicalNumberOfCells();
		}
		
		catch(NullPointerException e)
		{
			return 0;
		}
		
	}
	
	// Get cell data when excel sheet row number and column number are provided
	//return "" (blank string) when specified cell doesn't exist
	public String getCellData(String sheetName, int columnNumber, int rowNumber)
	{
		try
		{
			return workbook.getSheet(sheetName).getRow(rowNumber-1).getCell(columnNumber-1).toString();
		}
		catch(NullPointerException e)
		{
			//Catch Nullpointer exception exception and return blank string when specified cell doesn't exist
			return "";
		}
		
	}
	
	public void setCellData(String sheetName, int columnNumber, int rowNumber, String cellValue)
	{
		Cell cell;
		Row row;
		try
		{
		cell = workbook.getSheet(sheetName).getRow(rowNumber-1).createCell(columnNumber-1);
		}
		catch(NullPointerException e)
		{
			row = workbook.getSheet(sheetName).createRow(rowNumber-1);
			cell = row.createCell(columnNumber-1);
		}
		
		cell.setCellValue(cellValue);
		try
		{
			FileOutputStream fso = new FileOutputStream(filePath);
			workbook.write(fso);
			fso.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	// get row number based on cell value in specified column
	// return -1 if there is no row with that cell value in specified column
	public int getRowNumber(String sheetName, int columnNumber, String cellValue)
	{
		Iterator<Row> itr = workbook.getSheet(sheetName).rowIterator();
		while(itr.hasNext())
		{
			Row row = itr.next();
			try{
				if (row.getCell(columnNumber-1).toString().equals(cellValue))
				{
					return (row.getRowNum()+1);
				}
			}
			catch(NullPointerException e)
			{
				continue;
			}
						
		}
		
		return -1;
			
	}
	
	// get column number based on cell value in specified row
	// return -1 if there is no column with that cell value in specified row
	public int getColumnNumber(String sheetName, int rowNumber, String cellValue)
	{
		try
		{
		Row row = workbook.getSheet(sheetName).getRow(rowNumber-1);
		
		Iterator<Cell> itr = row.cellIterator();
		while(itr.hasNext())
		{
			Cell cell = itr.next();
			if (cell.toString().equals(cellValue))
			{
				return (cell.getColumnIndex()+1);
			}
		}
		return -1;
		}
		catch(NullPointerException e)
		{
			return -1;
		}
		
	}
	
	
	

}
