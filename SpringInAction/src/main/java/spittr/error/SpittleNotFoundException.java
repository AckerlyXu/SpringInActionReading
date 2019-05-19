package spittr.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="没有这样的spitter")
public class SpittleNotFoundException extends RuntimeException {

}
