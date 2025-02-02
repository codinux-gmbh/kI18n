package net.codinux.i18n.unit

import kotlin.String

enum class UnitDisplayNameKey(
  val key: String,
  val englishName: String?,
) {
  Acre("acre", "acres"),
  AcreFoot("acre-foot", "acre-feet"),
  Ampere("ampere", "amperes"),
  ArcMinute("arc-minute", "arcminutes"),
  ArcSecond("arc-second", "arcseconds"),
  AstronomicalUnit("astronomical-unit", "astronomical units"),
  Atmosphere("atmosphere", "atmospheres"),
  Bar("bar", "bars"),
  Barrel("barrel", "barrels"),
  Beaufort("beaufort", "Beaufort"),
  Bit("bit", "bits"),
  BritishThermalUnit("british-thermal-unit", "British thermal units"),
  BuJp("bu-jp", null),
  Bushel("bushel", "bushels"),
  Byte("byte", "bytes"),
  Calorie("calorie", "calories"),
  Candela("candela", "candela"),
  Carat("carat", "carats"),
  Celsius("celsius", "degrees Celsius"),
  Centiliter("centiliter", "centiliters"),
  Centimeter("centimeter", "centimeters"),
  Century("century", "centuries"),
  Cho("cho", null),
  CubicCentimeter("cubic-centimeter", "cubic centimeters"),
  CubicFoot("cubic-foot", "cubic feet"),
  CubicInch("cubic-inch", "cubic inches"),
  CubicKilometer("cubic-kilometer", "cubic kilometers"),
  CubicMeter("cubic-meter", "cubic meters"),
  CubicMile("cubic-mile", "cubic miles"),
  CubicYard("cubic-yard", "cubic yards"),
  Cup("cup", "cups"),
  CupJp("cup-jp", null),
  CupMetric("cup-metric", "metric cups"),
  Dalton("dalton", "daltons"),
  Day("day", "days"),
  Decade("decade", "decades"),
  Deciliter("deciliter", "deciliters"),
  Decimeter("decimeter", "decimeters"),
  Degree("degree", "degrees"),
  DessertSpoon("dessert-spoon", "dessert spoons"),
  DessertSpoonImperial("dessert-spoon-imperial", "Imp. dessert spoons"),
  Dot("dot", "dots"),
  DotPerCentimeter("dot-per-centimeter", "dots per centimeter"),
  DotPerInch("dot-per-inch", "dots per inch"),
  Dram("dram", "drams"),
  Drop("drop", "drops"),
  Dunam("dunam", "dunams"),
  EarthMass("earth-mass", "Earth masses"),
  EarthRadius("earth-radius", "earth radius"),
  Electronvolt("electronvolt", "electronvolts"),
  Em("em", "typographic ems"),
  Fahrenheit("fahrenheit", "degrees Fahrenheit"),
  Fathom("fathom", "fathoms"),
  FluidOunce("fluid-ounce", "fluid ounces"),
  FluidOunceImperial("fluid-ounce-imperial", "Imp. fluid ounces"),
  Foodcalorie("foodcalorie", "Calories"),
  Foot("foot", "feet"),
  Fun("fun", null),
  Furlong("furlong", "furlongs"),
  GForce("g-force", "g-force"),
  Gallon("gallon", "gallons"),
  GallonImperial("gallon-imperial", "Imp. gallons"),
  GasolineEnergyDensity("gasoline-energy-density", "of gasoline equivalent"),
  Generic("generic", "degrees temperature"),
  Gigabit("gigabit", "gigabits"),
  Gigabyte("gigabyte", "gigabytes"),
  Gigahertz("gigahertz", "gigahertz"),
  Gigawatt("gigawatt", "gigawatts"),
  Grain("grain", "grains"),
  Gram("gram", "grams"),
  Hectare("hectare", "hectares"),
  Hectoliter("hectoliter", "hectoliters"),
  Hectopascal("hectopascal", "hectopascals"),
  Hertz("hertz", "hertz"),
  Horsepower("horsepower", "horsepower"),
  Hour("hour", "hours"),
  Inch("inch", "inches"),
  InchOfhg("inch-ofhg", "inches of mercury"),
  Item("item", "items"),
  Jigger("jigger", "jiggers"),
  JoJp("jo-jp", null),
  Joule("joule", "joules"),
  Karat("karat", "karats"),
  Kelvin("kelvin", "kelvins"),
  Ken("ken", null),
  Kilobit("kilobit", "kilobits"),
  Kilobyte("kilobyte", "kilobytes"),
  Kilocalorie("kilocalorie", "kilocalories"),
  Kilogram("kilogram", "kilograms"),
  Kilohertz("kilohertz", "kilohertz"),
  Kilojoule("kilojoule", "kilojoules"),
  Kilometer("kilometer", "kilometers"),
  KilometerPerHour("kilometer-per-hour", "kilometers per hour"),
  Kilopascal("kilopascal", "kilopascals"),
  Kilowatt("kilowatt", "kilowatts"),
  KilowattHour("kilowatt-hour", "kilowatt-hours"),
  KilowattHourPer100Kilometer("kilowatt-hour-per-100-kilometer", "kilowatt-hours per 100 kilometers"),
  Knot("knot", "knots"),
  Koku("koku", null),
  Kosaji("kosaji", null),
  LightSpeed("light-speed", "light"),
  LightYear("light-year", "light years"),
  Liter("liter", "liters"),
  LiterPer100Kilometer("liter-per-100-kilometer", "liters per 100 kilometers"),
  LiterPerKilometer("liter-per-kilometer", "liters per kilometer"),
  Lumen("lumen", "lumen"),
  Lux("lux", "lux"),
  Megabit("megabit", "megabits"),
  Megabyte("megabyte", "megabytes"),
  Megahertz("megahertz", "megahertz"),
  Megaliter("megaliter", "megaliters"),
  Megapascal("megapascal", "megapascals"),
  Megapixel("megapixel", "megapixels"),
  Megawatt("megawatt", "megawatts"),
  Meter("meter", "meters"),
  MeterPerSecond("meter-per-second", "meters per second"),
  MeterPerSquareSecond("meter-per-square-second", "meters per second squared"),
  Microgram("microgram", "micrograms"),
  Micrometer("micrometer", "micrometers"),
  Microsecond("microsecond", "microseconds"),
  Mile("mile", "miles"),
  MilePerGallon("mile-per-gallon", "miles per gallon"),
  MilePerGallonImperial("mile-per-gallon-imperial", "miles per Imp. gallon"),
  MilePerHour("mile-per-hour", "miles per hour"),
  MileScandinavian("mile-scandinavian", "miles-scandinavian"),
  Milliampere("milliampere", "milliamperes"),
  Millibar("millibar", "millibars"),
  Milligram("milligram", "milligrams"),
  MilligramOfglucosePerDeciliter("milligram-ofglucose-per-deciliter", "milligrams per deciliter"),
  Milliliter("milliliter", "milliliters"),
  Millimeter("millimeter", "millimeters"),
  MillimeterOfhg("millimeter-ofhg", "millimeters of mercury"),
  MillimolePerLiter("millimole-per-liter", "millimoles per liter"),
  Millisecond("millisecond", "milliseconds"),
  Milliwatt("milliwatt", "milliwatts"),
  Minute("minute", "minutes"),
  Mole("mole", "moles"),
  Month("month", "months"),
  Nanometer("nanometer", "nanometers"),
  Nanosecond("nanosecond", "nanoseconds"),
  NauticalMile("nautical-mile", "nautical miles"),
  Newton("newton", "newtons"),
  NewtonMeter("newton-meter", "newton-meters"),
  Night("night", "nights"),
  Ohm("ohm", "ohms"),
  Osaji("osaji", null),
  Ounce("ounce", "ounces"),
  OunceTroy("ounce-troy", "troy ounces"),
  Parsec("parsec", "parsecs"),
  Pascal("pascal", "pascals"),
  Percent("percent", "percent"),
  Permille("permille", "permille"),
  Permillion("permillion", "parts per million"),
  Permyriad("permyriad", "permyriad"),
  Petabyte("petabyte", "petabytes"),
  Picometer("picometer", "picometers"),
  Pinch("pinch", "pinches"),
  Pint("pint", "pints"),
  PintMetric("pint-metric", "metric pints"),
  Pixel("pixel", "pixels"),
  PixelPerCentimeter("pixel-per-centimeter", "pixels per centimeter"),
  PixelPerInch("pixel-per-inch", "pixels per inch"),
  Point("point", "points"),
  PortionPer1e9("portion-per-1e9", "parts per billion"),
  Pound("pound", "pounds"),
  PoundForce("pound-force", "pounds of force"),
  PoundForceFoot("pound-force-foot", "pound-force-feet"),
  PoundForcePerSquareInch("pound-force-per-square-inch", "pounds-force per square inch"),
  Quart("quart", "quarts"),
  QuartImperial("quart-imperial", "Imp. quarts"),
  Quarter("quarter", "quarters"),
  Radian("radian", "radians"),
  Revolution("revolution", "revolutions"),
  RiJp("ri-jp", null),
  Rin("rin", null),
  Sai("sai", null),
  SeJp("se-jp", null),
  Second("second", "seconds"),
  Shaku("shaku", null),
  ShakuCloth("shaku-cloth", null),
  ShakuLength("shaku-length", null),
  SolarLuminosity("solar-luminosity", "solar luminosities"),
  SolarMass("solar-mass", "solar masses"),
  SolarRadius("solar-radius", "solar radii"),
  SquareCentimeter("square-centimeter", "square centimeters"),
  SquareFoot("square-foot", "square feet"),
  SquareInch("square-inch", "square inches"),
  SquareKilometer("square-kilometer", "square kilometers"),
  SquareMeter("square-meter", "square meters"),
  SquareMile("square-mile", "square miles"),
  SquareYard("square-yard", "square yards"),
  Stone("stone", "stones"),
  Sun("sun", null),
  Tablespoon("tablespoon", "tablespoons"),
  Teaspoon("teaspoon", "teaspoons"),
  Terabit("terabit", "terabits"),
  Terabyte("terabyte", "terabytes"),
  ThermUs("therm-us", "US therms"),
  ToJp("to-jp", null),
  Ton("ton", "tons"),
  Tonne("tonne", "metric tons"),
  Volt("volt", "volts"),
  Watt("watt", "watts"),
  Week("week", "weeks"),
  Yard("yard", "yards"),
  Year("year", "years"),
  ;

  companion object {
    fun forKey(key: String): UnitDisplayNameKey = UnitDisplayNameKey.entries.first { it.key == key }
  }
}
