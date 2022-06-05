package pl.adrian99.javaprobackend.utils;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;

public class AdminUtils {

    public static <T> T getEntityOrThrow(@NonNull Class<T> entityType,
                                         @NonNull JpaRepository<T, Long> repository,
                                         @NonNull Long id) throws EntityNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(entityType.getSimpleName() + " with id " + id + " not found"));
    }
}
