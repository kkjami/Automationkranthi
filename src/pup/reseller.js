const puppeteer = require('puppeteer');
puppeteer.launch({headless:false}).then(async browser =>{
const page=await browser.newPage();
await page.goto("http://10.10.0.207:8081/progressive-app/#/");
await page.type('[data-testid="reseller-login-aliv-agent-id"]','dist1');
//await page.type({xpath:"//input[@name='alivAgentId']"} , 'dist1');
//({xpath:“//input[@name=‘alivAgentId’]“} , “dist1”);
await page.keyboard.type('iphone');
await page.click('value="Go"');
await browser.close();
    }
);