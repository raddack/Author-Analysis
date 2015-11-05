/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aagui;

import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;


/**
 *
 * @author owner
 */
public class main {
    
public  void main(String[] arg){
 int returnVal = fileChooser.showOpenDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        file = fileChooser.getSelectedFile();
        filename = file.getName();
        try {
          // What to do with the file, e.g. display it in a TextArea
          new FileReader( file.getPath());
          FilenameUnkown.setText(file.getPath());
        } catch (IOException ex) {
          System.out.println("problem accessing file"+file.getAbsolutePath());
        }
    } else {
        System.out.println("File access cancelled by user.");
    }
}



}
