package Service;

import repository.KeyRepository;
import entity.Key;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import util.EnumKey;

@Service
public class KeyService {
    @Autowired
    private KeyRepository keyRepository;

    public Key createKey(Key key, EnumKey typeOfKey) {
        key.setTypeOfKey(typeOfKey);
        return keyRepository.save(key);
    }
}
