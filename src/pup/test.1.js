const puppeteer = require('puppeteer');


   puppeteer.launch({headless : false}).then(async () => {const page = await browser.newPage();
  
  await page.goto('http://google.com');
  await page.screenshot({path: 'example.png'});

  await browser.close();
});