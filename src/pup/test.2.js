  const puppeteer = require('puppeteer');
  const iPhone = puppeteer.devices['iPhone 6'];
  
  puppeteer.launch({devtools  : true}).then(async browser => {
    const page = await browser.newPage();
    await page.emulate(iPhone);
    await page.evaluate(() => window.open('https://www.google.com/'));
    const newWindowTarget = await browser.waitForTarget(target => target.url() === 'https://www.google.com/');
    // other actions...
    await browser.close();
  });