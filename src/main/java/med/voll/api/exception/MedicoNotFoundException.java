package med.voll.api.exception;

import jakarta.persistence.EntityNotFoundException;

public class MedicoNotFoundException extends EntityNotFoundException {
    public MedicoNotFoundException(String message) {
        super(message);
    }
}
