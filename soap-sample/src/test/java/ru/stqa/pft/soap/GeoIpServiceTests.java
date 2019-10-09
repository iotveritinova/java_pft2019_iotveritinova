package ru.stqa.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {
//тест для webservicex пришлось отключить и написать альтернативный,
// http://www.webservicex.net/geoipservice.asmx?WSDL в данный момент не открывается ни в одном браузере
  @Test (enabled = false)
  public void testMyIp() {
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("78.24.41.155");
    geoIP.getCountryCode();
    assertEquals(geoIP.getCountryCode(), "RUS");
  }

  @Test
  public void testMyIpLava() {
    String ipLocation = new com.lavasoft.GeoIPService().getGeoIPServiceSoap12().getIpLocation20("78.24.41.155");
    assertEquals(ipLocation.substring(16, 18), "RU");
  }
  @Test(enabled = false)
  public void testInvalidIpLava() {
    String ipLocation = new com.lavasoft.GeoIPService().getGeoIPServiceSoap12().getIpLocation20("78.24.41.xxx");
    assertEquals(ipLocation.substring(16, 18), "RU");
  }
}
