package net.codinux.i18n.parser

import net.codinux.i18n.UnitAnnex
import net.codinux.i18n.UnitCategory
import net.codinux.i18n.UnitLevel
import net.codinux.i18n.model.UnEceUnitCodesRecommendation
import net.codinux.i18n.model.UnEceUnitCodesRecommendationStatus
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.inputStream

class UnEceUnitCodesRecommendationListParser {

    companion object {
        // bot paths are stated from project root folder on
        val Recommendation20UnitsFile by lazy { Path("").resolve("docs/units/rec20_Rev17e-2021.xlsx") }

        val Recommendation21UnitsFile by lazy { Path("").resolve("docs/units/rec21_Rev12e_Annex-V-VI_2021.xls") }
    }


    fun parseRecommendation20UnitCodesList(file: Path = Recommendation20UnitsFile): List<UnEceUnitCodesRecommendation> {
        val workbook = XSSFWorkbook(file.inputStream())
        val sheets = workbook.sheetIterator().asSequence().toList().filterIsInstance<XSSFSheet>()

        val annex1Sheet = sheets.first { it.sheetName == "Annex I" } // or: workbook.getSheetAt(1)
        val annex2And3Sheet = sheets.first { it.sheetName == "Annex II & Annex III" } // or: workbook.getSheetAt(2)

        return parseRecommendation20Sheet(annex1Sheet, UnitAnnex.Annex1) + parseRecommendation20Sheet(annex2And3Sheet, UnitAnnex.Annex2or3)
    }

    private fun parseRecommendation20Sheet(sheet: XSSFSheet, annex: UnitAnnex): List<UnEceUnitCodesRecommendation> {
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
            val levelOrCategory = getValueOrNull(row, levelOrCategoryColumnIndex)

            UnEceUnitCodesRecommendation(
                getValue(row, codeColumnIndex), getValue(row, nameColumnIndex), getValueOrNull(row, descriptionColumnIndex),
                mapStatus(getValueOrNull(row, statusColumnIndex)), levelOrCategory,
                getValueOrNull(row, symbolColumnIndex), getValueOrNull(row, conversionFactorColumnIndex),

                annex, mapLevel(levelOrCategory), mapCategory(levelOrCategory),

                getValueOrNull(row, quantityColumnIndex), getValueOrNull(row, groupNumberColumnIndex),
                getIntOrNull(row, groupIdColumnIndex), getValueOrNull(row, sectorColumnIndex),
            )
        }
    }

    private fun mapLevel(levelOrCategory: String?): UnitLevel? = when (levelOrCategory?.first()) {
        '1' -> UnitLevel.Normative
        '2' -> UnitLevel.NormativeEquivalent
        '3' -> UnitLevel.Informative
        else -> null
    }

    private fun mapCategory(levelOrCategory: String?): UnitCategory? {
        if (levelOrCategory?.startsWith("3.") == true && levelOrCategory.length > 2) {
            val categoryCode = levelOrCategory[2].digitToIntOrNull()
            if (categoryCode != null) {
                return mapCategory(categoryCode)
            }
        }

        val parts = levelOrCategory?.split('\n').orEmpty()
        if (parts.size > 1 && parts[1].startsWith("3.") && parts[1].length > 2) {
            val categoryCode = parts[1][2].digitToIntOrNull()
            if (categoryCode != null) {
                return mapCategory(categoryCode)
            }
        }

        return null
    }

    private fun mapCategory(categoryCode: Int): UnitCategory? = when (categoryCode) {
        1 -> UnitCategory.QualifiedBaseUnitsFromLevels1And2
        2 -> UnitCategory.SalesUnits
        3 -> UnitCategory.PackingUnits
        4 -> UnitCategory.ShippingAndTransportationUnits
        5 -> UnitCategory.IndustrySpecificUnits
        6 -> UnitCategory.InformationTechnologyUnits
        7 -> UnitCategory.IntegersNumbersRatios
        8 -> UnitCategory.MultiplesFractionsDecimals
        9 -> UnitCategory.Miscellaneous
        else -> null
    }


    fun parseRecommendation21UnitCodesList(file: Path = Recommendation21UnitsFile): List<UnEceUnitCodesRecommendation> {
        val workbook = HSSFWorkbook(file.inputStream())

        val annex5And6Sheet = workbook.getSheetAt(0) // or: workbook.getSheet("Annex V and VI")

        return parseRecommendation21Sheet(annex5And6Sheet)
    }

    private fun parseRecommendation21Sheet(sheet: HSSFSheet): List<UnEceUnitCodesRecommendation> {
        val headerRow = sheet.getRow(2)
        val headerCells = headerRow.cellIterator().asSequence().toList().associateBy { it.stringCellValue.replace('\n', ' ').replace("\r", "") }

        val codeColumnIndex = headerCells["Code"]!!.columnIndex
        val nameColumnIndex = headerCells["Name"]!!.columnIndex
        val descriptionColumnIndex = headerCells["Description"]!!.columnIndex
        val statusColumnIndex = headerCells["Status"]!!.columnIndex
        val numericCodeColumnIndex = headerCells["Numeric code"]!!.columnIndex

        return sheet.rowIterator().asSequence().toList().drop(3).map { row ->
            UnEceUnitCodesRecommendation(
                getValue(row, codeColumnIndex), getValue(row, nameColumnIndex), getValueOrNull(row, descriptionColumnIndex),
                mapStatus(getValueOrNull(row, statusColumnIndex)),

                annex = UnitAnnex.Annex5or6,
                cargoOrPackageNumericCode = getValueOrNull(row, numericCodeColumnIndex)
            )
        }.filter { it.code.isNotEmpty() } // there's one entry with an empty code and name, remove it
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
            else -> cell.stringCellValue.trim()
        }
    }

    private fun getValueOrNull(row: Row, columnIndex: Int?): String? =
        columnIndex?.let {
            row.getCell(columnIndex)?.let { // don't know why but Status cell in Recommendation No.21 list is sometimes null (instead of blank) -> so filter out these here to not let program crash
                getValue(row, columnIndex).takeUnless { it.isBlank() }
            }
        }

    private fun getIntOrNull(row: Row, columnIndex: Int?): Int? =
        getValueOrNull(row, columnIndex)?.toIntOrNull()

}