/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Adam
 */
public class KeyManager {
    
    public void saveKeyToFile(String path, byte[] key) throws IOException {
        File file = new File(path);
        file.getParentFile().mkdirs();
        
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(key);
        outputStream.flush();
        outputStream.close();
}
    
}
