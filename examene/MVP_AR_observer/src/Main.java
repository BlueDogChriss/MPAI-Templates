import presenter.Presenter;
import view.View;

public class Main {
    public static void main(String[] args) {
        View view= new View();
        Presenter presenter = new Presenter(view);
        presenter.afisareConsola();
    }
}