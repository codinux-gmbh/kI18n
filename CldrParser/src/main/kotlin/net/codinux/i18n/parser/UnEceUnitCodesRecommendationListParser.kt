package net.codinux.i18n.parser

import net.codinux.i18n.model.UnEceUnitCodesRecommendation
import net.codinux.i18n.model.UnEceUnitCodesRecommendationStatus
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.nio.file.Path
import kotlin.io.path.inputStream

class UnEceUnitCodesRecommendationListParser {

    fun parseRecommendation20UnitCodesList(file: Path): List<UnEceUnitCodesRecommendation> {
        val workbook = XSSFWorkbook(file.inputStream())
        val sheets = workbook.sheetIterator().asSequence().toList().filterIsInstance<XSSFSheet>()

        val annex1Sheet = sheets.first { it.sheetName == "Annex I" } // or: workbook.getSheetAt(1)
        val annex2And3Sheet = sheets.first { it.sheetName == "Annex II & Annex III" } // or: workbook.getSheetAt(2)

        return parseSheet(annex1Sheet) + parseSheet(annex2And3Sheet)
    }

    private fun parseSheet(sheet: XSSFSheet): List<UnEceUnitCodesRecommendation> {
        val headerRow = sheet.getRow(0)
        val headerCells = headerRow.cellIterator().asSequence().toList().associateBy { it.stringCellValue.replace('\n', ' ').replace("\r", "") }

        val codeColumnIndex = headerCells["Common Code"]!!.columnIndex
        val nameColumnIndex = headerCells["Name"]!!.columnIndex
        val descriptionColumnIndex = headerCells["Description"]!!.columnIndex
        val statusColumnIndex = headerCells["Status"]!!.columnIndex
        val levelOrCategoryColumnIndex = (headerCells["Level/ Category"] ?: headerCells["Level / Category"])!!.columnIndex
        val symbolColumnIndex = headerCells["Symbol"]!!.columnIndex
        val conversionFactorColumnIndex = headerCells["Conversion Factor"]!!.columnIndex

        val quantityColumnIndex = headerCells["Quantity"]?.columnIndex
        val groupNumberColumnIndex = headerCells["Group Number"]?.columnIndex
        val groupIdColumnIndex = headerCells["Group ID"]?.columnIndex
        val sectorColumnIndex = headerCells["Sector"]?.columnIndex

        return sheet.rowIterator().asSequence().toList().drop(1).map { row ->
            UnEceUnitCodesRecommendation(
                getValue(row, codeColumnIndex), getValue(row, nameColumnIndex), getValueOrNull(row, descriptionColumnIndex),
                mapStatus(getValueOrNull(row, statusColumnIndex)), getValueOrNull(row, levelOrCategoryColumnIndex),
                getValueOrNull(row, symbolColumnIndex), getValueOrNull(row, conversionFactorColumnIndex),

                getValueOrNull(row, quantityColumnIndex), getValueOrNull(row, groupNumberColumnIndex),
                getIntOrNull(row, groupIdColumnIndex), getValueOrNull(row, sectorColumnIndex),
            )
        }
    }

    private fun mapStatus(value: String?): UnEceUnitCodesRecommendationStatus? = when (value) {
        // see PDF rec20_Rev7e_2010.pdf p. 8
        "+" -> UnEceUnitCodesRecommendationStatus.Added
        "#" -> UnEceUnitCodesRecommendationStatus.ChangedName
        "¦", "|" -> UnEceUnitCodesRecommendationStatus.ChangedCharacteristics
        "D" -> UnEceUnitCodesRecommendationStatus.Deprecated
        "X" -> UnEceUnitCodesRecommendationStatus.MarkedAsDeleted
        "=" -> UnEceUnitCodesRecommendationStatus.Reinstated
        else -> null
    }

    private fun getValue(row: Row, columnIndex: Int): String {
        val cell = row.getCell(columnIndex)
            return when (cell.cellType) {
                CellType.NUMERIC -> cell.numericCellValue.toInt().toString()
                else -> cell.stringCellValue
            }
    }

    private fun getValueOrNull(row: Row, columnIndex: Int?): String? =
        columnIndex?.let {
            getValue(row, columnIndex).takeUnless { it.isBlank() }
        }

    private fun getIntOrNull(row: Row, columnIndex: Int?): Int? =
        getValueOrNull(row, columnIndex)?.toIntOrNull()

}