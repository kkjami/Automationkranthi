const puppeteer = require('puppeteer');
const devices = require('puppeteer/DeviceDescriptors');
const iPhonex = devices['iPhone X'];
  const options = {
  path: 'amazon-header.png',
  fullPage: false,
  clip: {
    x: 0,
    y: 0,
    width: 1280,
    height: 150
  }
}

const options1 = {
    path: 'homedepot-iphoneX.png'
}
puppeteer.launch({headless:false}).then(async browser => {
  const page = await browser.newPage();
  await page.emulate(iPhonex);
//   await page.setViewport({ width: 1280, height: 800 })
  await page.goto('https://www.amazon.com');
  await page.focus('#nav-search-keywords');
  await page.keyboard.type("hello");
  const title = await page.title();
  console.log(title);
  await page.screenshot(options1);
  await browser.close();
});