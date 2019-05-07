const puppeteer = require('puppeteer');
const chromepath=puppeteer.executablePath();
const endpoint=browser.wsEndpoint()
(async () => {
  const browser = await puppeteer.launch({headless : false});
  const context=browser.createIncognitoBrowserContext();
  const page = await context.newPage();
  await page.goto('http://google.com');
  await page.screenshot({path: 'example.png'});
  try {
    await page.waitForSelector('.foo');
  } catch (e) {
    if (e instanceof puppeteer.errors.TimeoutError) {
      // Do something if this is a timeout.
    }
  }

  const browserWSEndpoint = browser.wsEndpoint();
  // Disconnect puppeteer from Chromium
  browser.disconnect();

  // Use the endpoint to reestablish a connection
  const browser2 = await puppeteer.connect({browserWSEndpoint});
  // Close Chromium
  await browser2.close();
})();