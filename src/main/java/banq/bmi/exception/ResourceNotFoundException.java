package banq.bmi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String resourceUsername;
    private String fieldUsername;
    private Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceUsername = resourceName;
        this.fieldUsername = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceUsername() {
        return resourceUsername;
    }

    public String getFieldUsername() {
        return fieldUsername;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
