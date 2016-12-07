package observer;


public class Example {
}

interface XXXListener {
    void onSuccess();
    void onFailure(String message);
}

class Client implements XXXListener {
    Server server;

    void call() {
        server.sendMail(this);
    }

    @Override
    public void onSuccess() {
        System.out.println("PASS");
    }

    @Override
    public void onFailure(String message) {
        System.out.println("FAIL : " + message);
    }
}

class Server {
    public void sendMail(XXXListener listener) {
        if(true) {
            listener.onSuccess();
        } else {
            listener.onFailure("Error something");
        }
    }
}
