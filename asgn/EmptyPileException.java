package week10;

import java.util.NoSuchElementException;

/**
 * EmptyPileException class extends NoSuchElementException.
 * @author James Pettitt 2018.
 */
public class EmptyPileException extends NoSuchElementException {
    /**serialVerisonUID. */
    private static final long serialVersionUID = 1L;

    /**
     *This method passes the msg to super to indicate that the element.
     being requested does not exist.
     *@param msg The message to be printed out if the pile is empty.
     */
    public EmptyPileException(String msg) {
        super(msg);
    }
}
