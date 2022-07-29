package electro.by.gecko.vitrine.service.file;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {
    void init();

    /**
     * Store a file in an upload directory
     * @param file
     * @return The path of the file stored
     */
    String store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
