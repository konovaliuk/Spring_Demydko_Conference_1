package one.servises.controllerservices;


public interface ControllerService {
    /**
     * This method is used in Controllers to encapsulate some logic.
     * @return string that can be used either to identify the target page
     * or define some message.
     */
    String handle();
}
