package library.app;


public class LibraryApp {

    public static void main(String[] args){
        System.out.println("=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("| Biblioteka vol1.0 |");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=");


        LibraryControl libraryControl = new LibraryControl();
        libraryControl.controlLoop();
    }

}
