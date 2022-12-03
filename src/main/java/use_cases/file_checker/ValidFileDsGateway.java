package use_cases.file_checker;

public interface ValidFileDsGateway {
    boolean fileExists();
    boolean isValid();
}
