package li.cil.oc.integration.computercraft

import li.cil.oc.api.Driver
import li.cil.oc.integration.ModProxy
import li.cil.oc.integration.Mods

object ModComputerCraft extends ModProxy {
  override def getMod = Mods.ComputerCraft

  override def initialize() {
    PeripheralProvider.init()

    Driver.add(DriverComputerCraftMedia)

    try {
      val driver = new DriverPeripheral()
      if (driver.isValid) {
        Driver.add(new ConverterLuaObject)
        Driver.add(driver)
      }
    }
    catch {
      case ignored: Throwable =>
    }
  }
}