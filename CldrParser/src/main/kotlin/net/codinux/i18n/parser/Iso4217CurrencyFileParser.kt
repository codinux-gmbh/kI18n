package net.codinux.i18n.parser

import net.codinux.i18n.model.Iso4217CurrencyEntry
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.nio.file.Path
import kotlin.io.path.inputStream

class Iso4217CurrencyFileParser {
    
    fun parse(iso4217CurrencyFile: Path, isCurrentCurrency: Boolean): List<Iso4217CurrencyEntry> {
        val workbook = HSSFWorkbook(iso4217CurrencyFile.inputStream())
        val sheet = workbook.getSheetAt(0)

        // the first three rows are bla bla, the fourth is the header
        return sheet.rowIterator().asSequence().toList().drop(4).mapNotNull { row ->
            val country = row.getCell(0).stringCellValue
            val currency = row.getCell(1).stringCellValue
            val isoCode = row.getCell(2).stringCellValue.takeUnless { it.isBlank() }

            if (isoCode == null) { // there are three "No universal currency" which have neither a alpha3 code nor a numeric code nor a minor unit
                return@mapNotNull null
            }

            val numericCode = row.getCell(3).stringCellValue.toIntOrNull() // there are three funds in historic denominations that don't have a numeric code

            val minorUnit = if (isCurrentCurrency) {// some funds have "N.A." in ther "Minor unit" column
                row.getCell(4).stringCellValue.toIntOrNull()
            } else null

            val withdrawalDate = if (isCurrentCurrency == false) row.getCell(4).stringCellValue else null

            Iso4217CurrencyEntry(country, currency, isoCode, numericCode, isCurrentCurrency, minorUnit, withdrawalDate)
        }
    }

}