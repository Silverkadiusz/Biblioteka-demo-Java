package library.io.file;
import library.exception.NoSuchFileTypeException;
import library.io.ConsolePrinter;
import library.io.DataReader;




public class FileManagerBuild {

  private final ConsolePrinter printer;
  private final DataReader reader;

    public FileManagerBuild(ConsolePrinter printer, DataReader reader) {
        this.printer = printer;
        this.reader = reader;
    }


    public FileManager build() {

        printer.printLine("Wybierz format danych:");
        FileType fileType = getFileType();
        switch (fileType) {
            case CSV:
                return new CsvFileManager();
            default:
                throw new NoSuchFileTypeException("Nieobsługiwany typ danych");
        }
    }

    private FileType getFileType() {
        boolean typeOk = false;
        FileType result = null;

        do {
            printTypes();
            String type = reader.getString().toUpperCase();
            try {
                result = FileType.valueOf(type);
                typeOk = true;

            } catch (IllegalArgumentException e) {
                printer.printLine("Nieobsługiwany typ danych, wybierz ponownie");
            }
        }  while (!typeOk);
        return result;
    }

    private void printTypes() {
    for(FileType value :FileType.values()){
        printer.printLine(value.name());
        }
    }

}
