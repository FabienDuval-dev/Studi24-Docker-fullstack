package Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ImageRepository;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public void displayImage(Long id) {
        imageRepository.findById(id).orElseThrow(() -> new RuntimeException("Image not found"));
    }
}

