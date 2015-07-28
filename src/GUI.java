import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GUI extends Application
{
    Stage window;
    Scene homeScene = new Scene(homePane(), 1024, 768);
    Scene addEmployeesScene;
    Scene viewEmployeeListScene;
    Scene viewEmployeeScene;
    Scene editEmployeeScene;
    Scene calcPayrollScene;
    static String [] calcPayLabels = {"First Name","Last Name","Hours","Wages","Gross Income","Federal Tax","State Tax","SSI","Medicare","Net Income"};

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;
        window.setMinHeight(768);
        window.setMinWidth(1024);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        window.setX(primaryScreenBounds.getMinX());
        window.setY(primaryScreenBounds.getMinY());
        window.setWidth(primaryScreenBounds.getWidth());
        window.setHeight(primaryScreenBounds.getHeight());
        window.setTitle("IPP v0.1");
        window.setScene(homeScene);
        window.show();
    }

    // Main navigation button creation
    public Button createNavButton(String name)
    {
        Button btn = new Button(name);
        btn.setPrefWidth(200);
        btn.setPadding(new Insets(10));
        return btn;
    }

    // Main pane button creation
    public Button createMainButton(String name)
    {
        Button btn = new Button(name);
        btn.setPrefWidth(150);
        btn.setPadding(new Insets(10));
        return btn;
    }

    public Label createFormLabel(String name, TextField txtField)
    {
        Label lbl = new Label(name);
        lbl.setPrefHeight(txtField.getPrefHeight());
        lbl.setPadding(new Insets(10, 10, 10, 10));
        return lbl;
    }

    public TextField createFormTextField(boolean isEditable)
    {
        TextField txtField = new TextField();
        txtField.setPrefHeight(35);
        txtField.setPadding(new Insets(10, 0, 10, 10));
        if(!isEditable)
            txtField.setEditable(false);
        return txtField;
    }

    public HBox createForm(){

        Label employeeID = new Label("Employee ID:");
        TextField employID = new TextField("0000000");
        employID.setPrefHeight(35);

        Label firstName = new Label("First Name:");
        TextField fName = new TextField ();
        fName.setPrefHeight(35);

        Label lastName = new Label("Last Name:");
        TextField lName = new TextField ();
        lName.setPrefHeight(35);

        Label DOB = new Label("Date of Birth:");
        TextField dateB = new TextField ("MM/DD/YYYY");
        dateB.setPrefHeight(35);

        Label socialSecurity = new Label("SSN:");
        TextField ssn = new TextField ("***-**-****");
        ssn.setPrefHeight(35);

        Label withold = new Label("Withold Amount:");
        TextField wth = new TextField ();
        wth.setPrefHeight(35);

        Label maritalStatus = new Label("Marital Status:");
        TextField mStatus = new TextField ();
        mStatus.setPrefHeight(35);

        Label wageR = new Label("Wage Rate:");
        TextField wage = new TextField ();
        wage.setPrefHeight(35);

        VBox holder = new VBox();
        holder.setAlignment(Pos.CENTER);
        holder.getChildren().addAll(employeeID, employID, firstName, fName, lastName, lName, DOB, dateB, socialSecurity, ssn, withold, wth, maritalStatus,mStatus,wageR,wage);

        HBox form = new HBox();
        form.getChildren().addAll(holder);


        return form;
    }

    public VBox createVBoxNav()
    {
        Button home = createNavButton("Home");
        VBox vBoxNav = new VBox();
        vBoxNav.getChildren().addAll(home);
        vBoxNav.setPrefWidth(200);
        vBoxNav.setStyle("-fx-background-color: steelblue");
        vBoxNav.setPadding(new Insets(15));
        vBoxNav.setAlignment(Pos.TOP_CENTER);
        vBoxNav.setSpacing(5);
        homeOnMouseClick(home);

        return vBoxNav;
    }

    public HBox createHBoxTitle(String title)
    {
        HBox hBoxTop = new HBox();
        Text txtTitle = new Text(title);

        txtTitle.setStyle("-fx-font-size: 18");
        hBoxTop.getChildren().addAll(txtTitle);
        hBoxTop.setStyle("-fx-background-color: LightGray");
        hBoxTop.setPrefHeight(40);
        hBoxTop.setAlignment(Pos.CENTER);

        return hBoxTop;
    }

    public VBox createTableView()
    {
        TableView table = new TableView();
        Label lbl = new Label("Employee List");

        TableColumn EID = new TableColumn("Employee ID");
        TableColumn fName = new TableColumn("First Name");
        TableColumn lName = new TableColumn("Last Name");
        table.getColumns().addAll(EID, fName, lName);
        table.setEditable(false);
        table.setMaxWidth(400);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 0, 10));
        vbox.getChildren().addAll(lbl, table);

        return vbox;
    }
    public HBox createTextFields(){

        Label firstName = new Label("First Name:");
        TextField fName = new TextField ();
        //fName.setPrefHeight(35);

        Label lastName = new Label("Last Name:");
        TextField lName = new TextField ();
        //lName.setPrefHeight(35);

        Label hours = new Label("Hours:");
        TextField hoursT = new TextField ();
        //hoursT.setPrefHeight(35);

        Label wages = new Label("Wages:");
        TextField wagesT = new TextField ();
        //wagesT.setPrefHeight(35);

        Label gross = new Label("Gross Income:");
        TextField grossT = new TextField ();
        //grossT.setPrefHeight(35);

        Label  fTax = new Label("Federal Tax:");
        TextField  fTaxT= new TextField ();
        //fTaxT.setPrefHeight(35);

        Label state = new Label("State Tax:");
        TextField stateT = new TextField ();
        //stateT.setPrefHeight(35);

        Label ssi = new Label("SSI:");
        TextField ssiT = new TextField ();
        //stateT.setPrefHeight(35);

        Label medicare = new Label("Medicare:");
        TextField medicareT = new TextField ();
        //medicareT.setPrefHeight(35);

        Label net = new Label("Net:");
        TextField netT = new TextField ();
        //netT.setPrefHeight(35);

        VBox form = new VBox();
        form.setAlignment(Pos.CENTER);
        form.getChildren().addAll(firstName, fName, lastName, lName,hours,hoursT,wages,wagesT,gross,grossT,fTax,fTaxT,state,stateT,ssi,ssiT,medicare,medicareT,net,netT);

        HBox holder = new HBox();
        holder.getChildren().addAll(form);


        return holder;
    }
    // This is the home page template that will be loaded whenever home is clicked.
    public BorderPane homePane()
    {
        BorderPane border = new BorderPane();
        VBox vBoxNav = createVBoxNav();
        HBox hBoxTop = createHBoxTitle("Home");
        HBox hBoxMainBot = new HBox();

        Button viewEmployees = createMainButton("View Employees");
        Button addEmployees = createMainButton("Add Employee");
        Button editEmployees = createMainButton("Edit Employee");

        border.setCenter(hBoxMainBot);
        border.setLeft(vBoxNav);
        border.setTop(hBoxTop);

        hBoxMainBot.getChildren().addAll(viewEmployees, addEmployees, editEmployees);
        hBoxMainBot.setAlignment(Pos.CENTER);
        hBoxMainBot.setSpacing(25);

        viewEmployees.setOnMouseClicked((e -> {
            System.out.println("View Employee List Clicked");
            displayViewEmployeeListWindow();
        }
        ));

        addEmployees.setOnMouseClicked((e -> {
            System.out.println("Add Employees Clicked");
            displayAddEmployeeWindow();
        }
        ));

        editEmployees.setOnMouseClicked((e -> {
            System.out.println("Edit Employees Clicked");
            displayEditEmployeeWindow();
        }
        ));
        return border;
    }

    public BorderPane addEmployeePane()
    {
        BorderPane border = new BorderPane();
        VBox vBoxNav = createVBoxNav();
        HBox hBoxTop = createHBoxTitle("Add Employees");

        Button btnBack = createNavButton("Back");
        Button btnSave = createNavButton("Save");
        Button btnCancel = createNavButton("Cancel");
        vBoxNav.getChildren().addAll(btnBack, btnSave, btnCancel);

        border.setLeft(vBoxNav);
        border.setTop(hBoxTop);
        homeOnMouseClick(btnCancel);

        HBox form = createForm();
        form.setPrefWidth(400);
        form.setAlignment(Pos.CENTER);
        border.setCenter(form);

        return border;
    }

    public BorderPane viewEmployeeListPane()
    {
        BorderPane border = new BorderPane();
        VBox vBoxNav = createVBoxNav();
        HBox hBoxTop = createHBoxTitle("Employee List");
        HBox hBoxBot = new HBox();
        VBox vBoxTable = createTableView();
        VBox container = new VBox();

        Button btnBack = createNavButton("Back");
        Button btnCalcPay = createMainButton("Calculate Payroll");
        Button btnViewEmployeeInfo = createMainButton("View Employee Info");

        vBoxNav.getChildren().addAll(btnBack);
        hBoxBot.setAlignment(Pos.BASELINE_CENTER);
        hBoxBot.getChildren().addAll(btnCalcPay, btnViewEmployeeInfo);
        vBoxTable.setAlignment(Pos.CENTER);
        container.getChildren().addAll(vBoxTable, hBoxBot);
        vBoxTable.setSpacing(10);
        hBoxBot.setSpacing(10);
        container.setSpacing(50);
        container.setAlignment(Pos.CENTER);

        border.setCenter(container);
        border.setLeft(vBoxNav);
        border.setTop(hBoxTop);

        btnCalcPay.setOnMouseClicked((e -> {
            System.out.println("Calculate Payment Button Clicked");
            displayCalcPayrollWindow();
        }
        ));

        btnViewEmployeeInfo.setOnMouseClicked((e -> {
            System.out.println("View Employee Info Clicked");
            displayViewEmployeeWindow();
        }
        ));

        return border;
    }

    public BorderPane viewEmployeePane()
    {
        BorderPane border = new BorderPane();
        VBox vBoxNav = createVBoxNav();
        HBox hBoxTop = createHBoxTitle("Employee Information");
        HBox hBoxBot = new HBox();
        HBox form = new HBox();
        VBox container = new VBox();
        VBox lblCol = new VBox();
        VBox txtFieldCol = new VBox();

        Button btnBack = createNavButton("Back");
        Button btnCancel = createNavButton("Cancel");
        vBoxNav.getChildren().addAll(btnBack, btnCancel);
        Button btnCalcPay = createMainButton("Calculate Payroll");
        Button btnEditEmployee = createMainButton("Edit Employee");
        hBoxBot.setSpacing(10);
        hBoxBot.getChildren().addAll(btnCalcPay, btnEditEmployee);

        TextField eID = createFormTextField(false);
        TextField fName = createFormTextField(false);
        TextField lName = createFormTextField(false);
        TextField dateB = createFormTextField(false);
        TextField ssn = createFormTextField(false);
        TextField wth = createFormTextField(false);
        TextField mStatus = createFormTextField(false);
        TextField wage = createFormTextField(false);

        Label employeeID = createFormLabel("Employee ID:", eID);
        Label firstName = createFormLabel("First Name:", fName);
        Label lastName = createFormLabel("Last Name:", fName);
        Label DOB = createFormLabel("Date of Birth:", dateB);
        Label socialSecurity = createFormLabel("SSN:", ssn);
        Label withhold = createFormLabel("Withhold Amount:", wth);
        Label maritalStatus = createFormLabel("Marital Status:", mStatus);
        Label wageR = createFormLabel("Wage Rate:", wage);

        lblCol.getChildren().addAll(employeeID, firstName, lastName, DOB, socialSecurity, withhold, maritalStatus, wageR);
        txtFieldCol.getChildren().addAll(eID, fName, lName, dateB, ssn, wth, mStatus, wage);
        form.getChildren().addAll(lblCol, txtFieldCol);
        container.getChildren().addAll(form, hBoxBot);

        lblCol.setSpacing(10);
        txtFieldCol.setSpacing(10);
        hBoxBot.setAlignment(Pos.BASELINE_CENTER);
        form.setAlignment(Pos.CENTER);
        lblCol.setAlignment(Pos.CENTER);
        txtFieldCol.setAlignment(Pos.CENTER);
        container.setAlignment(Pos.CENTER);
        container.setSpacing(50);
        border.setLeft(vBoxNav);
        border.setTop(hBoxTop);
        border.setCenter(container);


        homeOnMouseClick(btnCancel);
        btnCalcPay.setOnMouseClicked((e -> {
            System.out.println("Calculate Payroll Button Clicked");
            displayCalcPayrollWindow();
        }
        ));

        btnEditEmployee.setOnMouseClicked((e -> {
            System.out.println("Edit Employees Clicked");
            displayEditEmployeeWindow();
        }
        ));

        return border;
    }

    public BorderPane editEmployeePane()
    {
        BorderPane border = new BorderPane();
        VBox vBoxNav = createVBoxNav();
        HBox hBoxTop = createHBoxTitle("Employee Information");
        HBox hBoxBot = new HBox();
        HBox form = new HBox();
        VBox container = new VBox();
        VBox lblCol = new VBox();
        VBox txtFieldCol = new VBox();

        Button btnBack = createNavButton("Back");
        Button btnSave = createMainButton("Save");
        Button btnCancel = createMainButton("Cancel");
        vBoxNav.getChildren().addAll(btnBack);
        hBoxBot.getChildren().addAll(btnSave, btnCancel);

        TextField eID = createFormTextField(true);
        TextField fName = createFormTextField(true);
        TextField lName = createFormTextField(true);
        TextField dateB = createFormTextField(true);
        TextField ssn = createFormTextField(true);
        TextField wth = createFormTextField(true);
        TextField mStatus = createFormTextField(true);
        TextField wage = createFormTextField(true);

        Label employeeID = createFormLabel("Employee ID:", eID);
        Label firstName = createFormLabel("First Name:", fName);
        Label lastName = createFormLabel("Last Name:", fName);
        Label DOB = createFormLabel("Date of Birth:", dateB);
        Label socialSecurity = createFormLabel("SSN:", ssn);
        Label withhold = createFormLabel("Withhold Amount:", wth);
        Label maritalStatus = createFormLabel("Marital Status:", mStatus);
        Label wageR = createFormLabel("Wage Rate:", wage);

        lblCol.getChildren().addAll(employeeID, firstName, lastName, DOB, socialSecurity, withhold, maritalStatus, wageR);
        txtFieldCol.getChildren().addAll(eID, fName, lName, dateB, ssn, wth, mStatus, wage);
        form.getChildren().addAll(lblCol, txtFieldCol);
        container.getChildren().addAll(form, hBoxBot);

        hBoxBot.setSpacing(10);
        lblCol.setSpacing(10);
        txtFieldCol.setSpacing(10);
        hBoxBot.setAlignment(Pos.BASELINE_CENTER);
        form.setAlignment(Pos.CENTER);
        lblCol.setAlignment(Pos.CENTER);
        txtFieldCol.setAlignment(Pos.CENTER);
        container.setAlignment(Pos.CENTER);
        container.setSpacing(50);
        border.setLeft(vBoxNav);
        border.setTop(hBoxTop);
        border.setCenter(container);
        homeOnMouseClick(btnCancel);

        return border;
    }

    public BorderPane calcPayrollPane()
    {
        BorderPane border = new BorderPane();
        VBox vBoxNav = createVBoxNav();
        HBox hBoxTop = createHBoxTitle("Calculate Payroll");

        Button btnBack = createNavButton("Back");
        Button btnSave = createNavButton("Save");
        Button btnCancel = createNavButton("Cancel");
        vBoxNav.getChildren().addAll(btnBack, btnSave, btnCancel);

        border.setLeft(vBoxNav);
        border.setTop(hBoxTop);

        homeOnMouseClick(btnCancel);


        HBox form = createTextFields();
        form.setPrefWidth(400);
        form.setAlignment(Pos.CENTER);;
        border.setCenter(form);

        return border;
    }

    public void homeOnMouseClick(Button btn)
    {
        btn.setOnMouseClicked((e -> {
            System.out.println("Home Button Clicked");
            displayHomeWindow();
        }
        ));
    }

    public void displayHomeWindow()
    {
        homeScene = new Scene(homePane(), window.getWidth(), window.getHeight());
        window.setScene(homeScene);
    }

    public void displayAddEmployeeWindow()
    {
        addEmployeesScene = new Scene(addEmployeePane(), window.getWidth(), window.getHeight());
        window.setScene(addEmployeesScene);
    }

    public void displayViewEmployeeListWindow()
    {
        viewEmployeeListScene = new Scene(viewEmployeeListPane(), window.getWidth(), window.getHeight());
        window.setScene(viewEmployeeListScene);
    }

    public void displayViewEmployeeWindow()
    {
        viewEmployeeScene = new Scene(viewEmployeePane(), window.getWidth(), window.getHeight());
        window.setScene(viewEmployeeScene);
    }

    public void displayEditEmployeeWindow()
    {
        editEmployeeScene = new Scene(editEmployeePane(), window.getWidth(), window.getHeight());
        window.setScene(editEmployeeScene);
    }

    public void displayCalcPayrollWindow()
    {
        calcPayrollScene = new Scene(calcPayrollPane(), window.getWidth(), window.getHeight());
        window.setScene(calcPayrollScene);
    }
}
