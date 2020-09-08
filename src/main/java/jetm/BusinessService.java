package jetm;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import etm.core.monitor.NestedMonitor;

public class BusinessService {

    private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();

    public void someMethod() {

        EtmPoint point = etmMonitor.createPoint("BusinessService:someMethod");

        try {

            //
            // some business code
            //
            Thread.sleep((long) (10d * Math.random()));
            nestedMethod();

        }  catch (InterruptedException e) {
            // igored
        }finally {
            point.collect();
        }
    }

    public void nestedMethod() {

        EtmPoint point = etmMonitor.createPoint("BusinessService:nestedMethod");

        try {

            //
            // some business code
            //
            Thread.sleep((long) (15d * Math.random()));

        } catch (InterruptedException e) {
            // ignored
        } finally {
            point.collect();
        }
    }
}
