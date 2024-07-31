import java.net.URL;

import controller.LoginController;
import dao.custom.UserDao;
import dao.custom.Impl.UserDaoImpl;
import db.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.custom.UserService;
import service.custom.Impl.UserServiceImpl;

public class App extends Application{  
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource =getClass().getResource("./view/Login.fxml");//fxml file resource
        FXMLLoader loader = new FXMLLoader(resource);
        Parent root = loader.load();


        LoginController controller = loader.getController();

        UserDao userDao = new UserDaoImpl(DBConnection.getInstance().getConnection());
        UserService userService = new UserServiceImpl(userDao);
        controller.setUserService(userService);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setTitle("Library Management System");

    }

}

