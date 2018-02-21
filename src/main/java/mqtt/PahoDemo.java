package mqtt;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
public class PahoDemo {
    MqttClient client;

    public PahoDemo() {}

    public static void main(String[] args) {
        new PahoDemo().doDemo();
    }

    public void doDemo() {
        try {
            client = new MqttClient("tcp://phoenix02.dev.ts:1883", "pahomqttpublish1");
            client.connect();
            MqttMessage message = new MqttMessage();
            message.setPayload("A single message from first program".getBytes());
            client.publish("pahodemo/test", message);
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }
}
