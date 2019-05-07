const puppeteer = require('puppeteer');
puppeteer.launch({headless:false}).then(async browser =>{
const page=await browser.newPage();
await page.goto("http://www.amazon.com");
await page.focus('#twotabsearchtextbox');
await page.keyboard.type('iphone');
await page.click('value="Go"')
// await browser.close();
    }
);