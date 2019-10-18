package objectPooling;

import restbuilder.RestRequest;

public class RestPool extends ObjectPool<RestRequest> {
    @Override
    RestRequest create() {
        return new RestRequest();
    }

    @Override
    boolean validate(RestRequest o) {
        return false;
    }

    @Override
    void dead(RestRequest o) {

    }
}
