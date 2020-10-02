import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoButton extends JButton {

    private String imageName;
    String status = "DICHT";

    //String met de imagename bijv. spiderman.jpg
    public void setImagename(String imageName) {
        this.imageName = imageName;
    }

    //geeft de imagename bijv. spiderman.jpg
    public String getImageName() {
        return this.imageName;
    }

    //zet status vast standaard DICHT maar veranderd
    public void setStatus(String status) {
        this.status = status;
        showImage();
    }

    //pakt status en geeft deze terug bijv. OPEN
    public String getStatus() {
        return this.status;
    }

    //als status DICHT zet image null
    //anders laat staan
    private void showImage() {
        if (status.equals("DICHT")) {
            ImageIcon icon = null;
            this.setIcon(icon);

        } else {
            ImageIcon icon = new ImageIcon(imageName);
            this.setIcon(icon);
        }
    }

}
