package projeto.crud.utils;

import java.io.File;

import javafx.application.Application;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class PopUpDiretorioUtils extends Application{

	//private Desktop desktop = Desktop.getDesktop();
    private String path;

    @Override
    public void start(Stage stage) {
        final DirectoryChooser directoryChooser = new DirectoryChooser();
	    configureFileChooser(directoryChooser);
        File file = directoryChooser.showDialog(stage);
        if (file != null) {
              //openFile(file);
              this.path = file.getAbsolutePath();
        }
    }

    private static void configureFileChooser(final DirectoryChooser directoryChooser){
        	directoryChooser.setTitle("Documentos");
        	directoryChooser.setInitialDirectory(
            new File(System.getProperty("user.home"))
        );
    }

    /*
    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
            		DiretorioUtils.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }
    */
    public String getPath() {
		return path;
	}


}
