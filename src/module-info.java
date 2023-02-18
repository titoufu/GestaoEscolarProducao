module TestJasperFx {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires jasperreports;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml,javafx.controls;
	opens telas to javafx.graphics, javafx.fxml,javafx.controls;
}
