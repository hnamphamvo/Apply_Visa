package core.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private WebElement locator;

    private final String colXpath            = "./thead/tr/th";
    private final String rowXpath            = "./tbody/tr";
    private final String rowByIndex          = rowXpath + "[%s]";
    private final String cellOfRowByColIndex = "./td[%s]";

    public WebElement getChildElement(String element) {
        return locator.findElement(By.xpath(element));
    }

    public List<WebElement> getChildElements(String element) {
        return locator.findElements(By.xpath(element));
    }

    public List<String> getAllColumnName() {
        List<String> columnList = new ArrayList<>();
        List<WebElement> columns = getChildElements(colXpath);
        for (WebElement col : columns) {
            columnList.add(col.getText());
        }
        return columnList;
    }

    public int getColumnIndex(String columnName) {
        return getAllColumnName().indexOf(columnName) + 1;
    }

    public List<Integer> getRowsIndexByText(String colName, String anchorVal) {
        int colIdx = getColumnIndex(colName);
        List<WebElement> rows = getChildElements(rowXpath);
        int i = 1;
        List<Integer> indexes = new ArrayList<>();
        for (WebElement row : rows) {
            WebElement cell = row.findElement(By.xpath(String.format(cellOfRowByColIndex, colIdx)));
            if (cell.getText().equals(anchorVal))
                indexes.add(i);
            i++;
        }
        return indexes;
    }

    public int getRowIndexByUniqueText(String colName, String anchorVal) {
        List<Integer> indexes = getRowsIndexByText(colName, anchorVal);
        if (indexes.size() == 0)
            throw new RuntimeException("Can't find the row");
        return indexes.get(0);
    }

    public WebElement getCell(int colIdx, int rowIdx) {
        WebElement row = getChildElement(String.format(rowByIndex, rowIdx));
        return row.findElement(By.xpath(String.format(cellOfRowByColIndex, colIdx)));
    }

    public WebElement getCell(String colName, String anchorCol, String anchorVal) {
        int colIdx = getColumnIndex(colName);
        int rowIdx = getRowIndexByUniqueText(anchorCol, anchorVal);
        return getCell(colIdx, rowIdx);
    }

    public WebElement getCell(String columnName, int rowIdx) {
        int colIdx = getColumnIndex(columnName);
        WebElement row = getChildElement(String.format(rowByIndex, rowIdx));
        return row.findElement(By.xpath(String.format(cellOfRowByColIndex, colIdx)));
    }

    public String getCellValue(String colName, String anchorCol, String anchorVal) {
        return getCell(colName, anchorCol, anchorVal).getText().trim();
    }
}
